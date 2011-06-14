/*
 * IcelandGameEngine.java
 *
 * Created on 2 novembre 2006, 16.40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.iceland;

import it.denzosoft.mobile.common.Rectangle;
import it.denzosoft.mobile.common.util.FixedSizeList;
import it.denzosoft.mobile.common.util.Logger;
import it.denzosoft.mobile.graphicEngine.GameEngine;
import it.denzosoft.mobile.graphicEngine.GraphicObject;
import it.denzosoft.mobile.graphicEngine.LayeredCanvas;
import it.denzosoft.mobile.graphicEngine.Sprite;
import it.denzosoft.mobile.graphicEngine.TextualGraphicObject;
import it.denzosoft.mobile.graphicEngine.TiledImage;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class IcelandGameEngine extends GameEngine {
    /**
     * DOCUMENT ME!
     */
    LayeredCanvas canvas = null;
    private Solvalou solvalou = null;
    private TiledImage mapImg = null;
    private IcelandMap map = null;
    private TiledImage sprites = null;
    private TiledImage explosions = null;
    private TextualGraphicObject text = null;
    private String[] pointAppender = {
            "000000", "00000", "0000", "000", "00", "0"
        };
    private EnergyBar energyBar = new EnergyBar();
    private FixedSizeList flyingEnemies = new FixedSizeList(10);
    private FixedSizeList groundEnemies = new FixedSizeList(10);
    private FixedSizeList weapons = new FixedSizeList(5);
    private FixedSizeList enemyWeapons = new FixedSizeList(5);
    private FixedSizeList allExplosions = new FixedSizeList(10);

    /** Holds value of property energy. */
    private int energy;

/** Creates a new instance of RacingEngine */
    public IcelandGameEngine(LayeredCanvas canvas) {
        super(canvas);
        this.canvas = canvas;
        init();
    }

    private void init() {
        try {
            mapImg = new TiledImage("/ice/iceGroundTiles.png", 32, 32);
            map = new IcelandMap();
            map.setImage(mapImg);
            map.setVisible(true);
            map.setLoopX(false);
            map.setLoopY(true);
            map.setY(115 * 32);
            sprites = new TiledImage("/xevious.png", 32, 32);
            explosions = new TiledImage("/explosions.png", 32, 32);

            Solvalou solvalou = new Solvalou(this);
            solvalou.setImage(sprites);
            solvalou.setVisible(true);
            solvalou.setX((this.getScreenWidth() / 2) - 16);
            solvalou.setY(this.getScreenHeight() - (32 * 2));
            this.addSolvalou(solvalou);
            text = new TextualGraphicObject();
            this.setPoints(0);
            text.setText("" + this.getPoints());
            text.setVisible(true);
            canvas.add(text, LayeredCanvas.ZORDER_TOPMOST);
            canvas.setBuffered(true);
            // Toroid toroid = new Toroid(this);
            // toroid.setImage(sprites);
            // toroid.setVisible(true);
            // this.addFlyingEnemy(toroid);
            //
            this.energy = 100;
            energyBar.setWidth(this.getScreenWidth() / 2);
            energyBar.setX(this.getScreenWidth() / 2);
            energyBar.setHeight(10);
            energyBar.setFull(energy);
            energyBar.setDanger(10);
            energyBar.setWarning(25);
            energyBar.setVisible(true);
            canvas.add(energyBar, LayeredCanvas.ZORDER_TOPMOST);

            this.setBackgroudMap(map);
            canvas.add(map, LayeredCanvas.ZORDER_BOTTOMMOST);
            System.gc();
        } catch (Exception ex) {
            Logger.error(ex);

            // Logger.showAlert(canvas.getMIDlet().getDisplay(),1000);
        }
    }

    /**
     * DOCUMENT ME!
     */
    protected void clean() {
        System.gc();

        // flyingEnemies.trimToSize();
        // weapons.trimToSize();
    }

    /**
     * DOCUMENT ME!
     */
    public void gameTick() {
        System.gc();
        Logger.debug("##############");
        Logger.memory();

        String points = Integer.toString(getPoints());
        text.setText(pointAppender[points.length()] + points);
        energyBar.setEnergy(energy);
        map.setY(map.getY() - 1);
        solvalou.execute(getKeyStates());

        Sprite enemy = null;

        for (int i = 0; i < groundEnemies.size(); i++) {
            enemy = (Sprite) groundEnemies.get(i);
            enemy.execute(getKeyStates());
        }

        for (int i = 0; i < allExplosions.size(); i++) {
            enemy = (Sprite) allExplosions.get(i);
            enemy.execute(getKeyStates());
        }

        for (int i = 0; i < flyingEnemies.size(); i++) {
            enemy = (Sprite) flyingEnemies.get(i);
            enemy.execute(getKeyStates());

            if (!(enemy instanceof AirExplosion) &&
                    evalCollision(solvalou, enemy)) {
                Logger.debug("Boom solvalou");
                createAirExplosion(enemy);
                removeEnemy(enemy);
                energy = energy - 5;
            }
        }

        for (int i = 0; i < enemyWeapons.size(); i++) {
            enemy = (Sprite) enemyWeapons.get(i);
            enemy.execute(getKeyStates());

            if (evalCollision(solvalou, enemy)) {
                Logger.debug("Boom solvalou");
                createAirExplosion(enemy);
                removeEnemyWeapon(enemy);
                energy = energy - 1;
            }
        }

        SolvalouWeapon weapon = null;

        for (int i = 0; i < weapons.size(); i++) {
            try {
                weapon = (SolvalouWeapon) weapons.get(i);
                weapon.execute(getKeyStates());

                for (int o = 0; o < flyingEnemies.size(); o++) {
                    enemy = (Sprite) flyingEnemies.get(o);

                    // enemy.execute(getKeyStates());
                    if (evalCollision(weapon, enemy)) {
                        Logger.debug("Bumm enemy");
                        this.setPoints(getPoints() + 50);
                        createAirExplosion(enemy);
                        removeEnemy(enemy);
                        removeSolvalouWeapon(weapon);

                        continue;
                    }
                }

                for (int o = 0; o < groundEnemies.size(); o++) {
                    enemy = (Sprite) groundEnemies.get(o);

                    // enemy.execute(getKeyStates());
                    if (evalCollision(weapon, enemy)) {
                        this.setPoints(getPoints() + 20);
                        createGroundExplosion(enemy);
                        removeEnemy(enemy);
                        removeSolvalouWeapon(weapon);

                        continue;
                    }
                }
            } catch (Error ex) {
                Logger.error(ex);
            }
        }

        if ((flyingEnemies.size() < 10) && (this.getRandom(10000) < 500)) {
            Toroid toroid = new Toroid(this);
            toroid.setImage(sprites);
            toroid.setY(-32);
            toroid.setX(getRandom(getScreenWidth() - 32));
            toroid.setVisible(true);
            this.addFlyingEnemy(toroid);
        }

        if ((groundEnemies.size() < 10) && (this.getRandom(10000) < 500)) {
            Barra barra = new Barra(this);
            barra.setImage(sprites);
            barra.setY(-32);
            barra.setX(getRandom(getScreenWidth() - 32));
            barra.setVisible(true);
            this.addGroundEnemy(barra);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param c DOCUMENT ME!
     * @param displayable DOCUMENT ME!
     */
    public void commandAction(Command c, Displayable displayable) {
    }

    // private void addEnemy(Object sprite, int zorder) {
    /**
     * DOCUMENT ME!
     *
     * @param sprite DOCUMENT ME!
     */
    public void removeEnemy(Object sprite) {
        try {
            flyingEnemies.remove(sprite);
            groundEnemies.remove(sprite);
            canvas.remove((GraphicObject) sprite);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param sprite DOCUMENT ME!
     */
    public void addFlyingEnemy(Object sprite) {
        flyingEnemies.add(sprite);
        canvas.add((GraphicObject) sprite, LayeredCanvas.ZORDER_TOP);
    }

    /**
     * DOCUMENT ME!
     *
     * @param sprite DOCUMENT ME!
     */
    public void addGroundEnemy(Sprite sprite) {
        groundEnemies.add(sprite);
        canvas.add((GraphicObject) sprite, LayeredCanvas.ZORDER_BOTTOM);
    }

    /**
     * DOCUMENT ME!
     *
     * @param sprite DOCUMENT ME!
     */
    public void createEnemyWeapon(Sprite sprite) {
        if (enemyWeapons.size() < 5) {
            EnemyWeapon e = new EnemyWeapon(this);
            e.setImage(sprites);
            e.setX(sprite.getX());
            e.setY(sprite.getY());
            e.setTarget(getSolvalou());
            e.setVisible(true);
            canvas.add(e, LayeredCanvas.ZORDER_TOP);
            enemyWeapons.add(e);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param sprite DOCUMENT ME!
     */
    public void createSolvalouWeapon(Sprite sprite) {
        if (weapons.size() < 5) {
            SolvalouWeapon s = new SolvalouWeapon(this);
            s.setImage(sprites);
            s.setX(sprite.getX());
            s.setY(sprite.getY());
            s.setVisible(true);
            canvas.add(s, LayeredCanvas.ZORDER_TOP);
            weapons.add(s);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param sprite DOCUMENT ME!
     */
    public void removeSolvalouWeapon(Object sprite) {
        weapons.remove(sprite);
        canvas.remove((GraphicObject) sprite);
    }

    /**
     * DOCUMENT ME!
     *
     * @param sprite DOCUMENT ME!
     */
    public void removeEnemyWeapon(Object sprite) {
        enemyWeapons.remove(sprite);
        canvas.remove((GraphicObject) sprite);
    }

    /**
     * DOCUMENT ME!
     *
     * @param sprite DOCUMENT ME!
     */
    public void createAirExplosion(Sprite sprite) {
        if (allExplosions.size() < 10) {
            AirExplosion explosion = new AirExplosion(this);
            explosion.setImage(explosions);
            explosion.setX(sprite.getX());
            explosion.setY(sprite.getY());
            explosion.setVisible(true);
            allExplosions.add(explosion);
            canvas.add(explosion, LayeredCanvas.ZORDER_TOPMOST);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param sprite DOCUMENT ME!
     */
    public void createGroundExplosion(Sprite sprite) {
        if (allExplosions.size() < 10) {
            GroundExplosion explosion = new GroundExplosion(this);
            explosion.setImage(explosions);
            explosion.setX(sprite.getX());
            explosion.setY(sprite.getY());
            explosion.setVisible(true);
            allExplosions.add(explosion);
            canvas.add(explosion, LayeredCanvas.ZORDER_BOTTOM);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param sprite DOCUMENT ME!
     */
    public void removeExplosion(Object sprite) {
        allExplosions.remove(sprite);
        canvas.remove((GraphicObject) sprite);
    }

    /**
     * DOCUMENT ME!
     *
     * @param solvalou DOCUMENT ME!
     */
    public void addSolvalou(Solvalou solvalou) {
        this.solvalou = solvalou;
        canvas.add((GraphicObject) solvalou, LayeredCanvas.ZORDER_TOP);
    }

    /**
     * DOCUMENT ME!
     *
     * @param map DOCUMENT ME!
     */
    public void setBackgroudMap(IcelandMap map) {
        this.map = map;
        canvas.add(map, LayeredCanvas.ZORDER_BOTTOMMOST);
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Sprite getSolvalou() {
        return solvalou;
    }

    /**
     * DOCUMENT ME!
     *
     * @param sprite1 DOCUMENT ME!
     * @param sprite2 DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean evalCollision(Sprite sprite1, Sprite sprite2) {
        Rectangle rect1 = sprite1.getCollisionArea();
        Rectangle rect2 = sprite2.getCollisionArea();

        if (((sprite1.getX() + rect1.getLeft()) > (sprite2.getX() +
                rect2.getLeft() + rect2.getWidth())) ||
                ((sprite2.getX() + rect2.getLeft()) > (sprite1.getX() +
                rect1.getLeft() + rect1.getWidth())) ||
                ((sprite1.getY() + rect1.getTop()) > (sprite2.getY() +
                rect2.getTop() + rect2.getHeight())) ||
                ((sprite2.getY() + rect2.getTop()) > (sprite1.getY() +
                rect1.getTop() + rect1.getHeight()))) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Getter for property energy.
     *
     * @return Value of property energy.
     */
    public int getEnergy() {
        return this.energy;
    }

    /**
     * Setter for property energy.
     *
     * @param energy New value of property energy.
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }
}

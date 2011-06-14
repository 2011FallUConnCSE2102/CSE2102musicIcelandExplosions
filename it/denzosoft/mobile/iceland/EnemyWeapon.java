/*
 * EnemyWeapon.java
 *
 * Created on 10 novembre 2006, 12.59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.iceland;

import it.denzosoft.mobile.common.Rectangle;
import it.denzosoft.mobile.common.math.FixedPoint;
import it.denzosoft.mobile.graphicEngine.Sprite;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class EnemyWeapon extends SingleTileEnemy {
    private static int[] frames = new int[] { 34, 35 };
    private static Rectangle collisionArea = new Rectangle(8, 8, 24, 24);
    private int dx = 0;
    private int dy = 0;
    private int x = 0;
    private int y = 0;

/** Creates a new instance of EnemyWeapon */
    public EnemyWeapon(IcelandGameEngine gameEngine) {
        super(gameEngine);
        this.setFrames(frames);
        this.setFrame(getCurrentFrame());
        this.setCollisionArea(collisionArea);
    }

    /**
     * DOCUMENT ME!
     *
     * @param userInput DOCUMENT ME!
     */
    public void execute(int userInput) {
        setFrame(nextFrame());

        x = x + dx;
        y = y + dy;

        int currentX = FixedPoint.toInt(x);
        int currentY = FixedPoint.toInt(y);

        setY(currentY);
        setX(currentX);

        if ((currentX < 0) || (currentY < 0) ||
                (currentY > getGameEngine().getScreenHeight()) ||
                (currentX > getGameEngine().getScreenWidth())) {
            ((IcelandGameEngine) getGameEngine()).removeEnemyWeapon(this);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param sprite DOCUMENT ME!
     */
    public void setTarget(Sprite sprite) {
        x = FixedPoint.intToFP(getX());
        y = FixedPoint.intToFP(getY());

        int d = getX() - sprite.getX();

        if (d == 0) {
            d = 1;
        }

        int ddx = FixedPoint.intToFP(d);
        int ddy = FixedPoint.intToFP(getY() - sprite.getY());
        int m = FixedPoint.Div(ddy, ddx);
        int m2 = FixedPoint.Mul(m, m);
        dx = FixedPoint.Div(FixedPoint.intToFP(3),
                FixedPoint.Sqrt(FixedPoint.intToFP(1) + m2));

        if (d > 0) {
            dx = FixedPoint.Mul(FixedPoint.intToFP(-1), dx);
        }

        dy = FixedPoint.Mul(m, dx);

        if ((FixedPoint.toInt(dx) == 0) && (FixedPoint.toInt(dy) == 0)) {
            dx = dx;
        }

        // Logger.debug("dx="+FixedPoint.toInt(dx));
        // Logger.debug("dy="+FixedPoint.toInt(dy));
    }
}

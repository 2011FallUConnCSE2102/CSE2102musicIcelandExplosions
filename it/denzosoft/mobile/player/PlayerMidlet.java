/*
 * PlayerMidlet.java
 *
 * Created on 8 novembre 2006, 16.59
 */
package it.denzosoft.mobile.player;

import it.denzosoft.mobile.common.BasicMIDlet;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 * @version
 */
public class PlayerMidlet extends BasicMIDlet {
    /**
     * DOCUMENT ME!
     */
    public void run() {
        PlayerForm form = new PlayerForm(this);
        this.getDisplay().setCurrent(form.getForm());
    }
}

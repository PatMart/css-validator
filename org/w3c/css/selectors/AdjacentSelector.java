// $Id: AdjacentSelector.java,v 1.2 2005-09-14 15:15:32 ylafon Exp $
// Author: Jean-Guilhem Rouel
// (c) COPYRIGHT MIT, ERCIM and Keio, 2005.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.css.selectors;

/**
 * Adjacent<br />
 * Created: Sep 1, 2005 3:59:08 PM<br />
 */
public class AdjacentSelector implements Selector {

    /**
     * @see Selector#toString()
     */
    public String toString() {
	return " + ";
    }

    /**
     * @see Selector#getName()
     */
    public String getName() {
	return "+";
    }

    /**
     * @see Selector#canApply(Selector)
     */
    public boolean canApply(Selector other) {
	return false;
    }

}
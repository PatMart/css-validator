// $Id: CssOutlineWidth.java,v 1.1 2012-10-16 20:44:01 ylafon Exp $
// Author: Yves Lafon <ylafon@w3.org>
//
// (c) COPYRIGHT MIT, ERCIM and Keio University, 2012.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.css.properties.css3;

import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;
import org.w3c.css.values.CssExpression;

/**
 * @spec http://www.w3.org/TR/2012/WD-css3-ui-20120117/#outline-width
 * @see CssBorderWidth
 */
public class CssOutlineWidth extends org.w3c.css.properties.css.CssOutlineWidth {

	/**
	 * Create a new CssOutlineWidth
	 */
	public CssOutlineWidth() {
		value = initial;
	}

	/**
	 * Creates a new CssOutlineWidth
	 *
	 * @param expression The expression for this property
	 * @throws org.w3c.css.util.InvalidParamException
	 *          Expressions are incorrect
	 */
	public CssOutlineWidth(ApplContext ac, CssExpression expression, boolean check)
			throws InvalidParamException {
		setByUser();
		// here we delegate to BorderWidth implementation
		value = CssBorderWidth.checkBorderSideWidth(ac, this, expression, check);
	}

	public CssOutlineWidth(ApplContext ac, CssExpression expression)
			throws InvalidParamException {
		this(ac, expression, false);
	}

}

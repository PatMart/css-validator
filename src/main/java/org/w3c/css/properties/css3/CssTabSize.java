// $Id: CssTabSize.java,v 1.6 2012-09-10 11:58:31 ylafon Exp $
// Author: Yves Lafon <ylafon@w3.org>
//
// (c) COPYRIGHT MIT, ERCIM and Keio University, 2012.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.css.properties.css3;

import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;
import org.w3c.css.values.CssExpression;
import org.w3c.css.values.CssLength;
import org.w3c.css.values.CssNumber;
import org.w3c.css.values.CssTypes;
import org.w3c.css.values.CssValue;

/**
 * @spec http://www.w3.org/TR/2012/WD-css3-text-20120814/#tab-size1
 */
public class CssTabSize extends org.w3c.css.properties.css.CssTabSize {

	/**
	 * Create a new CssTabSize
	 */
	public CssTabSize() {
		value = initial;
	}

	/**
	 * Creates a new CssTabSize
	 *
	 * @param expression The expression for this property
	 * @throws org.w3c.css.util.InvalidParamException
	 *          Expressions are incorrect
	 */
	public CssTabSize(ApplContext ac, CssExpression expression, boolean check)
			throws InvalidParamException {
		setByUser();
		CssValue val = expression.getValue();

		if (check && expression.getCount() > 1) {
			throw new InvalidParamException("unrecognize", ac);
		}
		switch (val.getType()) {
			case CssTypes.CSS_NUMBER:
				CssNumber number = val.getNumber();
				number.checkInteger(ac, this);
				number.checkPositiveness(ac, this);
				value = val;
				break;
			case CssTypes.CSS_LENGTH:
				CssLength l = val.getLength();
				l.checkPositiveness(ac, this);
				value = val;
				break;
			case CssTypes.CSS_IDENT:
				if (inherit.equals(val)) {
					value = inherit;
					break;
				}
			default:
				throw new InvalidParamException("value",
						val, getPropertyName(), ac);
		}
		expression.next();
	}

	public CssTabSize(ApplContext ac, CssExpression expression)
			throws InvalidParamException {
		this(ac, expression, false);
	}

}


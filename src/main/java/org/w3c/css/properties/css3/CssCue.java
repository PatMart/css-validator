// $Id: CssCue.java,v 1.1 2013-01-03 14:57:08 ylafon Exp $
// Author: Yves Lafon <ylafon@w3.org>
//
// (c) COPYRIGHT MIT, ERCIM and Keio University, 2013.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.css.properties.css3;

import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;
import org.w3c.css.values.CssExpression;
import org.w3c.css.values.CssOperator;
import org.w3c.css.values.CssValue;
import org.w3c.css.values.CssValueList;

import java.util.ArrayList;

/**
 * @spec http://www.w3.org/TR/2011/REC-CSS2-20110607/aural.html#propdef-cue
 */
public class CssCue extends org.w3c.css.properties.css.CssCue {

	/**
	 * Create a new CssCue
	 */
	public CssCue() {
		value = initial;
		cssCueAfter = new CssCueAfter();
		cssCueBefore = new CssCueBefore();
	}

	/**
	 * Creates a new CssCue
	 *
	 * @param expression The expression for this property
	 * @throws org.w3c.css.util.InvalidParamException
	 *          Expressions are incorrect
	 */
	public CssCue(ApplContext ac, CssExpression expression, boolean check)
			throws InvalidParamException {
		if (check && expression.getCount() > 4) {
			throw new InvalidParamException("unrecognize", ac);
		}
		setByUser();

		char op;

		cssCueBefore = new CssCueBefore(ac, expression, false);
		if (expression.end()) {
			cssCueAfter = new CssCueAfter();
			cssCueAfter.value = cssCueBefore.value;
			value = cssCueBefore.value;
		} else {
			op = expression.getOperator();
			if (op != CssOperator.SPACE) {
				throw new InvalidParamException("operator",
						((new Character(op)).toString()), ac);
			}
			cssCueAfter = new CssCueAfter(ac, expression, false);
			if (cssCueBefore.value == inherit || cssCueAfter.value == inherit) {
				throw new InvalidParamException("value",
						inherit, getPropertyName(), ac);
			}
			ArrayList<CssValue> values = new ArrayList<CssValue>(2);
			values.add(cssCueBefore.value);
			values.add(cssCueAfter.value);
			value = new CssValueList(values);
		}
	}

	public CssCue(ApplContext ac, CssExpression expression)
			throws InvalidParamException {
		this(ac, expression, false);
	}
}


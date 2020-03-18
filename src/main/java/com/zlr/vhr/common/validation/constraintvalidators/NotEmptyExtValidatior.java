package com.zlr.vhr.common.validation.constraintvalidators;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;

import com.zlr.vhr.common.validation.constraints.NotEmptyExt;

/**
 * @NotEmptyValidatorForCharSequence expand
 * @see org.hibernate.validator.internal.constraintvalidators.bv.notempty.NotEmptyValidatorForCharSequence
 *
 * @author wangyd5
 */
public class NotEmptyExtValidatior implements ConstraintValidator<NotEmptyExt, CharSequence> {

	private static final Log LOG = LoggerFactory.make(MethodHandles.lookup());

	private String[] values;

	@Override
	public void initialize(NotEmptyExt parameters) {

		values = parameters.value();
	}

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {

		if (value == null || value.length() == 0) {
			return false;
		}

		if (values.length == 0) {
			return value.length() > 0;
		}

		if (Arrays.asList(values).contains(value.toString())) {

			return true;
		} else {

			return false;
		}
	}

}
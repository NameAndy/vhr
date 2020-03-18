package com.zlr.vhr.common.validation.constraintvalidators;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.zlr.vhr.common.validation.constraints.NotBlankExt;

public class NotBlankExtValidatior implements ConstraintValidator<NotBlankExt, CharSequence> {

	private String[] values;

	@Override
	public void initialize(NotBlankExt parameters) {
		values = parameters.value();
	}

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {

		if (value == null || values.length == 0) {
			return true;
		}

		if (Arrays.asList(values).contains(value.toString())) {

			return true;
		} else {

			return false;
		}
	}

}
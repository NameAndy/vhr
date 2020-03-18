package com.zlr.vhr.common.validation.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.zlr.vhr.common.validation.constraints.NotEmptyExt.List;
import com.zlr.vhr.common.validation.constraintvalidators.NotEmptyExtValidatior;

/**
 * @NotEmpty expand
 * @see javax.validation.constraints.NotEmpty
 *
 * @author wangyd5
 */
@Documented
@Constraint(validatedBy = { NotEmptyExtValidatior.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Repeatable(List.class)
@Retention(RUNTIME)
public @interface NotEmptyExt {

	String message() default "{com.ai.jf.validator.NotEmptyExt.message}";

	/**
	 * Allowable value
	 */
	String[] value() default {};

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * Defines several {@code @NotBlankExt} constraints on the same element.
	 *
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		NotEmptyExt[] value();
	}
}
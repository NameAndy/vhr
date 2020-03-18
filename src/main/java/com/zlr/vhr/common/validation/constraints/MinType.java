package com.zlr.vhr.common.validation.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.zlr.vhr.common.validation.constraints.MinType.List;
import com.zlr.vhr.common.validation.constraintvalidators.MinValidator;


/**
 * @Min expand
 * @see javax.validation.constraints.Min
 *
 * @author wangyd5
 */
@Documented
@Constraint(validatedBy = { MinValidator.class })
@Target({ ANNOTATION_TYPE, TYPE })
@Repeatable(List.class)
@Retention(RUNTIME)
public @interface MinType {

	String message() default "{com.ai.jf.validation.constraints.MinType.message}";

	/**
	 * @return value the element must be higher or equal to
	 */
	long value();

	/**
	 * @return Decorated fields
	 */
	String field();

	/**
	 * @return Dependent field
	 */
	String depField();

	/**
	 * @return Value of dependent field
	 */
	String[] depValue();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * Defines several {@code @MinType} constraints on the same element.
	 *
	 */
	@Target({ ANNOTATION_TYPE, TYPE })
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		MinType[] value();
	}
}
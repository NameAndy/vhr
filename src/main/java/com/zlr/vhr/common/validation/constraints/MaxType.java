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

import com.zlr.vhr.common.validation.constraints.MaxType.List;
import com.zlr.vhr.common.validation.constraintvalidators.MaxValidator;

/**
 * @Max expand
 * @see javax.validation.constraints.Max
 *
 * @author wangyd5
 */
@Documented
@Constraint(validatedBy = { MaxValidator.class })
@Target({ ANNOTATION_TYPE, TYPE })
@Repeatable(List.class)
@Retention(RUNTIME)
public @interface MaxType {

	String message() default "{com.ai.jf.validation.constraints.MaxType.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * @return value the element must be lower or equal to
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

	/**
	 * Defines several {@link MaxType} annotations on the same element.
	 *
	 * @see MaxType
	 */
	@Target({ ANNOTATION_TYPE, TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {

		MaxType[] value();
	}
}
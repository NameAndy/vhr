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
import javax.validation.constraints.Size;

import com.zlr.vhr.common.validation.constraints.SizeType.List;
import com.zlr.vhr.common.validation.constraintvalidators.SizeTypeValidatior;

/**
 * @Size expand
 * @see javax.validation.constraints.Size
 *
 * @author wangyd5
 */
@Documented
@Constraint(validatedBy = { SizeTypeValidatior.class })
@Target({ ANNOTATION_TYPE, TYPE })
@Repeatable(List.class)
@Retention(RUNTIME)
public @interface SizeType {

	String message() default "{com.ai.jf.validation.constraints.SizeType.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * @return size the element must be higher or equal to
	 */
	int min() default 0;

	/**
	 * @return size the element must be lower or equal to
	 */
	int max() default Integer.MAX_VALUE;

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
	 * Defines several {@link Size} annotations on the same element.
	 *
	 * @see Size
	 */
	@Target({ ANNOTATION_TYPE, TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {

		SizeType[] value();
	}
}
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

import com.zlr.vhr.common.validation.constraints.NotNullType.List;
import com.zlr.vhr.common.validation.constraintvalidators.NotNullTypeValidatior;

/**
 * @NotNull expand
 * @see javax.validation.constraints.NotNull
 *
 * @author wangyd5
 */
@Documented
@Constraint(validatedBy = { NotNullTypeValidatior.class })
@Target({ ANNOTATION_TYPE, TYPE })
@Repeatable(List.class)
@Retention(RUNTIME)
public @interface NotNullType {

	String message() default "{com.ai.jf.validator.NotNullType.message}";

	/**
	 * Allowable value
	 */
	String[] value() default {};

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
	 * Defines several {@code @NotBlankExt} constraints on the same element.
	 *
	 */
	@Target({ ANNOTATION_TYPE, TYPE })
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		NotNullType[] value();
	}
}
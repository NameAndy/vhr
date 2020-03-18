package com.zlr.vhr.common.validation.advance;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.zlr.vhr.common.validation.advance.Conditional.List;


/**
 * 使用方法 @Conditional(field="address", values={"PSO","SRD"},required=
 * {"name","gender"})
 * 
 * @author douxiaofeng
 *
 */
@Repeatable(List.class)
@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ConditionalValidator.class })
public @interface Conditional {
	
    String message() default "This field must set value, can not empty.";
    
    String blankMessage() default "This field must set value, can not empty.";
    
    String sizeMessage() default "This field length must be within a certain range.";
    
    String valuesMessage() default "Invalid value";
    
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

    // 需要校验的字段
    String field();

    // 字段允许的值
    String[] values() default {};

    // 带值的字段
    Field[] depFields() default {};
    
    
    /**
	 * Defines several {@link Conditional} annotations on the same element.
	 *
	 * @see Conditional
	 */
	@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {

		Conditional[] value();
	}
}

package com.zlr.vhr.common.validation.advance;

import static org.springframework.util.StringUtils.isEmpty;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConditionalValidator implements ConstraintValidator<Conditional, Object> {

	private static final Logger log = LoggerFactory.getLogger(ConditionalValidator.class);
	private String field;
	private String message;
	private String blankMessage;
	private String sizeMessage;
	private String valuesMessage;
	private int min;
	private int max;
	private String[] values;
	private Field[] fields;

	@Override
	public void initialize(Conditional requiredIfChecked) {
		field = requiredIfChecked.field();
		message = requiredIfChecked.message();
		blankMessage = requiredIfChecked.blankMessage();
		sizeMessage = requiredIfChecked.sizeMessage();
		valuesMessage = requiredIfChecked.valuesMessage();
		min = requiredIfChecked.min();
		max = requiredIfChecked.max();
		values = requiredIfChecked.values();
		fields = requiredIfChecked.depFields();
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {

		// 没有依赖字段情况下，不校验
		if (null == fields || fields.length <= 0) {
			return true;
		}
		// 默认需要校验为属性的值
		Boolean needValidating = true;
		try {
			// 得到要检验字段的值
			Object checkedValue = BeanUtils.getProperty(object, field);
			log.info("need validate filed:{},value: {}", field, checkedValue);
			// 循环检查所依赖的字段是否有值
			for (Field f : fields) {
				// 如果注解定义没有字段名称，直接到下一个
				if (null == f.name())
					continue;
				// 获得依赖字段的值
				Object requiredValue = BeanUtils.getProperty(object, f.name());
				// 不为空检验，如果不为空，说明需要校验，如果为空
				needValidating = requiredValue != null && !isEmpty(requiredValue);
				log.info("dependent filed:{},value: {}", f.name(), requiredValue);
				if (!needValidating) {
					// 有没值的
					break;
				}
				
				// 看看是否设置了值
				if (null == f.values() || f.values().length <= 0) {
					continue;
				}
				if (Arrays.asList(f.values()).contains(requiredValue)) {
					needValidating = true;
				}else {
					needValidating = false;
				} 
				
				/*
				 * if (!isEmpty(f.values())) { needValidating =
				 * f.values().equals(requiredValue); }
				 */
				
				// 说明不符合校验条件，值不一样
				if (!needValidating) {
					// 有没值的
					break;
				}
			}
			if (!needValidating) {
				// 依赖不成立
				return true;
			}
			// 如果循环完，valid还是true，说明所有依赖的都有值
			if (checkedValue == null || isEmpty(checkedValue)) {
				context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(blankMessage).addPropertyNode(field).addConstraintViolation();
				return false;
			}

			// 值小于最小值
			if (String.valueOf(checkedValue).length() < min) {
				context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(sizeMessage).addPropertyNode(field).addConstraintViolation();
				return false;
			}

			// 值大于最大值
			if (String.valueOf(checkedValue).length() > max) {
				context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(sizeMessage).addPropertyNode(field).addConstraintViolation();
				return false;
			}

			// 允许值的范围
			if (null == values || values.length <= 0)
				return true;
			if (Arrays.asList(values).contains(checkedValue)) {
				return true;
			} else {
				context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(valuesMessage).addPropertyNode(field).addConstraintViolation();
				return false;
			}

		} catch (IllegalAccessException e) {
			log.error("Accessor method is not available for class : {}, exception : {}", object.getClass().getName(),
					e);
			return false;
		} catch (NoSuchMethodException e) {
			log.error("Field or method is not present on class : {}, exception : {}", object.getClass().getName(), e);
			return false;
		} catch (InvocationTargetException e) {
			log.error("An exception occurred while accessing class : {}, exception : {}", object.getClass().getName(),
					e);
			return false;
		}
	}

}
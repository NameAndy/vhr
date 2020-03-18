package com.zlr.vhr.common.validation.constraintvalidators;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.validator.internal.constraintvalidators.bv.number.InfinityNumberComparatorHelper;
import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;

import com.zlr.vhr.common.validation.constraints.MinType;

/**
 * @MinValidator expand
 * @see org.hibernate.validator.internal.constraintvalidators.bv.number.bound.AbstractMinValidator<T>
 *
 * @author wangyd5
 */
public class MinValidator implements ConstraintValidator<MinType, Object> {

	private static final Log LOG = LoggerFactory.make(MethodHandles.lookup());

	protected long minValue;
	protected String field;
	protected String depField;
	private String[] depValue;

	@Override
	public void initialize(MinType parameters) {
		this.minValue = parameters.value();
		this.field = parameters.field();
		this.depField = parameters.depField();
		this.depValue = parameters.depValue();
	}

	/**
	 * field,depField,depValue三个属性其一为null值，不进行校验；<br>
	 * 约束字段和依赖字段的值其一为null值，不进行校验；<br>
	 * depValue不等于依赖字段的值，不进行校验
	 */
	@Override
	public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {

		if (object == null || field == null || depField == null || depValue == null) {
			return true;
		}

		try {
			
			String checkedValue = BeanUtils.getProperty(object, field);
			//null values are valid
			if (checkedValue == null) {
				return true;
			}

			String requiredValue = BeanUtils.getProperty(object, depField);
			if (requiredValue == null) {
				return true;
			}

			if (Arrays.asList(depValue).contains(requiredValue)) {

				Class cls = object.getClass().getDeclaredField(field).getType();
				String name = cls.getName();

				if (cls == Long.class) {

					Long valueOf = Long.valueOf(checkedValue);
					return (NumberComparatorHelper.compare(valueOf, minValue)) >= 0;

				} else if (cls == Double.class || name.equals("double")) {

					Double valueOf = Double.valueOf(checkedValue);
					return (NumberComparatorHelper.compare(valueOf, minValue,
							InfinityNumberComparatorHelper.GREATER_THAN)) >= 0;

				} else if (cls == Float.class || name.equals("float")) {

					Float valueOf = Float.valueOf(checkedValue);
					return (NumberComparatorHelper.compare(valueOf, minValue,
							InfinityNumberComparatorHelper.GREATER_THAN)) >= 0;

				} else if (Number.class.isAssignableFrom(cls) || name.equals("byte") || name.equals("short")
						|| name.equals("int") || name.equals("long")) {

					Long valueOf = Long.valueOf(checkedValue);
					return (NumberComparatorHelper.compare(valueOf, minValue)) >= 0;

				} else {

					LOG.errorf("field:{} type not allowed", name);
					return false;
				}

			} else {
				return true;
			}

		} catch (IllegalAccessException e) {
			LOG.errorf("Accessor method is not available for class : {}, exception : {}", object.getClass().getName(),
					e);
			return false;
		} catch (NoSuchMethodException e) {
			LOG.errorf("Field or method is not present on class : {}, exception : {}", object.getClass().getName(), e);
			return false;
		} catch (InvocationTargetException e) {
			LOG.errorf("An exception occurred while accessing class : {}, exception : {}", object.getClass().getName(),
					e);
			return false;
		} catch (NoSuchFieldException e) {
			LOG.errorf("Signals that the class doesn't have a field of a specified name : {}, exception : {}",
					object.getClass().getName(), e);
			return false;

		}

	}

}
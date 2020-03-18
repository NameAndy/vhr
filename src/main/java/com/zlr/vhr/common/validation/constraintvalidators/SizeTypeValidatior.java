package com.zlr.vhr.common.validation.constraintvalidators;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;

import com.zlr.vhr.common.validation.constraints.SizeType;

/**
 * @SizeValidatorFor* expand
 * @see org.hibernate.validator.internal.constraintvalidators.bv.size.SizeValidatorForCharSequence
 *
 * @author wangyd5
 */
public class SizeTypeValidatior implements ConstraintValidator<SizeType, Object> {

	private static final Log LOG = LoggerFactory.make(MethodHandles.lookup());

	private int min;
	private int max;
	private String field;
	private String depField;
	private String[] depValue;

	@Override
	public void initialize(SizeType parameters) {
		min = parameters.min();
		max = parameters.max();
		validateParameters();
		field = parameters.field();
		depField = parameters.depField();
		depValue = parameters.depValue();
	}

	/**
	 * field,depField,depValue三个属性其一为null值，不进行校验；<br>
	 * 约束字段和依赖字段的值其一为null时，不进行校验；<br>
	 * depValue不等于依赖字段的值，不进行校验
	 */
	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {

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

				if (Map.class.isAssignableFrom(cls) || Collection.class.isAssignableFrom(cls)) {
					// 暂不支持数组，集合和map类型，后续添加
					return true;

				} else if (CharSequence.class.isAssignableFrom(cls)) {

					int length = checkedValue.length();
					return length >= min && length <= max;

				} else if (Number.class.isAssignableFrom(cls)) {

					int length = checkedValue.length();
					return length >= min && length <= max;

				} else if (name.equals("float") || name.equals("double") || name.equals("byte") || name.equals("short")
						|| name.equals("int") || name.equals("long")) {

					int length = checkedValue.length();
					return length >= min && length <= max;

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

	private void validateParameters() {
		if (min < 0) {
			throw LOG.getMaxCannotBeNegativeException();
		}
		if (max < 0) {
			throw LOG.getMaxCannotBeNegativeException();
		}
		if (max < min) {
			throw LOG.getLengthCannotBeNegativeException();
		}
	}

}
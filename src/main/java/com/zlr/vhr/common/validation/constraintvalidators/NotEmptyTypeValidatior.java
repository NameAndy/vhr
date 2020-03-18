package com.zlr.vhr.common.validation.constraintvalidators;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;

import com.zlr.vhr.common.validation.constraints.NotEmptyType;

/**
 * @NotEmptyValidatorForCharSequence expand
 * @see org.hibernate.validator.internal.constraintvalidators.bv.notempty.NotEmptyValidatorForCharSequence
 *
 * @author wangyd5
 */
public class NotEmptyTypeValidatior implements ConstraintValidator<NotEmptyType, Object> {

	private static final Log LOG = LoggerFactory.make(MethodHandles.lookup());

	private String[] values;
	private String field;
	private String depField;
	private String[] depValue;

	@Override
	public void initialize(NotEmptyType parameters) {
		values = parameters.value();
		field = parameters.field();
		depField = parameters.depField();
		depValue = parameters.depValue();
	}

	/**
	 * field,depField,depValue三个属性其一为null值，不进行校验；<br>
	 * 依赖字段的值为null值，不进行校验；<br>
	 * depValue不等于依赖字段的值，不进行校验
	 */
	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {

		try {

			if (object == null || field == null || depField == null || depValue == null || depValue.length <= 0) {
				return true;
			}

			String checkedValue = BeanUtils.getProperty(object, field);

			String requiredValue = BeanUtils.getProperty(object, depField);
			if (requiredValue == null) {
				return true;
			}

			// 暂不支持数组,集合和map,后续支持
			if (Arrays.asList(depValue).contains(requiredValue)) {

				// 未配置value时，执行@NotEmpty注解功能
				if (values.length == 0) {

					if (checkedValue == null) {
						return false;
					}

					return checkedValue.length() > 0;
				}

				if (Arrays.asList(values).contains(checkedValue)) {

					return true;
				} else {

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
		}

	}

}
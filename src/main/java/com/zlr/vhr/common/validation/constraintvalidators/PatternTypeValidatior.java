package com.zlr.vhr.common.validation.constraintvalidators;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.hibernate.validator.internal.engine.messageinterpolation.util.InterpolationHelper;
import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;

import com.zlr.vhr.common.validation.constraints.PatternType;

/**
 * @PatternValidator expand
 * @see org.hibernate.validator.internal.constraintvalidators.bv.PatternValidator
 *
 * @author wangyd5
 */
public class PatternTypeValidatior implements ConstraintValidator<PatternType, Object> {

	private static final Log LOG = LoggerFactory.make(MethodHandles.lookup());

	private java.util.regex.Pattern pattern;
	private String escapedRegexp;
	private String field;
	private String depField;
	private String[] depValue;

	@Override
	public void initialize(PatternType parameters) {
		PatternType.Flag[] flags = parameters.flags();
		int intFlag = 0;
		for (PatternType.Flag flag : flags) {
			intFlag = intFlag | flag.getValue();
		}

		try {
			pattern = java.util.regex.Pattern.compile(parameters.regexp(), intFlag);
		} catch (PatternSyntaxException e) {
			throw LOG.getInvalidRegularExpressionException(e);
		}

		escapedRegexp = InterpolationHelper.escapeMessageParameter(parameters.regexp());
		field = parameters.field();
		depField = parameters.depField();
		depValue = parameters.depValue();
	}

	/**
	 * field,depField,depValue三个属性其一为null值，不进行校验；<br>
	 * 约束字段的值和依赖字段的值其一为null值，不进行校验；<br>
	 * depValue不等于依赖字段的值，不进行校验
	 */
	@Override
	public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
		if (object == null) {
			return true;
		}

		if (constraintValidatorContext instanceof HibernateConstraintValidatorContext) {
			constraintValidatorContext.unwrap(HibernateConstraintValidatorContext.class).addMessageParameter("regexp",
					escapedRegexp);
		}

		try {

			if (object == null || field == null || depField == null || depValue == null) {
				return true;
			}

			Object checkedValue = BeanUtils.getProperty(object, field);
			if (checkedValue == null) {
				return true;
			}

			Object requiredValue = BeanUtils.getProperty(object, depField);
			if (requiredValue == null) {
				return true;
			}

			if (Arrays.asList(depValue).contains(requiredValue)) {

				Matcher m = pattern.matcher((CharSequence) checkedValue);
				return m.matches();
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
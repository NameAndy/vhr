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
import javax.validation.constraints.Pattern;

import com.zlr.vhr.common.validation.constraints.PatternType.List;
import com.zlr.vhr.common.validation.constraintvalidators.PatternTypeValidatior;

/**
 * @Pattern expand
 * @see javax.validation.constraints.Pattern
 *
 * @author wangyd5
 */
@Documented
@Constraint(validatedBy = { PatternTypeValidatior.class })
@Target({ ANNOTATION_TYPE, TYPE })
@Retention(RUNTIME)
@Repeatable(List.class)
public @interface PatternType {

	/**
	 * @return the regular expression to match
	 */
	String regexp();

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
	 * @return array of {@code Flag}s considered when resolving the regular
	 *         expression
	 */
	Flag[] flags() default {};

	/**
	 * @return the error message template
	 */
	String message() default "{javax.validation.constraints.Pattern.message}";

	/**
	 * @return the groups the constraint belongs to
	 */
	Class<?>[] groups() default {};

	/**
	 * @return the payload associated to the constraint
	 */
	Class<? extends Payload>[] payload() default {};

	/**
	 * Possible Regexp flags.
	 */
	public static enum Flag {

		/**
		 * Enables Unix lines mode.
		 *
		 * @see java.util.regex.Pattern#UNIX_LINES
		 */
		UNIX_LINES(java.util.regex.Pattern.UNIX_LINES),

		/**
		 * Enables case-insensitive matching.
		 *
		 * @see java.util.regex.Pattern#CASE_INSENSITIVE
		 */
		CASE_INSENSITIVE(java.util.regex.Pattern.CASE_INSENSITIVE),

		/**
		 * Permits whitespace and comments in pattern.
		 *
		 * @see java.util.regex.Pattern#COMMENTS
		 */
		COMMENTS(java.util.regex.Pattern.COMMENTS),

		/**
		 * Enables multiline mode.
		 *
		 * @see java.util.regex.Pattern#MULTILINE
		 */
		MULTILINE(java.util.regex.Pattern.MULTILINE),

		/**
		 * Enables dotall mode.
		 *
		 * @see java.util.regex.Pattern#DOTALL
		 */
		DOTALL(java.util.regex.Pattern.DOTALL),

		/**
		 * Enables Unicode-aware case folding.
		 *
		 * @see java.util.regex.Pattern#UNICODE_CASE
		 */
		UNICODE_CASE(java.util.regex.Pattern.UNICODE_CASE),

		/**
		 * Enables canonical equivalence.
		 *
		 * @see java.util.regex.Pattern#CANON_EQ
		 */
		CANON_EQ(java.util.regex.Pattern.CANON_EQ);

		// JDK flag value
		private final int value;

		private Flag(int value) {
			this.value = value;
		}

		/**
		 * @return flag value as defined in {@link java.util.regex.Pattern}
		 */
		public int getValue() {
			return value;
		}
	}

	/**
	 * Defines several {@link Pattern} annotations on the same element.
	 *
	 * @see Pattern
	 */
	@Target({ ANNOTATION_TYPE, TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {

		PatternType[] value();
	}
}
package com.zlr.vhr.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import com.zlr.vhr.common.constants.BusinessConstants;
import com.zlr.vhr.common.exception.BusinessException;
import com.zlr.vhr.common.exception.SystemException;
import com.zlr.vhr.common.vo.BaseResponse;
import com.zlr.vhr.util.StringUtil;

/**
 * springboot 自定义全局异常处理类
 *
 * @author wangyd5
 */
@RestControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(CustomGlobalExceptionHandler.class);

	/**
	 * 自定义异常类
	 */
	@ExceptionHandler({ SystemException.class })
	public BaseResponse<Object> systemException(SystemException ex) {
		log.error("SystemException:{}", ex.getMessage(), ex);
		if (StringUtil.isBlank(ex.getErrorCode())) {
			ex.setErrorCode(BusinessConstants.SYSTEM_EXCEPTION_CODE);
		}
		return new BaseResponse<>(false, ex.getErrorCode(), ex.getErrorMessage());
	}

	/**
	 * 自定义异常类
	 */
	@ExceptionHandler(BusinessException.class)
	public BaseResponse<Object> businessException(BusinessException ex) {
		log.error("BusinessException:{}", ex.getMessage(), ex);
		if (StringUtil.isBlank(ex.getErrorCode())) {
			ex.setErrorCode(BusinessConstants.BUSI_EXCEPTION_CODE);
		}
		return new BaseResponse<>(false, ex.getErrorCode(), ex.getErrorMessage());
	}

	/**
	 * Bean Validator
	 * <p>
	 * 参数校验，使用SpringBoot推荐的Hibernate Validator
	 * 
	 * @see javax.validation.Valid
	 * @see org.springframework.validation.annotation.Validated
	 */
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		log.error("MethodArgumentNotValidException:{}", ex.getMessage(), ex);
		BindingResult result = ex.getBindingResult();
		StringBuilder sbu = new StringBuilder();
		for (ObjectError error : result.getAllErrors()) {
			sbu.append(error.getDefaultMessage() + "|");
		}
		String str = sbu.toString();
		if (str.endsWith("|")) {
			str = str.substring(0, str.length() - 1);
		}
		BaseResponse<Object> baseResponse = new BaseResponse<>(false, BusinessConstants.DATAVALID_FAILURE_CODE, str);
		return handleExceptionInternal(ex, baseResponse, headers, status, request);
	}

	/**
	 * 处理数据绑定异常
	 */
	@Override
	public ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		log.error("BindException:{}", ex.getMessage(), ex);
		BindingResult result = ex.getBindingResult();
		StringBuilder sbu = new StringBuilder();
		for (ObjectError error : result.getAllErrors()) {
			sbu.append(error.getDefaultMessage() + "|");
		}

		String str = sbu.toString();
		if (str.endsWith("|")) {
			str = str.substring(0, str.length() - 1);
		}

		BaseResponse<Object> baseResponse = new BaseResponse<>(false, BusinessConstants.DATAVALID_FAILURE_CODE, str);
		return handleExceptionInternal(ex, baseResponse, headers, status, request);
	}

	/**
	 * 处理数据转换异常
	 */
	@Override
	public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		log.error("HttpMessageNotReadableException:{}", ex.getMessage(), ex);
		BaseResponse<Object> baseResponse = new BaseResponse<>(false, BusinessConstants.DATAVALID_FAILURE_CODE,
				ex.getMessage());
		return new ResponseEntity<>(baseResponse, headers, status);
	}

	/**
	 * 处理其他异常
	 */
	@ExceptionHandler(Exception.class)
	public BaseResponse<Object> exception(Exception ex) {
		log.error("Exception:{}", ex.getMessage(), ex);
		return new BaseResponse<>(false, BusinessConstants.BUSI_FAILURE_CODE, ex.getMessage());
	}

	/**
	 * 定义响应实体类
	 */
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}
		return new ResponseEntity<>(body, headers, status);
	}

}

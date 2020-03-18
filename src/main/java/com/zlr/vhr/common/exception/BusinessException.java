package com.zlr.vhr.common.exception;

/**
 * BusinessException封装异常
 * Date: 2017年2月22日 <br>
 * Copyright (c) 2017 asiainfo.com <br>
 * 
 * @author gucl
 */
public class BusinessException extends GenericException {

    private static final long serialVersionUID = 1L;

    /**
     * @param errorCode
     * 错误码
     * @param errorMessage
     * 异常信息
     */
    public BusinessException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.expCode = errorCode;
        this.expMessage = errorMessage;
    }
    
    public BusinessException(String message) {
        super(message);
        this.expMessage = message;
    }
    
    public BusinessException(Exception oriEx) {
        super(oriEx);
    }
    
    
    public BusinessException(Throwable oriEx) {
        super(oriEx);
    }
    
    public BusinessException(String message, Exception oriEx) {
        super(message, oriEx);
        this.expMessage = message;
    }
    public BusinessException(String message, Throwable oriEx) {
        super(message, oriEx);
        this.expMessage = message;
    }

}

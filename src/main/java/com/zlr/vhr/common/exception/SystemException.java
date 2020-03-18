package com.zlr.vhr.common.exception;

/**
 * 系统异常 Date: 2017年2月22日 <br>
 * Copyright (c) 2017 asiainfo.com <br>
 * 
 * @author gucl
 */
public class SystemException extends GenericException {

    private static final long serialVersionUID = 1L;

    /**
     * 系统异常构造器.<br>
     * 
     * @param message 异常信息
     * @ServiceMethod
     */
    public SystemException(String message) {
        super(message);
        this.expMessage = message;
    }

    /**
     * 系统异常构造器.<br>
     * 
     * @param errcode 异常信息代码
     * @param message 异常信息
     * @ServiceMethod
     */
    public SystemException(String expCode, String message) {
        super(message);
        this.expCode = expCode;
        this.expMessage = message;
    }

    /**
     * 系统异常构造器.<br>
     * 
     * @param oriEx 异常对象
     * @ServiceMethod
     */
    public SystemException(Exception oriEx) {
        super(oriEx);
    }

    public SystemException(Throwable oriEx) {
        super(oriEx);
    }

    /**
     * 系统异常构造器.<br>
     * 
     * @param message 异常信息
     * @param oriEx   异常对象
     * @ServiceMethod
     */
    public SystemException(String message, Exception oriEx) {
        super(message, oriEx);
        this.expMessage = message;
    }

    public SystemException(String message, Throwable oriEx) {
        super(message, oriEx);
        this.expMessage = message;
    }

}

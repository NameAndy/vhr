package com.zlr.vhr.common.vo;

import java.io.Serializable;

/**
 * 消息体信息<br>
 * Date: 2019年9月20日 <br>
 * Copyright (c) 2019 asiainfo.com <br>
 * 
 * @author gucl
 */
public class BaseMessage<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    

    /**
     *消息消费失败次数
     */
    private Long consumerFailureCount;
    
    private String key;
    
    private T message;


    /**
     * 默认构造函数
     */
    public BaseMessage() {
        super();
    }


	public BaseMessage(String key, T message) {
		super();
		this.key = key;
		this.message = message;
	}


	public Long getConsumerFailureCount() {
		return consumerFailureCount;
	}


	public void setConsumerFailureCount(Long consumerFailureCount) {
		this.consumerFailureCount = consumerFailureCount;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public T getMessage() {
		return message;
	}


	public void setMessage(T message) {
		this.message = message;
	}

   

}

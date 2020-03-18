package com.zlr.vhr.common.vo;

import java.io.Serializable;
import java.util.UUID;

/**
 * 参数基础类. Date: 2017年2月22日 <br>
 * Copyright (c) 2017 asiainfo.com <br>
 * 
 * @author gucl
 */
public class BaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    public BaseInfo() {
        super();
        init();
    }

    private void init() {
        // 当没有时，自动生成一个。发生在web新建对象时。当到服务提供者端时，已经有了。
        if (null == traceId || "".equals(traceId))
            traceId = UUID.randomUUID().toString().replaceAll("\\-", "").toUpperCase();
    }

    public BaseInfo(PageArg page) {
        super();
        init();
        this.page = page;
    }

    public BaseInfo(int pageNum, int pageSize) {
        super();
        init();
        this.page = new PageArg(pageNum, pageSize);
    }

    /**
     * traceId，必填
     */
    private String traceId;

    private PageArg page;
   

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    

    public PageArg getPage() {
        return page;
    }

    public void setPage(PageArg page) {
        this.page = page;
    }

    

}

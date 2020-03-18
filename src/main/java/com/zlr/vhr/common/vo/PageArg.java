package com.zlr.vhr.common.vo;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Page对象.<br>
 * 提供给外部系统的分页Bean<br>
 * 
 * @param <T> 结果集的数据类型 Date: 2017年2月22日 <br>
 *        Copyright (c) 2017 asiainfo.com <br>
 * @author gucl
 */
public class PageArg implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 请求查询的页码
     */
    @NotNull(message="pageNum不能为空")
    @Min(value=1,message="pageNum必须大于等于1")
    @Max(value=Integer.MAX_VALUE,message="pageNum超过最大值")
    private Integer pageNum;

    /**
     * 每页显示条数
     */
    @NotNull(message="pageSize不能为空")
    @Min(value=1,message="pageSize必须大于等于1")
    @Max(value=Integer.MAX_VALUE,message="pageSize超过最大值")
    private Integer pageSize;

    public PageArg() {
        super();
    }

    public PageArg(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}

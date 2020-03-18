package com.zlr.vhr.controller;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class PeopleVO implements Serializable {
	@Min(value = 10,message ="Id最小为10" )
    private Long id;

    @NotBlank(message="name不能为空")
    private String name;

    private Date birthday;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
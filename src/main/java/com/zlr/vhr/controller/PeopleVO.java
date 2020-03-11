package com.zlr.vhr.controller;

import java.io.Serializable;
import java.util.Date;

public class PeopleVO implements Serializable {
    private Long id;

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
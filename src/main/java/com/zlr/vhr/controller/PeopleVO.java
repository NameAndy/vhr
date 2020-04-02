package com.zlr.vhr.controller;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


//@NotBlankType(field = "song",depField = "name",depValue = "周杰伦",message = "请传入一首歌的名字",value = {"夜曲","不能说的秘密"})
public class PeopleVO implements Serializable {
	@Min(value = 100,message ="Id最小为100" )
    private Long id;

    @NotBlank(message="name不能为空")
//	@NotBlankExt(value = {"小明","周杰伦"},message = "人员不合法")
    private String name;
	
	private String song;

    private Date birthday;

    private static final long serialVersionUID = 1L;
    

    public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

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
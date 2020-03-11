package com.zlr.vhr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zlr.vhr.controller.PeopleVO;
import com.zlr.vhr.dao.bo.People;
import com.zlr.vhr.dao.interfaces.PeopleMapper;
import com.zlr.vhr.service.IPeopleBusiSV;

@Service
public class PeopleBusiSVImpl implements IPeopleBusiSV {

	@Autowired
	private PeopleMapper peopleMapper;

	@Transactional
	public Integer add(PeopleVO request) {

		People people = new People();
		people.setId(request.getId());
		people.setName(request.getName());
		people.setBirthday(request.getBirthday());
		return peopleMapper.insertSelective(people);
	}

}

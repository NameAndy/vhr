package com.zlr.vhr.service.impl;

import org.springframework.stereotype.Service;

import com.zlr.vhr.controller.PeopleVO;
import com.zlr.vhr.dao.bo.People;
import com.zlr.vhr.service.IPeopleBusiSV;

@Service
public class PeopleBusiSVImpl implements IPeopleBusiSV {

//	@Autowired
//	private PeopleMapper peopleMapper;

//	@Transactional
	public Integer add(PeopleVO request) {
		
		People people = new People();
		// 除零异常.
//		int a=1/0;
		
		// 空指针异常.
		people=null;
		people.getId();
		
		people.setId(request.getId());
		people.setName(request.getName());
		people.setBirthday(request.getBirthday());
//		return peopleMapper.insertSelective(people);
		return null;
	}

}

package com.zlr.vhr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zlr.vhr.service.IPeopleBusiSV;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;


@Api(tags = "用户表demo")
@RequestMapping("/api/people")
@RestController
public class PeopleController {
	private static final Logger logger = LoggerFactory.getLogger(PeopleController.class);

	@Autowired
	private IPeopleBusiSV iPeopleBusiSV;

	
	@ApiOperation(value = "新增用户", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/add")
	public Integer add(@RequestBody @Validated PeopleVO request) {
		return iPeopleBusiSV.add(request);
	}
	
	
	@ApiOperation(value = "修改用户", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/update")
	public Integer update(@RequestBody PeopleVO request) {
		
		return iPeopleBusiSV.add(request);
	}

}

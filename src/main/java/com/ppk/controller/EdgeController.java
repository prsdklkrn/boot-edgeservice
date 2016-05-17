package com.ppk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ppk.service.EdgeService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "edge", description = " Expose welcome and name API endpoints", position = 0)
@RestController
public class EdgeController {

	private final EdgeService edgeService;

	@Autowired
	public EdgeController(EdgeService edgeService) {
		super();
		this.edgeService = edgeService;
	}

	@ApiOperation(value = "Get welcome message text..", notes = "Makes boot micro service call and gets the welcome message")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String welcomeMessage() {
		return edgeService.getWelcomeMessage();
	}

}

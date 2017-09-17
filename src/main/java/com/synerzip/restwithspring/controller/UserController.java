package com.synerzip.restwithspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.synerzip.restwithspring.model.User;
import com.synerzip.restwithspring.service.UserService;

@Controller
@EnableWebMvc
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		return "hello it's working";
	}
	
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User add(@RequestBody User user) {
		return userService.create(user);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User get(@PathVariable int id) {
		return userService.findById(id);
	}
	
}
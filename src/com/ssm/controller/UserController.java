package com.ssm.controller;


import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.entity.User;
import com.ssm.service.UserService;

@Controller
@RequestMapping("/accp")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/login")
	public String test01() {
		return "login";
	}
	@RequestMapping("/add")
	public String test02() {
		return "userAdd";
	}
	@RequestMapping("/update")
	public ModelAndView test03(@ModelAttribute User user) {
		User user1 = userService.findUser(user);
		ModelAndView model=new ModelAndView();
		
		model.addObject("user", user1).setViewName("userUpdate");;
		return model;
	}
	@RequestMapping("/update02")
	public String test04(@ModelAttribute User user) {
		int updateUser = userService.updateUser(user);
		
		return "userList";
	}
	@RequestMapping("/delete")
	public String test05(@ModelAttribute User user) {
		int deleteUser = userService.deleteUser(user);
		
		return "userList";
	}
	
	@RequestMapping("/login02")
	public String login01(@ModelAttribute User user){
		User user2 = userService.getUser(user);
		if(user2==null){
			return "login";
		}
		return "userList";
	}
	@ModelAttribute("userList")
	public List<User> userList(){
		List<User> userList = userService.getUserList();
		return userList;
	}
	
	 @ModelAttribute("cityList") 

	  public List<String> cityList() { 

	      return Arrays.asList("北京", "上海","武汉","广州"); 

	  } 


	@RequestMapping("/add02")
	public String test02(@Valid @ModelAttribute User user,Errors errors){
		int insertUser = userService.insertUser(user);
		
		if(errors.hasErrors()){
			return "userAdd";
		}else{
			
			return "login";
		}
		
	}
}

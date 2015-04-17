package com.tp.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tp.domain.Login;
import com.tp.service.LoginService;

@Controller
@RequestMapping("/app")
public class LoginController  
{
    private static final Logger LOG = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "test/", method = RequestMethod.GET) 
	public @ResponseBody boolean test()
	{
		return true;
	}
	
	  @RequestMapping(value = "signIn/", method = RequestMethod.POST)

	 public @ResponseBody Boolean signIn(@RequestBody Login login )
	 {
		  loginService.addMember(login);
		 System.out.println("The object:::"+login);
		 return true;
	 }
	  
	  @RequestMapping(value = "signUp/", method = RequestMethod.POST)

		 public @ResponseBody Boolean signUp(@RequestBody Login login )
		 {
		  loginService.addMember(login);
			 System.out.println("The sign up ;;;;object:::"+login);
			 return true;
		 }
	  
	  	@RequestMapping(value = "forgotPassword/", method = RequestMethod.POST)
		 public @ResponseBody Boolean fogotPassword(@RequestBody Login login )
		 {
			 System.out.println("The object:::"+login);
			 return true;
		 }

}

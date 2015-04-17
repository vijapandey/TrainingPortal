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
public class ExploreController  
{
    private static final Logger LOG = Logger.getLogger(ExploreController.class);

	@Autowired
	private LoginService loginService;

	 
	  @RequestMapping(value = "search/", method = RequestMethod.POST)

	 public @ResponseBody Object explore(@RequestBody Login login )
	 {
		 System.out.println("The object:::"+login);
		 return true;
	 }
	  
	 

}

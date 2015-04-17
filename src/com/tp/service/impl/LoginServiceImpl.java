package com.tp.service.impl;

import org.apache.commons.lang.BooleanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.aop.LoggingAroundAdvise;
import com.tp.dao.LoginDao;
import com.tp.domain.Login;
import com.tp.domain.MemberDetails;
import com.tp.domain.Roles;
import com.tp.service.LoginService;

@Service 
public class LoginServiceImpl implements LoginService
{
	@Autowired
	private LoginDao loginDao;
	
	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);
	
	public Roles getRole(Long roleID)
	{
		return loginDao.getRole(roleID);
	}
	
	public Boolean addMember(Login login)
	{
		logger.info("Here");
		MemberDetails memberDetails = new MemberDetails();
		memberDetails.setEmail(login.getEmailID());
		memberDetails.setPassword(login.getPassword());
		Roles role =null;
		if(BooleanUtils.isTrue(login.getIsTrainer()))
		{
			role =loginDao.getRole(1L);
		 }
		else
		{
			role =loginDao.getRole(2L);	
		}
		
		memberDetails.setRole(role);
		loginDao.addMember(memberDetails);
		return true;
	}
}

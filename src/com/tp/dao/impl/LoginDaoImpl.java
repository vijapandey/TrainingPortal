package com.tp.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.tp.dao.AbstractHibernateExtent;
import com.tp.dao.LoginDao;
import com.tp.domain.Login;
import com.tp.domain.MemberDetails;
import com.tp.domain.Roles;


@Repository("LoginDao")
public class LoginDaoImpl  
implements LoginDao {
	 
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public Boolean addMember(MemberDetails memberDetails)
	{
		hibernateTemplate.save(memberDetails);
		System.out.println("The login Object :"+memberDetails);
		return  true;
	}

	@Override
	public Roles getRole(Long roleID) {
		// TODO Auto-generated method stub
		Roles role = hibernateTemplate.get(Roles.class,roleID);
		System.out.println("Hte ::::"+role);
		return role;
	}
	
}

package com.tp.dao;

import org.springframework.stereotype.Repository;

import com.tp.domain.Login;
import com.tp.domain.MemberDetails;
import com.tp.domain.Roles;

@Repository("LoginDao")
public interface LoginDao {
	 
	public Boolean addMember(MemberDetails memberDetails);

	public Roles getRole(Long roleID);
}

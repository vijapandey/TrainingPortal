package com.tp.service;


import com.tp.domain.Login;
import com.tp.domain.Roles;

public interface LoginService {
	 
	public Boolean addMember(Login login);
	
	public Roles getRole(Long roleID);
}

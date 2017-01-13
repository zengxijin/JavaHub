package com.jack.spi.service.impl;

import com.jack.spi.service.AuthService;

public class LDAPAuthServiceImpl implements AuthService {

	@Override
	public String findUserNameById(String userId) {
		System.out.println("find user info from ladp server...");
		return "UserNameFromLadpServer";
	}

	@Override
	public boolean checkUser(String userId, String password) {
		System.out.println("check user info from ladp server...");
		return true;
	}

}

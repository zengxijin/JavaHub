package com.jack.spi.service;

public interface AuthService {
	String findUserNameById(String userId);
	boolean checkUser(String userId,String password);
}

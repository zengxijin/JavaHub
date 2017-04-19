package com.jack.spi.test;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.junit.Test;

import com.jack.spi.service.AuthService;

public class AuthServiceSPITest {
	@Test
	public void spiTest() {
		ServiceLoader<AuthService> authServiceLoader = ServiceLoader.load(AuthService.class);
		Iterator<AuthService> services = authServiceLoader.iterator();
		System.out.println("AuthService loaded");

		while (services.hasNext()) {
			AuthService service = services.next();
			System.out.println(service.getClass().getSuperclass());
			System.out.println(service.findUserNameById("jackZeng") + " " + service.checkUser("jackZeng", "123456"));
		}
	}
}

package com.jack.design.pattern.provider;

import com.jack.design.pattern.staticfactory.Provider;
import com.jack.design.pattern.staticfactory.Service;

public class MySqlProvider implements Service, Provider {

	public Service newService() {
		return new MySqlProvider();
	}

	public Object service() {
		return "I am the MySql Service!";
	}

}

package org.jackzeng.kie.service;

import org.jackzeng.kie.BootAppCfg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootAppCfg.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "management.port=0" })
public class TestCfg {

	@Autowired
	Environment environment;

	@Test
	public void getActiveProfiles() {
		for (final String profileName : environment.getActiveProfiles()) {
			System.out.println("Currently active profile - " + profileName);
		}
	}
}

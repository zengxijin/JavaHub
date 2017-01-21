package com.jackzeng.rest.app;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.logging.LoggingFraction;

import com.jackzeng.rest.cfg.CORSFilter;
import com.jackzeng.rest.controller.MyRestController;
import com.jackzeng.rest.entity.SimpleDTO;
import com.jackzeng.servlet.MyServlet;

public class MySwarmApp {
	
	public static void main(String[] args ) throws Exception{
		
		final Swarm swarm = new Swarm();
		
		final JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
		
		// add filter cfg
		deployment.addResource(CORSFilter.class);
		
		// add servlet resource
		deployment.addResource(MyServlet.class);
		
		// add rest resources
		deployment.addResource(JaxRsApplication.class);
		deployment.addResource(MyRestController.class);
		deployment.addResource(SimpleDTO.class);
		
		deployment.addAllDependencies();
        
        swarm
        .fraction(LoggingFraction.createDefaultLoggingFraction())
        .start()
        .deploy(deployment);
	}
}

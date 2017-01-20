package com.jackzeng.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jackzeng.rest.entity.SimpleDTO;

@Path("/rest")
public class MyRestController {
	
	@GET
	@Path("/text")
	public String getPlainText(){
		return "plain text";
	}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public SimpleDTO getJson(){
		return new SimpleDTO("myKey", "myValue");
	}
	
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public SimpleDTO getXml(){
		return new SimpleDTO("myKey", "myValue");
	}
}

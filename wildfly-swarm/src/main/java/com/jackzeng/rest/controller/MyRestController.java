package com.jackzeng.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.jackzeng.rest.entity.SimpleDTO;

@Path("/rest")
public class MyRestController {

	@GET
	@Path("/text")
	public String getPlainText() {
		return "plain text";
	}

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public SimpleDTO getJson() {
		return new SimpleDTO("jsonKey", "jsonValue");
	}

	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public SimpleDTO getXml() {
		return new SimpleDTO("xmlKey", "xmlValue");
	}

	@POST
	@Path("/post/xml/{pathParm}")
	@Produces(MediaType.APPLICATION_XML)
	public SimpleDTO getPostContentXml(SimpleDTO dto, @PathParam("pathParm") String pathParm,
			@Context HttpServletRequest request) {
		dto.setKey(dto.getKey() + " " + pathParm);
		dto.setValue(dto.getValue() + " " + request.getParameter("value"));

		return dto;
	}

	@POST
	@Path("/post/json/{pathParm}")
	@Produces(MediaType.APPLICATION_JSON)
	public SimpleDTO getPostContentJson(SimpleDTO dto, @PathParam("pathParm") String pathParm,
			@Context HttpServletRequest request) {
		dto.setKey(dto.getKey() + " " + pathParm);
		dto.setValue(dto.getValue() + " " + request.getParameter("value"));

		return dto;
	}

}

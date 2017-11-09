package com.pe.project;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import eft.restclient.lib.Message;

@Path("/msg")
public class RestServices {
	@GET
	@Path("get/{param}")
	@RolesAllowed("ripleyUser")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example : " + msg;
		return Response.status(200).entity(result).build();

	}

	@POST
	@Path("post")
	@Consumes("application/json")
	@Produces("application/json")
	public Message testMessage(Message msg) {
		msg.setData("100", "JAPON27");
		return msg;
	}
}

package com.pe.ripley.stf.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.pe.ripley.stf.message.Message;

public interface ServiceMessage {
	
	@POST
	@Path("post")
	@Consumes("application/json")
	@Produces("application/json")
	public Message Post(Message msg);
	
}

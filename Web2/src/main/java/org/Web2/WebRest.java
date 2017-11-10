package org.Web2;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import eft.restclient.lib.Message;

@Path("/msg")
public class WebRest {
	@POST
	@Path("post")
	@Consumes("application/json")
	@Produces("application/json")
	public Message testMessage(Message msg){
		msg.setData("100", "JAPON27");
		return msg;
	}
}

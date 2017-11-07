package com.pe.ripley.stf.autorizacion;

import javax.ws.rs.Path;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pe.ripley.stf.message.Message;
import com.pe.ripley.stf.service.ServiceMessage;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Path("/retiro")
public class RetiroMessageImpl implements ServiceMessage {

	@Override
	public Message Post(Message msg) {
		return msg;
	}

}

package com.ripley.mwf.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.pe.ripley.stf.message.Mwf_servicios;
import com.pe.ripley.stf.service.ServiceMwf_servicios;

@Path("/api/v1")
public class AutorizarRetiros implements ServiceMwf_servicios{
	@Override
	@POST
	@Path("/wsAutorizarRetiros")
	@Consumes("application/json")
	@Produces("application/json")	
	public Mwf_servicios Post(Mwf_servicios msg) {
		// TODO Auto-generated method stub
		return null;
	}

}

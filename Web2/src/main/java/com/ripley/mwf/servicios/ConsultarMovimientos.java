package com.ripley.mwf.servicios;

import javax.ws.rs.Path;

import com.pe.ripley.stf.message.Mwf_servicios;
import com.pe.ripley.stf.service.ServiceMwf_servicios;

@Path("/api/v1")
public class ConsultarMovimientos implements ServiceMwf_servicios{

	@Override
	@Path("/wsConsultarMovimientos")
	public Mwf_servicios Post(Mwf_servicios msg) {
		// TODO Auto-generated method stub
		return null;
	}

}

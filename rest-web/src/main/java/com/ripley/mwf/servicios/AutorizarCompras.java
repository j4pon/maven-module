package com.ripley.mwf.servicios;

import javax.ws.rs.Path;

import com.pe.ripley.stf.message.Mwf_servicios;
import com.pe.ripley.stf.service.ServiceMwf_servicios;

@Path("/api/v1")
public class AutorizarCompras implements ServiceMwf_servicios{
	
	@Path("wsAutorizarCompras")
	@Override	
	public Mwf_servicios Post(Mwf_servicios msg) {
		// TODO Auto-generated method stub
		try{
			return msg;	
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		return msg;
		
	}
	

}

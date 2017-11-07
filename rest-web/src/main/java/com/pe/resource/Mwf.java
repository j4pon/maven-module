package com.pe.resource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.ripley.mwf.servicios.AutorizarCompras;
import com.ripley.mwf.servicios.AutorizarRetiros;
import com.ripley.mwf.servicios.ConsultarMovimientos;
import com.ripley.mwf.servicios.ConsultarSaldos;

@ApplicationPath("/mwf")
public class Mwf extends Application{

	@Override
	public Set<Object> getSingletons(){
		
		HashSet<Object> set = new HashSet<Object>();
		set.add(new AutorizarCompras());
		set.add(new AutorizarRetiros());
		set.add(new ConsultarMovimientos());
		set.add(new ConsultarSaldos());
        return set;			
		
	}
}

package com.pe.resource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.Web2.OciRest;

import com.pe.ripley.stf.autorizacion.CompraMessageImpl;
import com.pe.ripley.stf.autorizacion.ConsultaMovimientosMessageImp;
import com.pe.ripley.stf.autorizacion.ConsultaSaldosMessageImpl;
import com.pe.ripley.stf.autorizacion.RetiroMessageImpl;
import com.pe.ripley.stf.validacion.CambiarPinMessageImpl;
import com.pe.ripley.stf.validacion.ValidarPinMessageImpl;

@ApplicationPath("/rs")
public class App extends Application {

	@Override
	public Set<Object> getSingletons() {
		HashSet<Object> set = new HashSet<Object>();
		set.add(new CambiarPinMessageImpl());
		set.add(new ValidarPinMessageImpl());
		set.add(new CompraMessageImpl());
		set.add(new ConsultaMovimientosMessageImp());
		set.add(new ConsultaSaldosMessageImpl());
		set.add(new RetiroMessageImpl());
		
		set.add(new OciRest());
        return set;
	}	
	
}

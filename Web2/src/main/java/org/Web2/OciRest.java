package org.Web2;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.otros.ConnectUno;
import org.otros.Cursor;

@Path("/oci")
public final class OciRest {
	
	@POST
	@Path("cursor")
	@Produces("application/json")	
	public List<Cursor> getTest(){
		ConnectUno app = new ConnectUno();
		List<Cursor> listCursor = app.getTest();
		return listCursor;
	}	
}

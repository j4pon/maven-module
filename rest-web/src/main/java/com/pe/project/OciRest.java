package com.pe.project;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import oracle.ucp.UniversalConnectionPoolException;


@Path("/oci")
public final class OciRest {
	
	@POST
	@Path("cursor")
	@Produces("application/json")	
	public List<Cursor> getTest() throws SQLException, UniversalConnectionPoolException{
		ConnectUno app = new ConnectUno();
		List<Cursor> listCursor = app.getTest();
		return listCursor;
	}	
}

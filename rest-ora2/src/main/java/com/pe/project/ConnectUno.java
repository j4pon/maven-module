package com.pe.project;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;
import oracle.ucp.UniversalConnectionPoolException;

public class ConnectUno {
public List<Cursor> getTest() throws SQLException, UniversalConnectionPoolException{
		
		List<Cursor> listCursor = new ArrayList<Cursor>();
		Connection conJou =  connectOciFisa.openConnection();
		CallableStatement callJouR = conJou.prepareCall("{call EFT.TEST.TEST_JOURNAL(?)}");
		callJouR.registerOutParameter(1, OracleTypes.CURSOR);
		callJouR.execute();
		ResultSet rsR = (ResultSet) callJouR.getObject(1);
		while(rsR.next()){
			Cursor cursor = new Cursor();
			cursor.setId(rsR.getInt("ID"));
			cursor.setDeltaPL(rsR.getString("DELTA_PL"));
			cursor.setDeltaJAVA(rsR.getString("DELTA_JAVA"));
			cursor.setBeforeJAVA(rsR.getString("BEFORE_JAVA"));
			cursor.setFecha(rsR.getString("FECHA"));
			listCursor.add(cursor);
			
		}
		conJou.close();
		return listCursor;
	}	
}
package org.Des2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import oracle.ucp.UniversalConnectionPoolException;

public class Sp_Pkg_Atm {

	public void /* Campos_PgAtm_Out */ Pro_Atm(Campos_PgAtm_In campos) {

		String param = "";
		int lon = 136;
		for (int i = 0; i < lon; i++) {
			param += "?,";
		}
		param = param.substring(0, param.length() - 1);
		String parametros = "{call PKG_ATM.PRO_ATM(" + param + ")}";

		Connection con = null;
		try {
			con = connectOciFisa.openConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UniversalConnectionPoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			CallableStatement call = con.prepareCall(parametros);
			call.setString(1, campos.getMARCA());
			call.setString(2, campos.getPRODUCTO());
			call.setString(3, campos.getESTACION());
			call.setString(4, campos.getUSUARIO());
			call.setString(5, campos.getREJECT_CODE());
			
			call.setString(6,);
			call.registerOutParameter(6, Types.NVARCHAR);

			call.setString(7,);
			call.registerOutParameter(7, Types.NVARCHAR);
			
			call.setString(8,);
			call.registerOutParameter(8, Types.NVARCHAR);
			
			call.setString(9,);
			call.registerOutParameter(9, Types.NVARCHAR);
			
			call.setString(10,);
			call.registerOutParameter(10, Types.NVARCHAR);
			
			call.setString(11,);
			call.registerOutParameter(11, Types.NVARCHAR);
			
			call.setString(12,);
			call.registerOutParameter(12, Types.NVARCHAR);
			
			call.setString(13,);
			call.registerOutParameter(13, Types.NVARCHAR);
			
			call.setString(14,);
			call.registerOutParameter(14, Types.NVARCHAR);
			
			call.setString(15,);
			call.registerOutParameter(15, Types.NVARCHAR);
			
			call.setString(16,);
			call.registerOutParameter(16, Types.NVARCHAR);
			
			call.setString(17,);
			call.registerOutParameter(17, Types.NVARCHAR);
			
			call.setString(18,);
			call.registerOutParameter(18, Types.NVARCHAR);
			
			call.setString(19,);
			call.registerOutParameter(19, Types.NVARCHAR);
			
			call.setString(20,);
			call.registerOutParameter(20, Types.NVARCHAR);
			
			call.setString(21,);
			call.registerOutParameter(21, Types.NVARCHAR);
			
			call.setString(22,);
			call.registerOutParameter(22, Types.NVARCHAR);
			
			call.setString(23,);
			call.registerOutParameter(23, Types.NVARCHAR);
			
			call.setString(24,);
			call.registerOutParameter(24, Types.NVARCHAR);
			
			call.setString(25,);
			call.registerOutParameter(25, Types.NVARCHAR);
			
			call.setString(26,);
			call.registerOutParameter(26, Types.NVARCHAR);
			
			call.setString(27,);
			call.registerOutParameter(27, Types.NVARCHAR);
			
			call.setString(28,);
			call.registerOutParameter(28, Types.NVARCHAR);
			
			call.setString(29,);
			call.registerOutParameter(29, Types.NVARCHAR);
			
			call.setString(30,);
			call.registerOutParameter(30, Types.NVARCHAR);
			
			call.setString(31,);
			call.registerOutParameter(31, Types.NVARCHAR);
			
			call.setString(32,);
			call.registerOutParameter(32, Types.NVARCHAR);
			
			call.setString(33,);
			call.registerOutParameter(33, Types.NVARCHAR);
			
			call.setString(34,);
			call.registerOutParameter(34, Types.NVARCHAR);
			
			call.setString(35,);
			call.registerOutParameter(35, Types.NVARCHAR);
			
			call.setString(36,);
			call.registerOutParameter(36, Types.NVARCHAR);
			
			call.setString(37,);
			call.registerOutParameter(37, Types.NVARCHAR);
			
			call.setString(38,);
			call.registerOutParameter(38, Types.NVARCHAR);
			
			call.setString(39,);
			call.registerOutParameter(39, Types.NVARCHAR);
			
			call.setString(40,);
			call.registerOutParameter(40, Types.NVARCHAR);
			
			call.setString(41,);
			call.registerOutParameter(41, Types.NVARCHAR);
			
			call.setString(42,);
			call.registerOutParameter(42, Types.NVARCHAR);
			
			call.setString(43,);
			call.registerOutParameter(43, Types.NVARCHAR);
			
			call.setString(44,);
			call.registerOutParameter(44, Types.NVARCHAR);
			
			call.setString(45,);
			call.registerOutParameter(45, Types.NVARCHAR);
			
			call.setString(46,);
			call.registerOutParameter(46, Types.NVARCHAR);
			
			call.setString(47,);
			call.registerOutParameter(47, Types.NVARCHAR);
			
			call.setString(48,);
			call.registerOutParameter(48, Types.NVARCHAR);
			
			call.setString(49,);
			call.registerOutParameter(49, Types.NVARCHAR);
			
			call.setString(50,);
			call.registerOutParameter(50, Types.NVARCHAR);			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

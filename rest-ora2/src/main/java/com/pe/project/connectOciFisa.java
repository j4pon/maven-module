package com.pe.project;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.ucp.UniversalConnectionPoolAdapter;
import oracle.ucp.UniversalConnectionPoolException;
import oracle.ucp.admin.UniversalConnectionPoolManager;
import oracle.ucp.admin.UniversalConnectionPoolManagerImpl;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public class connectOciFisa {

	private static PoolDataSource pds = null;
	private static String DRIVER = "oracle.jdbc.pool.OracleDataSource";;
	private static String URL=  "jdbc:oracle:thin:@//50.116.21.223:1521/XE";
	private static String USER = "MON";
	private static String PASS = "MON";
	private static String EFT_POOL= "EFTFISA";
	private static int POOLSIZE= 5;
	private static UniversalConnectionPoolManager mgr;

	public static PoolDataSource getInstance() {

		try {
			if (pds == null) {
				
				pds = PoolDataSourceFactory.getPoolDataSource();
				pds.setConnectionPoolName(EFT_POOL);
				pds.setConnectionFactoryClassName(DRIVER);
				pds.setURL(URL);
				pds.setUser(USER);
				pds.setPassword(PASS);
				pds.setInitialPoolSize(POOLSIZE);
				pds.setMinPoolSize(1);
				pds.setMaxPoolSize(10);
				
				mgr = UniversalConnectionPoolManagerImpl.getUniversalConnectionPoolManager();
				mgr.createConnectionPool((UniversalConnectionPoolAdapter) pds);
				mgr.startConnectionPool(EFT_POOL);

			}

		} catch (SQLException e) {
			System.out.println("SQLException e");
			e.printStackTrace();

		} catch (UniversalConnectionPoolException e) {
			System.out.println("UniversalConnectionPoolException");
			e.printStackTrace();
		}
		return pds;

	}

	public static Connection openConnection() throws SQLException, UniversalConnectionPoolException {
		//UniversalConnectionPool pool = mgr.getConnectionPool(NAMEPOOL);
		
		//System.out.println("\nUniversal Connection Pool Object for " + pool.getName() + " is obtained");    
		return connectOciFisa.getInstance().getConnection();

	}

	public static void estadisticas() {

		int totalConnsCount = pds.getStatistics().getAvailableConnectionsCount();
		System.out.println("The total connetion count in the pool is " + totalConnsCount + ".");

	}
	
}

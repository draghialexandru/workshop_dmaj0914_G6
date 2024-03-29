package DBLayer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

/**
 * @Author group 6 
 * @Version 16.03.2015
 */

public class DbConnection { 
private static final String driver = "jdbc:sqlserver://kraka.ucn.dk:1433";
private static final String databaseName = ";databaseName=dmaj0914_2Sem_6";

	private static String userName = "; user=dmaj0914_2Sem_6";
	private static String password = ";password=IsAllowed";

	private DatabaseMetaData dma;
	private static Connection con;

	private static DbConnection instance = null;

	private DbConnection() {
		String url = driver + databaseName + userName + password;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Load af class ok");

		} catch (Exception e) {
			System.out.println("Can not find the driver");
			System.out.println(e.getMessage());
		}
		try {

			con = DriverManager.getConnection(url);
			con.setAutoCommit(true);
			dma = con.getMetaData(); 
			System.out.println("Connection to " + dma.getURL());
			System.out.println("Driver " + dma.getDriverName());
			System.out.println("Database product name "
					+ dma.getDatabaseProductName());
		}
		catch (Exception e) {

			System.out.println("Problems with the connection to the database");
			System.out.println(e.getMessage());
			System.out.println(url);
		}
	}

	public static void closeConnection() {
		try {
			con.close();
			System.out.println("The connection is closed");
		} catch (Exception e) {
			System.out.println("Error trying to close the database "
					+ e.getMessage());
		}
	}

	public Connection getDBcon() {
		return con;
	}

	public static DbConnection getInstance() {
		if (instance == null) {
			instance = new DbConnection();
		}
		return instance;
	}

	public static void startTransaction() {
		try {
			con.setAutoCommit(false);
		} catch (Exception e) {
			System.out.println("fejl start transaction");
			System.out.println(e.getMessage());
		}
	}

	public static void commitTransaction() {
		try {
			con.setAutoCommit(true);
		} catch (Exception e) {
			System.out.println("fejl commit transaction");
			System.out.println(e.getMessage());
		}
	}

	public static void rollbackTransaction() {
		try {
			con.rollback();
			con.setAutoCommit(true);
		} catch (Exception e) {
			System.out.println("fejl rollback transaction");
			System.out.println(e.getMessage());
		}
	}
}

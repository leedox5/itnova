package itnova;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itnova.util.LocalContext;
import com.itnova.util.LocalContextFactory;

public class DbHelper {
	Connection conn;
	public DbHelper() {
		
		try {
			LocalContext ctx = LocalContextFactory.createLocalContext("org.sqlite.JDBC");
			ctx.addDataSource("jdbc/emp", "jdbc:sqlite:MYDB.db", null, null);
			DataSource ds = (DataSource) new InitialContext().lookup("jdbc/emp");
			conn = ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
}

package kr.co.itnova.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	public static String executeDBScripts(Connection con, String scripts) throws SQLException {
		String[] dbCommands = scripts.split("\nGO"); 
		Statement stmt = con.createStatement();
		StringBuffer result = new StringBuffer();
		
		result.append("--------------------------------------------------------------- \n");
		try {
			for(String cmd : dbCommands){
				if(!cmd.trim().equals("")) {
					result.append(getMsg(cmd));
					String ret = executeCommand(stmt, cmd);
					result.append(ret);
					result.append("--------------------------------------------------------------- \n");
				}
			}
		} catch(Exception e) {
			result.append(String.format("> Error: %s \n", e.getMessage()));
		} finally {
		    try { if(stmt != null) stmt.close(); } catch(SQLException e) { System.err.println(e); }    
		}
		return result.toString();
	}

	private static String executeCommand(Statement stmt, String cmd) {
		try {
			stmt.executeUpdate(cmd);
			return "> Success! \n";
		} catch(Exception e) {
			return String.format("> Error: %s \n", e.getMessage());
		}
	}

	private static String getMsg(String cmd) {
		String[] validCmd = {"DROP","CREATE","GRANT","INSERT"};
		String[] lines = cmd.split("\n");
		String ret = "";
		for(String line : lines) {
			if(StringUtility.isContainStr(line, validCmd)) {
				ret = line;
				break;
			}
		}
		return ret + "\n";
	}
}

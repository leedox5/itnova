package itnova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	private Connection connection;
	
	public EmpDao() {
		
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public List<EmpVo> getList(){
        List<EmpVo> list = new ArrayList<EmpVo>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = " SELECT ST_NUM, ST_NAME, D_NUM FROM STUDENT ";

            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
            	EmpVo vo = new EmpVo();
                vo.setNum(rs.getString(1));
                vo.setName(rs.getString(2));
                vo.setDeptNum(rs.getString(3));

                list.add(vo);
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
}

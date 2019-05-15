package cn.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class JDBCUtils_V1 {
	public static Connection getConnection(){
		Connection conn=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得连接
			 conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/web08","root","dre@mtech1012");
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
		return conn;
	}
	public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	@Test
	public void testUtils() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			//1.获取连接
			conn=JDBCUtils_V1.getConnection();
			//2.编写sql语句
			String sql="select * from tb_user";
			//3.获取执行sql语句对象
			 pstmt=conn.prepareStatement(sql);
			//4.执行查询操作
			rs=pstmt.executeQuery();
			if(rs.next()){
				System.out.println(rs.getString("userName"));
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			// 7.释放资源
						JDBCUtils_V1.release(conn, pstmt, rs);
						System.out.println("资源已经释放");
		}
	}
}

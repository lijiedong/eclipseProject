package cn.itheima.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;





public class testLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}
	@Test
	public void testUnit(){
		try {
			login("","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void login(String userName,String password) throws ClassNotFoundException, SQLException{
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/web08","root","dre@mtech1012");
		//3.创建执行sql语句的对象
		Statement stmt=conn.createStatement();
		//4.书写sql语句
		String sqlStr="select * from tb_user";
		//5.创建预处理对象
		PreparedStatement pstmt=conn.prepareStatement(sqlStr);
		//6.执行查询操作
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			System.out.println("登陆成功！");
			System.out.println(rs.getString("userName"));
		}else{
			System.out.println("登陆失败！");
		}
		
	}
}

package cn.itheima.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;


import cn.itheima.jdbc.DataSource.myDataSource;
import cn.itheima.jdbc.DataSource.myDataSource2;
import cn.itheima.jdbc.utils.JDBCUtils_V3;

public class TestMyDataSource {
	/*
	 *添加用户使用未改造过的connection 
	 */
		//@Test
		public void test1(){
			Connection conn=null;
			PreparedStatement pstmt=null;
			//1.创建自定义连接池对象
			myDataSource dataSource=new myDataSource();
			try{
				//2.从池子中获取连接
				
				conn=dataSource.getConnection();
				
				String sql="insert into tb_user values(null,?,?)";
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setString(1, "11user");
				pstmt.setString(2, "11mima");
				int rows=pstmt.executeUpdate();
				if(rows>0){
					System.out.println("插入成功");
					
				}else{
					System.out.println("插入失败");
				}
			
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				//3.归还连接池对象
				dataSource.backConnection(conn);
			}
		}
		/**
		 * 测试使用修改过的connection对象插入用户
		 */
		@Test
		public void test2(){
			Connection conn=null;
			PreparedStatement pstmt=null;
			//1.创建自定义连接池对象
			myDataSource2 dataSource=new myDataSource2();
			try{
				//2.从池子中获取连接
				
				conn=dataSource.getConnection();
				
				String sql="insert into tb_user values(null,?,?)";
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setString(1, "11user1");
				pstmt.setString(2, "11mima1");
				int rows=pstmt.executeUpdate();
				if(rows>0){
					System.out.println("插入成功");
					
				}else{
					System.out.println("插入失败");
				}
			
			}catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				//3.归还连接池对象
				//dataSource.backConnection(conn);
				JDBCUtils_V3.release(conn, pstmt, null);
			}
		}
		//@Test
		public void testv3() throws SQLException{
			String sqlStr="select * from tb_user";
			Connection  conn=JDBCUtils_V3.getConnection();
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

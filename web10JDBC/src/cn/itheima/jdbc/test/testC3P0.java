package cn.itheima.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.itheima.jdbc.DataSource.myDataSource2;
import cn.itheima.jdbc.utils.JDBCUtils_V3;

public class testC3P0 {
	@Test
	public void testc3p0(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		//1.创建自定义连接池对象
		//myDataSource2 dataSource=new myDataSource2();
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try{
			//2.从池子中获取连接
			
			conn=dataSource.getConnection();
			
			String sql="insert into tb_user values(null,?,?)";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, "11user2");
			pstmt.setString(2, "11mima2");
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
}

package cn.itheima.jdbc.DataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import cn.itheima.jdbc.utils.JDBCUtils_V3;

public class myDataSource2 implements DataSource {
	//1.创建一个容器用于存储Connection对象
	private static LinkedList<Connection> pool=new LinkedList<>();
	//2.创建5个连接放到容器中
	static{
		for(int i=0;i<5;i++){
			Connection conn = JDBCUtils_V3.getConnection();
			//放入池子中connection对象已经经过改造了
			MyConnection myconn = new MyConnection(conn, pool);
			pool.add(myconn);
		}
	}
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		//3使用前先判断
		if(pool.size()==0){
			//4.池子里为空，我们再创建一些
			for(int i=0;i<5;i++){
				conn = JDBCUtils_V3.getConnection();
				MyConnection myconn = new MyConnection(conn, pool);
				pool.add(myconn);
			}
		}
		//5.从池子里获取一个连接对象
		conn=pool.remove(0);
		return conn;
		
	}
	/**
	 * 重现获取连接的方法
	 */
	@Override
	public Connection getConnection(String arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * 归还对象到连接池中
	 */
	public void backConnection(Connection conn){
		pool.add(conn);
	}

}

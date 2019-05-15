package com.dlj.mytypehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

@MappedTypes({ String.class })
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyStringTypeHandler implements TypeHandler<String> {

	@Override
	public String getResult(CallableStatement arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getResult(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getResult(ResultSet arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParameter(PreparedStatement arg0, int arg1, String arg2, JdbcType arg3) throws SQLException {
		// TODO Auto-generated method stub

	}

}

package com.dlj.dbutils;

import org.apache.commons.dbutils.QueryRunner;

import com.dlj.utils.DataSourceUtils;

public class DBUtilsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	}

}

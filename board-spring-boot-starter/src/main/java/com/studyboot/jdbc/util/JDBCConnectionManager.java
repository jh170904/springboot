package com.studyboot.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

// 특정 데이터베이스와 커넥션을 관리하기 위한 멤버변수 소유
public class JDBCConnectionManager {
	private String driverClass;
	private String url;
	private String username;
	private String password;
	
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	// 커넥션 객체를 리턴
	public Connection getConnection() {
		try {
			Class.forName(driverClass);
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("JDBCConnectionManager [driverClass=");		

		sb.append(driverClass)
		.append(",url=").append(url)
		.append(",username=").append(username)
		.append(",password=").append(password)
		.append("]");
		return sb.toString();
	}
	
}

package com.mj;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class DbConnection {

	protected Connection conn = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	protected CallableStatement cl = null;

	@Autowired
	@Qualifier("datasource")
	private DataSource dataSource;

	private static final Logger logger = LoggerFactory.getLogger(DbConnection.class);

	public void connect() {
		try {
			this.conn = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			if (this.conn == null)
				this.connect();
			else if (this.conn.isClosed())
				this.connect();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		return this.conn;
	}

	public void closeConnection() throws Exception {
		try {
			if (conn != null) {
				conn.close();
			}

			if (ps != null) {
				ps.close();
			}

			if (rs != null) {
				rs.close();
			}

			if (cl != null) {
				cl.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
	}

}

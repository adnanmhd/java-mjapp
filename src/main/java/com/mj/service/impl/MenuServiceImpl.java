package com.mj.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.DbConnection;
import com.mj.dao.MenuDao;
import com.mj.entity.MenuEntity;
import com.mj.service.MenuService;

@Service
public class MenuServiceImpl extends DbConnection implements MenuService {

	@Autowired
	private MenuDao dao;

	@Override
	public void setConnection(Connection conn) throws Exception {
		this.conn = conn;

	}

	@Override
	public void closeStatement() throws Exception {
		try {
			if (this.ps != null) {
				this.ps.close();
			}

			if (this.rs != null) {
				this.rs.close();
			}

			if (this.cl != null) {
				this.cl.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<MenuEntity> getAllMenu() throws Exception {
		
		List<MenuEntity> result = new ArrayList<MenuEntity>();
		try {
			this.conn = this.getConnection();
			this.conn.setAutoCommit(false);
			dao.setConnection(conn);
			result = dao.getAllMenu();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally{
			this.conn.close();
		}
		return result;
	}

}

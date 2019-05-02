package com.mj.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<MenuEntity> getMenu(int idJenisMenu) throws Exception {

		String query = "";
		if (idJenisMenu != 0) {
			query = "and menu.id_jenis_menu = " + idJenisMenu;
		}
		List<MenuEntity> result = new ArrayList<MenuEntity>();
		try {
			this.conn = this.getConnection();
			this.conn.setAutoCommit(false);
			dao.setConnection(conn);
			result = dao.getMenu(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception(e);
		} finally {
			this.conn.close();
		}
		return result;
	}

	@Override
	public List<MenuEntity> addMenu(MenuEntity entity) throws Exception {
		
		List<MenuEntity> listData = new ArrayList<MenuEntity>();		
		String query = "and menu.kode_menu = " + entity.getKodeMenu();
		Boolean addMenu = false;
		
		try {
			this.conn = this.getConnection();
			this.conn.setAutoCommit(false);
			dao.setConnection(conn);

			addMenu = dao.addMenu(entity);

			if (addMenu) {
				this.conn.commit();
				listData = dao.getMenu(query);				
			}			

		} catch (Exception e) {
			System.out.println("error here: " + e.getMessage());			
			throw new Exception(e);
		} finally {
			this.conn.close();
		}
		return listData;
	}

	@Override
	public Boolean updateMenu(MenuEntity entity) throws Exception {
		
		Boolean updateMenu = false;		

		try {
			this.conn = this.getConnection();
			this.conn.setAutoCommit(false);
			dao.setConnection(conn);

			updateMenu = dao.updateMenu(entity);

			if (updateMenu) {
				this.conn.commit();								
			}			

		} catch (Exception e) {
			System.out.println(e.getMessage());		
			throw new Exception(e);
		} finally {
			this.conn.close();
		}
		return updateMenu;
	}

	@Override
	public Boolean deleteMenu(MenuEntity entity) throws Exception {
		
		Boolean deleteMenu = false;
		
		try {
			this.conn = this.getConnection();
			this.conn.setAutoCommit(false);
			dao.setConnection(conn);

			deleteMenu = dao.deleteMenu(entity);

			if (deleteMenu) {
				this.conn.commit();								
			}
			

		} catch (Exception e) {			
			System.out.println(e.getMessage());		
			throw new Exception(e);
		} finally {
			this.conn.close();
		}
		return deleteMenu;
	}

}

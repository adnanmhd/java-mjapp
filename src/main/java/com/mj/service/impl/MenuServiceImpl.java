package com.mj.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mj.DbConnection;
import com.mj.dao.MenuDao;
import com.mj.entity.MenuEntity;
import com.mj.entity.ResponseMenuEntity;
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
		} finally {
			this.conn.close();
		}
		return result;
	}

	@Override
	public ResponseMenuEntity addMenu(MenuEntity entity) throws Exception {
		ResponseMenuEntity ResponseEntity = new ResponseMenuEntity();
		List<MenuEntity> menuEntity = new ArrayList<MenuEntity>();

		String query = "and menu.kode_menu = " + entity.getKodeMenu();
		Boolean addMenu = false;
		ResponseEntity.setMessage("insert data failed");
		ResponseEntity.setStatus(addMenu);

		try {
			this.conn = this.getConnection();
			this.conn.setAutoCommit(false);
			dao.setConnection(conn);

			addMenu = dao.addMenu(entity);

			if (addMenu) {
				this.conn.commit();
				menuEntity = dao.getMenu(query);
				ResponseEntity.setMessage("insert data success");
				ResponseEntity.setStatus(addMenu);
			}

			ResponseEntity.setData(menuEntity);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ResponseEntity.setException(e.getMessage());
		} finally {
			this.conn.close();
		}
		return ResponseEntity;
	}

	@Override
	public ResponseMenuEntity updateMenu(MenuEntity entity) throws Exception {

		ResponseMenuEntity ResponseEntity = new ResponseMenuEntity();
		List<MenuEntity> menuEntity = new ArrayList<MenuEntity>();

		String query = "and menu.kode_menu = " + entity.getKodeMenu();
		Boolean updateMenu = false;
		ResponseEntity.setMessage("update data failed");
		ResponseEntity.setStatus(updateMenu);

		try {
			this.conn = this.getConnection();
			this.conn.setAutoCommit(false);
			dao.setConnection(conn);

			updateMenu = dao.updateMenu(entity);

			if (updateMenu) {
				this.conn.commit();
				menuEntity = dao.getMenu(query);
				ResponseEntity.setMessage("update data success");
				ResponseEntity.setStatus(updateMenu);
			}

			ResponseEntity.setData(menuEntity);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ResponseEntity.setException(e.getMessage());
		} finally {
			this.conn.close();
		}
		return ResponseEntity;
	}

	@Override
	public Map<String, Object> deleteMenu(MenuEntity entity) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Boolean deleteMenu = false;
		map.put("status", deleteMenu);
		map.put("message", "delete data failed");
		try {
			this.conn = this.getConnection();
			this.conn.setAutoCommit(false);
			dao.setConnection(conn);

			deleteMenu = dao.deleteMenu(entity);

			if (deleteMenu) {
				this.conn.commit();				
				map.put("status", deleteMenu);
				map.put("message", "delete data success");				
			}
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
			map.put("exception", e.getMessage());
		} finally {
			this.conn.close();
		}
		return map;
	}

}

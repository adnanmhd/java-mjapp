package com.mj.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.stereotype.Repository;

import com.mj.constant.ConstantSql;
import com.mj.dao.MenuDao;
import com.mj.entity.MenuEntity;

import ch.qos.logback.core.subst.Token.Type;

@Repository
public class MenuDaoImpl implements MenuDao {

	private Connection conn;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private CallableStatement cl = null;

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
	public List<MenuEntity> getMenu(String query) throws Exception {
		List<MenuEntity> result = new ArrayList<MenuEntity>();

		try {

			this.ps = this.conn.prepareStatement(ConstantSql.getAllMenu + query);
			this.rs = this.ps.executeQuery();
			while (this.rs.next()) {
				MenuEntity dataMenu = new MenuEntity();
				dataMenu.setIdMenu(this.rs.getInt("id_menu"));
				dataMenu.setKodeMenu(this.rs.getString("kode_menu"));
				dataMenu.setNamaMenu(this.rs.getString("nama_menu"));
				dataMenu.setIdJenisMenu(this.rs.getInt("id_jenis_menu"));
				dataMenu.setJenisMenu(this.rs.getString("jenis_menu"));
				dataMenu.setHarga(this.rs.getLong("harga"));
				dataMenu.setGambar(this.rs.getString("gambar"));
				result.add(dataMenu);
			}

		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			closeStatement();
		}

		return result;
	}

	@Override
	public Boolean addMenu(MenuEntity entity) throws Exception {
		Boolean addMenu = false;
		try {

			this.ps = this.conn.prepareStatement(ConstantSql.insertMenu);			
			this.ps.setString(1, entity.getKodeMenu());
			this.ps.setString(2, entity.getNamaMenu());
			this.ps.setInt(3, entity.getIdJenisMenu());
			this.ps.setLong(4, entity.getHarga());
			this.ps.setString(5, entity.getGambar());
				
			this.ps.executeUpdate();
			
			addMenu = true;

		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			closeStatement();
		}

		return addMenu;
	}

	@Override
	public Boolean updateMenu(MenuEntity entity) throws Exception {
		Boolean updateMenu = false;
		try {

			this.ps = this.conn.prepareStatement(ConstantSql.updateMenu);			
			this.ps.setString(1, entity.getKodeMenu());
			this.ps.setString(2, entity.getNamaMenu());
			this.ps.setInt(3, entity.getIdJenisMenu());
			this.ps.setLong(4, entity.getHarga());
			this.ps.setString(5, entity.getGambar());
			this.ps.setInt(6,  entity.getIdMenu());
				
			this.ps.executeUpdate();
			
			updateMenu = true;

		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			closeStatement();
		}

		return updateMenu;
	}

	@Override
	public Boolean deleteMenu(MenuEntity entity) throws Exception {
		Boolean deleteMenu = false;
		try {

			this.ps = this.conn.prepareStatement(ConstantSql.deleteMenu);						
			this.ps.setInt(1,  entity.getIdMenu());
				
			this.ps.executeUpdate();
			
			deleteMenu = true;

		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			closeStatement();
		}

		return deleteMenu;
	}
		
}

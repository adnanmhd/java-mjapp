package com.mj.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mj.constand.ConstandSql;
import com.mj.dao.MenuDao;
import com.mj.entity.MenuEntity;

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
	public List<MenuEntity> getAllMenu() throws Exception {
		List<MenuEntity> result = new ArrayList<MenuEntity>();

		try {

			this.ps = this.conn.prepareStatement(ConstandSql.getAllMenu);
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

}

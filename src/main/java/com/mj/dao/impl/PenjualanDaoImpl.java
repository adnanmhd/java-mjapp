package com.mj.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

import org.springframework.stereotype.Repository;

import com.mj.constant.ConstantSql;
import com.mj.dao.PenjualanDao;
import com.mj.entity.MenuJualEntity;

@Repository
public class PenjualanDaoImpl implements PenjualanDao {

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
	public String getIdBill() throws Exception {
		String idBill;
		try {

			this.cl = this.conn.prepareCall(ConstantSql.getIdBill);
			this.cl.setString(1, "MJ"); // ID SEQUENCE UNTUK GENERATE NO BILL ADALAH "MJ"
			this.cl.registerOutParameter(2, Types.VARCHAR);
			this.cl.executeQuery();

			idBill = cl.getString(2);

		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			closeStatement();
		}

		return idBill;
	}

	@Override
	public Boolean increaseSequence() throws Exception {
		Boolean update = false;

		try {

			this.ps = this.conn.prepareStatement(ConstantSql.updateSequence);
			this.ps.setString(1, "MJ"); // INCREASE SEQUENCE DENGAN ID 'MJ'
			this.ps.executeUpdate();
			update = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception(e);
		} finally {
			closeStatement();
		}
		return update;
	}

	@Override
	public Boolean insertItemTerjual(String idBill, Timestamp waktuJual, MenuJualEntity entity) throws Exception {
		Boolean insert = false;

		long total = entity.getHarga() * entity.getJumlah();

		try {

			this.ps = this.conn.prepareStatement(ConstantSql.insertItemTerjual);
			this.ps.setString(1, idBill);
			this.ps.setString(2, entity.getNamaMenu().toUpperCase());
			this.ps.setString(3, entity.getJenisMenu().toUpperCase());
			this.ps.setLong(4, entity.getHarga());
			this.ps.setInt(5, entity.getJumlah());
			this.ps.setLong(6, total);
			this.ps.setTimestamp(7, waktuJual);
			this.ps.executeUpdate();
			insert = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception(e);
		} finally {
			closeStatement();
		}
		return insert;
	}

}

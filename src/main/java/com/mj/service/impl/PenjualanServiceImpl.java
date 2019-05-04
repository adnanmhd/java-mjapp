package com.mj.service.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.DbConnection;
import com.mj.dao.PenjualanDao;
import com.mj.entity.MenuJualEntity;
import com.mj.entity.PenjualanEntity;
import com.mj.entity.ReportPenjualanEntity;
import com.mj.service.PenjualanService;

@Service
public class PenjualanServiceImpl extends DbConnection implements PenjualanService {

	@Autowired
	private PenjualanDao dao;

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
	public PenjualanEntity addItemJual(PenjualanEntity entity) throws Exception {
		
		java.util.Date timeDetail = new java.util.Date();
		java.sql.Timestamp timeStamp = new java.sql.Timestamp(timeDetail.getTime());
		entity.setWaktuJual(timeStamp);
		try {

			this.conn = this.getConnection();
			this.conn.setAutoCommit(false);
			dao.setConnection(conn);

			entity.setIdBill(dao.getIdBill());
			
			boolean insert = false;

			for (MenuJualEntity menuJual : entity.getData()) {
				
				insert = dao.insertItemTerjual(entity.getIdBill(), entity.getWaktuJual(), menuJual);
				
				if(!insert) {
					break;
				}
			}
			
			if(insert) {
				dao.increaseSequence();
				this.conn.commit();		
			} else {
				throw new Exception("data penjualan gagal disimpan");
			}

		} catch (Exception e) {
			throw new Exception(e);

		} finally {
			this.conn.close();

		}
		return entity;
	}

	@Override
	public ReportPenjualanEntity getDataPenjualan(String dateRange1, String dateRange2) throws Exception {
		ReportPenjualanEntity entity = new ReportPenjualanEntity();
		
		try {
			this.conn = this.getConnection();
			this.conn.setAutoCommit(false);
			dao.setConnection(conn);
			
			entity = dao.getDataPenjualan(dateRange1, dateRange2);
			
		} catch(Exception e) {
			throw new Exception(e);

		} finally {
			this.conn.close();

		}
		return entity;
	}

}

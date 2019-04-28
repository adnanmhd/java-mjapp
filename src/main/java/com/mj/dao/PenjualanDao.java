package com.mj.dao;

import java.sql.Connection;
import java.sql.Timestamp;

import com.mj.entity.MenuJualEntity;

public interface PenjualanDao {
	public void setConnection(Connection conn) throws Exception;

	public void closeStatement() throws Exception;

	public String getIdBill() throws Exception;

	public Boolean increaseSequence() throws Exception;

	public Boolean insertItemTerjual(String idBill, Timestamp waktuJual, MenuJualEntity entity) throws Exception;
}

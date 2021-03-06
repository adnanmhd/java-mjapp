package com.mj.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class PenjualanEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String idBill;
	
	private Timestamp waktuJual;
	
	private List<MenuJualEntity> data;			

	public String getIdBill() {
		return idBill;
	}

	public void setIdBill(String idBill) {
		this.idBill = idBill;
	}

	public List<MenuJualEntity> getData() {
		return data;
	}

	public void setData(List<MenuJualEntity> data) {
		this.data = data;
	}	

	public Timestamp getWaktuJual() {
		return waktuJual;
	}

	public void setWaktuJual(Timestamp timeStamp) {
		this.waktuJual = timeStamp;
	}

}

package com.mj.entity;

import java.io.Serializable;

public class MenuJualEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String namaMenu;	
	private String jenisMenu;
	private Long harga;
	private Integer jumlah;
	
	public String getNamaMenu() {
		return namaMenu;
	}

	public void setNamaMenu(String namaMenu) {
		this.namaMenu = namaMenu;
	}

	public String getJenisMenu() {
		return jenisMenu;
	}

	public void setJenisMenu(String jenisMenu) {
		this.jenisMenu = jenisMenu;
	}

	public Long getHarga() {
		return harga;
	}

	public void setHarga(Long harga) {
		this.harga = harga;
	}

	public Integer getJumlah() {
		return jumlah;
	}

	public void setJumlah(Integer jumlah) {
		this.jumlah = jumlah;
	}
	
	

}

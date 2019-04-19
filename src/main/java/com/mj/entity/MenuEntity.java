package com.mj.entity;

import java.io.Serializable;

public class MenuEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idMenu;
	private String kodeMenu;
	private String namaMenu;
	private Integer idJenisMenu;
	private String jenisMenu;
	private Long harga;
	private String gambar;

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getKodeMenu() {
		return kodeMenu;
	}

	public void setKodeMenu(String kodeMenu) {
		this.kodeMenu = kodeMenu;
	}

	public String getNamaMenu() {
		return namaMenu;
	}

	public void setNamaMenu(String namaMenu) {
		this.namaMenu = namaMenu;
	}

	public Integer getIdJenisMenu() {
		return idJenisMenu;
	}

	public void setIdJenisMenu(Integer idJenisMenu) {
		this.idJenisMenu = idJenisMenu;
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

	public String getGambar() {
		return gambar;
	}

	public void setGambar(String gambar) {
		this.gambar = gambar;
	}

}

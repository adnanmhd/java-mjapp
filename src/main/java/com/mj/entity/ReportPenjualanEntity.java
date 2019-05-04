package com.mj.entity;

import java.io.Serializable;
import java.util.List;

public class ReportPenjualanEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long totalPenjualan;
	private String waktuPenjualan;
	private List<ReportPenjualan> dataPenjualan;

	public Long getTotalPenjualan() {
		return totalPenjualan;
	}	

	public String getWaktuPenjualan() {
		return waktuPenjualan;
	}


	public void setWaktuPenjualan(String waktuPenjualan) {
		this.waktuPenjualan = waktuPenjualan;
	}


	public void setTotalPenjualan(Long totalPenjualan) {
		this.totalPenjualan = totalPenjualan;
	}

	public List<ReportPenjualan> getDataPenjualan() {
		return dataPenjualan;
	}

	public void setDataPenjualan(List<ReportPenjualan> data) {
		this.dataPenjualan = data;
	}

	public static class ReportPenjualan{

		private String idBill;
		private String waktuJual;
		private String namaMenu;	
		private String jenisMenu;
		private Long harga;
		private Integer jumlah;	
		private Integer total;

		public String getIdBill() {
			return idBill;
		}

		public void setIdBill(String idBill) {
			this.idBill = idBill;
		}
		
		public String getWaktuJual() {
			return waktuJual;
		}

		public void setWaktuJual(String waktuJual) {
			this.waktuJual = waktuJual;
		}

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

		public Integer getTotal() {
			return total;
		}

		public void setTotal(Integer total) {
			this.total = total;
		}
		
	}
}

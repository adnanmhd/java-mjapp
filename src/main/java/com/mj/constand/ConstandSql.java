package com.mj.constand;

public class ConstandSql {

	public static final String getAllMenu = "SELECT menu.id_menu,"
			+ " menu.kode_menu, menu.nama_menu, menu.id_jenis_menu, "
			+ "jenis_menu.jenis_menu, menu.harga, menu.gambar "
			+ "FROM menu, jenis_menu "
			+ "WHERE menu.id_jenis_menu = jenis_menu.id_jenis_menu";

}

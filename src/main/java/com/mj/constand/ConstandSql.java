package com.mj.constand;

public class ConstandSql {

	public static final String getAllMenu = "SELECT menu.id_menu,"
			+ " menu.kode_menu, menu.nama_menu, menu.id_jenis_menu, "
			+ "jenis_menu.jenis_menu, menu.harga, menu.gambar "
			+ "FROM menu, jenis_menu "
			+ "WHERE menu.id_jenis_menu = jenis_menu.id_jenis_menu ";	
	
	public static final String insertMenu = "INSERT INTO menu(kode_menu, nama_menu, id_jenis_menu, harga, gambar) "
			+ "VALUES(?, ?, ?, ?, ?)";
	
	public static final String updateMenu = "UPDATE menu SET kode_menu = ?, "
			+ "nama_menu = ?, id_jenis_menu = ?, harga = ?, gambar = ?"
			+ "WHERE id_menu = ?";
	
	public static final String deleteMenu = "DELETE FROM menu WHERE id_menu = ?";
}

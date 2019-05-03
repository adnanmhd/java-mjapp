package com.mj.constant;

public class ConstantSql {

	public static final String getAllMenu = "SELECT menu.id_menu,"
			+ " menu.kode_menu, menu.nama_menu, menu.id_jenis_menu, "
			+ "jenis_menu.jenis_menu, menu.harga, menu.gambar "
			+ "FROM menu, jenis_menu "
			+ "WHERE menu.id_jenis_menu = jenis_menu.id_jenis_menu ";	
	
	public static final String getMenuByCode = "SELECT menu.id_menu,"
			+ " menu.kode_menu, menu.nama_menu, menu.id_jenis_menu, "
			+ "jenis_menu.jenis_menu, menu.harga, menu.gambar "
			+ "FROM menu, jenis_menu "
			+ "WHERE menu.id_jenis_menu = jenis_menu.id_jenis_menu and menu.kode_menu = LPAD(?, 5, 0)";	
	
	public static final String insertMenu = "INSERT INTO menu(kode_menu, nama_menu, id_jenis_menu, harga, gambar) "
			+ "VALUES(LPAD(UPPER(?), 5, 0), UPPER(?), ?, ?, ?)";
	
	public static final String checkDuplicateKodeMenu = "{? = CALL FUNC_CHECK_DUPLICATE(?)}"; //return 0 or 1, if found duplicate, it returns 1. kode_menu as the parameter
	
	public static final String updateMenu = "UPDATE menu SET kode_menu = ?, "
			+ "nama_menu = ?, id_jenis_menu = ?, harga = ?, gambar = ?"
			+ "WHERE id_menu = ?";
	
	public static final String deleteMenu = "DELETE FROM menu WHERE id_menu = ?";
	
	public static final String getIdBill = "{CALL PROC_GET_SEQUENCE(?, ?)}";
	
	public static final String updateSequence = "UPDATE sequence SET sequence = sequence+1 WHERE id_sequence = ?";
	
	public static final String insertItemTerjual = "INSERT INTO item_terjual(id_bill, nama_menu, jenis_menu, harga, jumlah, total, create_date) " + 
			"VALUES(?, ?, ?, ?, ?, ?, ?)";
}

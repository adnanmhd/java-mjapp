package com.mj.dao;

import java.sql.Connection;
import java.util.List;

import com.mj.entity.MenuEntity;

public interface MenuDao {
	public void setConnection(Connection conn) throws Exception;

	public void closeStatement() throws Exception;

	public List<MenuEntity> getMenu(String query) throws Exception;
	
	public MenuEntity getMenuByCode(MenuEntity entity) throws Exception;
	
	public Boolean addMenu(MenuEntity entity) throws Exception;
	
	public Boolean checkDuplicate(String kode_menu) throws Exception;
	
	public Boolean updateMenu(MenuEntity entity) throws Exception;
	
	public Boolean deleteMenu(MenuEntity entity) throws Exception;
}

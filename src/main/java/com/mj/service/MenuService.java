package com.mj.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.mj.entity.MenuEntity;

public interface MenuService {

	public void setConnection(Connection conn) throws Exception;

	public void closeStatement() throws Exception;
	
	public List<MenuEntity> getMenu(int idJenisMenu) throws Exception;
	
	public List<MenuEntity> addMenu(MenuEntity entity) throws Exception;
	
	public Boolean updateMenu(MenuEntity entity) throws Exception;
	
	public Boolean deleteMenu(MenuEntity entity) throws Exception;
}

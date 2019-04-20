package com.mj.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.mj.entity.MenuEntity;
import com.mj.entity.ResponseMenuEntity;

public interface MenuService {

	public void setConnection(Connection conn) throws Exception;

	public void closeStatement() throws Exception;
	
	public List<MenuEntity> getMenu(int idJenisMenu) throws Exception;
	
	public ResponseMenuEntity addMenu(MenuEntity entity) throws Exception;
	
	public ResponseMenuEntity updateMenu(MenuEntity entity) throws Exception;
	
	public Map<String, Object> deleteMenu(MenuEntity entity) throws Exception;
}

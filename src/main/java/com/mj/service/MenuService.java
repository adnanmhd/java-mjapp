package com.mj.service;

import java.sql.Connection;
import java.util.List;

import com.mj.entity.MenuEntity;

public interface MenuService {

	public void setConnection(Connection conn) throws Exception;

	public void closeStatement() throws Exception;
	
	public List<MenuEntity> getAllMenu() throws Exception;
}

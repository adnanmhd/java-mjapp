package com.mj.service;
import java.sql.Connection;

import com.mj.entity.PenjualanEntity;

public interface PenjualanService {
	public void setConnection(Connection conn) throws Exception;

	public void closeStatement() throws Exception;
	
	public PenjualanEntity addItemJual(PenjualanEntity entity) throws Exception;

}

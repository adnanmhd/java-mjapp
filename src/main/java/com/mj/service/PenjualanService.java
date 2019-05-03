package com.mj.service;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.mj.entity.PenjualanEntity;

public interface PenjualanService {
	public void setConnection(Connection conn) throws Exception;

	public void closeStatement() throws Exception;
	
	public PenjualanEntity addItemJual(PenjualanEntity entity) throws Exception;
	
	public List<Map<String, Object>> getDataPenjualan(String dateRange1, String dateRange2) throws Exception;

}

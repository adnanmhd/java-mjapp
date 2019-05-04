package com.mj.service;
import java.sql.Connection;

import com.mj.entity.PenjualanEntity;
import com.mj.entity.ReportPenjualanEntity;

public interface PenjualanService {
	public void setConnection(Connection conn) throws Exception;

	public void closeStatement() throws Exception;
	
	public PenjualanEntity addItemJual(PenjualanEntity entity) throws Exception;
	
	public ReportPenjualanEntity getDataPenjualan(String dateRange1, String dateRange2) throws Exception;

}

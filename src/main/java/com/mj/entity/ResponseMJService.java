package com.mj.entity;

import java.io.Serializable;

public class ResponseMJService implements Serializable {
	
	public ResponseMJService(Integer status_code, String message) {
		
		if(status_code == 200) {
			
			setStatus_code(status_code);
			setStatus("success");				
			
		} else {
			setStatus_code(status_code);
			setStatus("failed");				
		}
		
		setMessage(message);
		
	}
	
	public ResponseMJService() {
 
	}

	private static final long serialVersionUID = 1L;

	private Object data;

	private String status;
	
	private Integer status_code;

	private String message;

	public Object getData() {
		return data;
	}

	public void setData(Object objEntity) {
		this.data = objEntity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String stat) {
		this.status = stat;
	}		

	public Integer getStatus_code() {
		return status_code;
	}

	public void setStatus_code(Integer status_code) {
		this.status_code = status_code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

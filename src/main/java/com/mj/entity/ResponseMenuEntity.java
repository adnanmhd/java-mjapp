package com.mj.entity;

import java.io.Serializable;
import java.util.List;

public class ResponseMenuEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<MenuEntity> data;
	
	private Boolean status;
	
	private String message;
	
	private String exception;

	public List<MenuEntity> getData() {
		return data;
	}

	public void setData(List<MenuEntity> data) {
		this.data = data;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}
	

}

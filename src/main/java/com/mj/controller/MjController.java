package com.mj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mj.entity.MenuEntity;
import com.mj.service.MenuService;

@RestController
public class MjController {
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String testConnection() throws Exception{
		
		return "Internal Market Price";
	}
	
	@RequestMapping(value = "/foos", method = RequestMethod.GET)
	@ResponseBody
	public String postFoos() {
	    return "Post some Foos";
	}
	
	@RequestMapping(value ="/test", method = RequestMethod.GET)
	public String test() throws Exception{
		
		return "Hello World";
	}
	
	@Autowired
	private MenuService service;
	
	@RequestMapping(value = "/getAllMenu", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getAllMenu(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<MenuEntity> hasil = new ArrayList<MenuEntity>();
		
		try {
			
			hasil = service.getAllMenu();
			map.put("status", true);
			map.put("data", hasil);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch(Exception e){
			map.put("status", false);
			map.put("data", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
				
	}
}

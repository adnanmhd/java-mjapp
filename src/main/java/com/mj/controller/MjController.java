package com.mj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mj.entity.MenuEntity;
import com.mj.entity.ResponseMenuEntity;
import com.mj.service.MenuService;

@RestController
public class MjController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String testConnection() throws Exception {

		return "This is Java Spring Boot Web Service: MJ APP Project v1";
	}

	@Autowired
	private MenuService service;

	@RequestMapping(value = "/getMenu/{id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getMenu(@PathVariable("id") Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MenuEntity> hasil = new ArrayList<MenuEntity>();

		try {

			hasil = service.getMenu(id);
			map.put("status", true);
			map.put("data", hasil);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			map.put("status", false);
			map.put("data", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/getAllMenu", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getAllMenu() {
		return this.getMenu(0);
	}

	@RequestMapping(value = "/addMenu", method = RequestMethod.POST)
	public ResponseEntity<ResponseMenuEntity> addMenu(@RequestBody MenuEntity entity) {
		ResponseMenuEntity hasil = new ResponseMenuEntity();
		try {
			hasil = service.addMenu(entity);
			return new ResponseEntity<ResponseMenuEntity>(hasil, HttpStatus.OK);
		} catch (Exception e) {
			hasil.setMessage(e.getMessage());
			return new ResponseEntity<ResponseMenuEntity>(hasil, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
	public ResponseEntity<ResponseMenuEntity> updateMenu(@RequestBody MenuEntity entity) {
		ResponseMenuEntity hasil = new ResponseMenuEntity();
		try {
			hasil = service.updateMenu(entity);
			return new ResponseEntity<ResponseMenuEntity>(hasil, HttpStatus.OK);
		} catch (Exception e) {
			hasil.setMessage(e.getMessage());
			return new ResponseEntity<ResponseMenuEntity>(hasil, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> deleteMenu(@RequestBody MenuEntity entity) {
		Map<String, Object> hasil = new HashMap<String, Object>();
		try {
			hasil = service.deleteMenu(entity);
			return new ResponseEntity<Map<String, Object>>(hasil, HttpStatus.OK);
		} catch (Exception e) {
			hasil.replace("message", e.getMessage());
			hasil.replace("status", false);
			return new ResponseEntity<Map<String, Object>>(hasil, HttpStatus.BAD_REQUEST);
		}
	}
}

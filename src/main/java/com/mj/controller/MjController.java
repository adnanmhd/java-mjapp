package com.mj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mj.entity.MenuEntity;
import com.mj.entity.PenjualanEntity;
import com.mj.entity.ResponseMJService;
import com.mj.service.MenuService;
import com.mj.service.PenjualanService;

@RestController
public class MjController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String testConnection() throws Exception {

		return "This is Java Spring Boot Web Service: MJ APP Project v1";
	}

	@Autowired
	private MenuService service;
	
	@Autowired
	private PenjualanService servicePenjualan;

	@RequestMapping(value = "/getMenu/{id}", method = RequestMethod.GET)
	public ResponseEntity<ResponseMJService> getMenu(@PathVariable("id") Integer id) {
		
		try {
			ResponseMJService response = new ResponseMJService(200, "data menu");
			
			response.setData(service.getMenu(id)); //id = id jenis menu, getMenu berdasarkan jenis menu			
			return new ResponseEntity<ResponseMJService>(response, HttpStatus.OK);
		} catch (Exception e) {
			ResponseMJService response = new ResponseMJService(400, e.getMessage());
			return new ResponseEntity<ResponseMJService>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/getAllMenu", method = RequestMethod.POST)
	public ResponseEntity<ResponseMJService> getAllMenu() {
		return this.getMenu(0); //id 0 sebagai value untuk mendapatkan semua jenis menu
	}

	@RequestMapping(value = "/addMenu", method = RequestMethod.POST)
	public ResponseEntity<ResponseMJService> addMenu(@RequestBody MenuEntity entity) {
		
		try {
									
			ResponseMJService response = new ResponseMJService(200, "data berhasil ditambahkan");
			response.setData(service.addMenu(entity));
			return new ResponseEntity<ResponseMJService>(response, HttpStatus.OK);
		} catch (Exception e) {			
			ResponseMJService response = new ResponseMJService(400, e.getMessage());
			response.setData(entity);
			return new ResponseEntity<ResponseMJService>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
	public ResponseEntity<ResponseMJService> updateMenu(@RequestBody MenuEntity entity) {
		
		try {
			boolean updateMenu = service.updateMenu(entity);
			String messageStatus = "data gagal diperbarui";
			if(updateMenu) {
				messageStatus = "data berhasil diperbarui";
			}
			ResponseMJService response = new ResponseMJService(200, messageStatus);
			response.setData(entity);			
			return new ResponseEntity<ResponseMJService>(response, HttpStatus.OK);
		} catch (Exception e) {
			ResponseMJService response = new ResponseMJService(400, e.getMessage());
			return new ResponseEntity<ResponseMJService>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
	public ResponseEntity<ResponseMJService> deleteMenu(@RequestBody MenuEntity entity) {
		
		try {
			boolean deleteMenu = service.deleteMenu(entity);
			String messageStatus = "data gagal dihapus";
			
			if(deleteMenu) {
				messageStatus = "data bershasil dihapus";
			}
			
			ResponseMJService response = new ResponseMJService(200, messageStatus);
			response.setData(entity);	
			return new ResponseEntity<ResponseMJService>(response, HttpStatus.OK);
		} catch (Exception e) {
			ResponseMJService response = new ResponseMJService(400, e.getMessage());
			return new ResponseEntity<ResponseMJService>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/addItemJual", method = RequestMethod.POST)
	public ResponseEntity<ResponseMJService> addItemJual(@RequestBody PenjualanEntity entity) {
		
		try {
			ResponseMJService response = new ResponseMJService(200, "data item penjualan berhasil ditambahkan");
			response.setData(servicePenjualan.addItemJual(entity)); 
			return new ResponseEntity<ResponseMJService>(response, HttpStatus.OK);
		} catch (Exception e) {			
			ResponseMJService response = new ResponseMJService(400, e.getMessage());
			response.setData(entity);
			return new ResponseEntity<ResponseMJService>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
}

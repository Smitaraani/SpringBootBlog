package com.SpringbootFacebookApplication.SpringbootFacebookApplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringbootFacebookApplication.SpringbootFacebookApplication.payload.CatagoryDto;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.payload.UserDto;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.service.CategoryService;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.service.UserService;


@RestController
public class Categorycontroller {

	
	@Autowired
	private CategoryService categoryservice;

	// craete user
	@PostMapping("/createcat")
	public ResponseEntity<CatagoryDto> craeteCategory(@RequestBody CatagoryDto catagoryDto) {
		CatagoryDto userdto2 = categoryservice.craetecategory(catagoryDto);
		try {
			if (userdto2 == null) {
				return new ResponseEntity<>(userdto2, HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new ResponseEntity<>(userdto2, HttpStatus.CREATED);
	}

	// getAllUser

	@GetMapping("/getallcat")
	public ResponseEntity<List<CatagoryDto>> getAll() {

		List<CatagoryDto> userdto = categoryservice.getAllCatagory();

		try {
			if (userdto == null) {
				return new ResponseEntity<>(userdto, HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new ResponseEntity<>(userdto, HttpStatus.OK);
	}

	@GetMapping("/getbycatid/{id}")
	public ResponseEntity<CatagoryDto> getbyid(@PathVariable int id) {

		CatagoryDto userDto = categoryservice.getById(id);

		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@PutMapping("/updatecat/{id}")
	public ResponseEntity<CatagoryDto> updateuser(@RequestBody CatagoryDto userDto, @PathVariable int id) {
		CatagoryDto userDto2 = categoryservice.updateCatagory(userDto, id);

		return new ResponseEntity<>(userDto2, HttpStatus.CREATED);
	}

	@DeleteMapping("/deletecat/{id}")

	public ResponseEntity<Map<String, Boolean>> deletedata(@PathVariable int id) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();

		categoryservice.delteCatagory(id);

		map.put("data is delte", Boolean.TRUE);

		return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
	}
}

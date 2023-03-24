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

import com.SpringbootFacebookApplication.SpringbootFacebookApplication.payload.UserDto;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;

	// craete user
	@PostMapping("/createuser")
	public ResponseEntity<UserDto> craeteuser(@RequestBody UserDto userdto) {
		UserDto userdto2 = userservice.craeteuser(userdto);
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

	@GetMapping("/getalluser")
	public ResponseEntity<List<UserDto>> getAll() {

		List<UserDto> userdto = userservice.getAllUser();

		try {
			if (userdto == null) {
				return new ResponseEntity<>(userdto, HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new ResponseEntity<>(userdto, HttpStatus.OK);
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<UserDto> getbyid(@PathVariable int id) {

		UserDto userDto = userservice.getById(id);

		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> updateuser(@RequestBody UserDto userDto, @PathVariable int id) {
		UserDto userDto2 = userservice.updateUser(userDto, id);

		return new ResponseEntity<>(userDto2, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")

	public ResponseEntity<Map<String, Boolean>> deletedata(@PathVariable int id) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();

		userservice.delteUser(id);

		map.put("data is delte", Boolean.TRUE);

		return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
	}
}

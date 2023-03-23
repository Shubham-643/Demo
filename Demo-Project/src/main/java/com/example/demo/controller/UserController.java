package com.example.demo.controller;

import java.util.List;

import javax.persistence.PostPersist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserAccDTO;
import com.example.demo.dto.UserAddDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
//This is user controller

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/test")
	String hello() {
		return "hello";
	}

	@PostMapping("/addUser")
	User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@PostMapping("/addUser1")
	UserAddDTO addNewUserWithAddress(@RequestBody UserAddDTO userAddDTO) {
		return userService.addUserWithAddress(userAddDTO);
	}

	@GetMapping("/getUser1")
	List<User> getUserWithAddress() {
		List<User> users = userService.getUserWithAddress();
		return users;
	}

	@GetMapping("/getUserByAddId/{addressId}")
	User getUsreByAddId(@PathVariable int addressId) {
		
		return userService.getUserByAddressId(addressId);
	}
	@GetMapping("/response")
	ResponseEntity<List<User>> getUser(){
		//List<User> users=userService.getUserWithAddress();
		return new ResponseEntity<List<User>>(userService.getUserWithAddress(),HttpStatus.OK);
		
	}
	
	@PostMapping("/addUserWitAcc")
	UserAccDTO addUserWithAcc(@RequestBody UserAccDTO userAccDTO) {
		
		return null;
	}
}

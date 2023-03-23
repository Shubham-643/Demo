package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserAccDTO;
import com.example.demo.dto.UserAddDTO;
import com.example.demo.model.User;

public interface UserService {

	User addUser(User user);
	UserAddDTO addUserWithAddress(UserAddDTO userAddDTO);

	List<User> getUserWithAddress();
	User getUserByAddressId(int adddressId);
	
	UserAddDTO addUserwithAcc(UserAccDTO userAccDTO);
	
}

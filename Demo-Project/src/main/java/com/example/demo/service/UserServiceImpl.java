package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserAccDTO;
import com.example.demo.dto.UserAddDTO;
import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public UserAddDTO addUserWithAddress(UserAddDTO userAddDTO) {

		User user = new User();
		user.setUserName(userAddDTO.getUserName());
		user.setPassword(userAddDTO.getPassword());

		Address address = new Address();
		address.setCity(userAddDTO.getCity());
		address.setState(userAddDTO.getState());
		address.setCountry(userAddDTO.getCountry());

		user.setAddress(address);

		userRepository.save(user);

		return userAddDTO;
	}

	@Override
	public User getUserByAddressId(int addressId) {

		return userRepository.findById(addressId).get();
	}

	@Override
	public List<User> getUserWithAddress() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public UserAddDTO addUserwithAcc(UserAccDTO userAccDTO) {
		User user = new User();
		user.setUserName(userAccDTO.getUserName());
		user.setPassword(userAccDTO.getPassword());
		user.setAddress(null);
		
		Address address = new Address();
		address.setCity(userAccDTO.getCity());
		address.setState(userAccDTO.getState());
		address.setCountry(userAccDTO.getCountry());
		
		return null;
	}

}

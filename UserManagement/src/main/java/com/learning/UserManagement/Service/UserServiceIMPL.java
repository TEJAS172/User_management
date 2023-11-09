package com.learning.UserManagement.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.UserManagement.Entity.User;
import com.learning.UserManagement.Payload.UserDto;
import com.learning.UserManagement.Repository.UserRepository;

@Service
public class UserServiceIMPL implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto addUser(User user) {
		User savedUser = this.userRepository.save(user);
		return this.modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto getUserById(int userId) {
		User user = this.userRepository.findById(userId).get();
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> list = this.userRepository.findAll();
		return list.stream()
				.map(user->this.modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(int userId, UserDto userDto) {
		User user = this.userRepository.findById(userId).get();
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setContactNumber(userDto.getContactNumber());
		this.userRepository.save(user);
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public void delete(int userId) {
		User user = this.userRepository.findById(userId)
				.get();
		this.userRepository.delete(user);

	}
}

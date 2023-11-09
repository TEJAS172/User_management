package com.learning.UserManagement.Service;

import java.util.List;

import com.learning.UserManagement.Entity.User;
import com.learning.UserManagement.Payload.UserDto;

public interface UserService {
	 UserDto addUser(User user);
	   UserDto getUserById(int userId);
	   List<UserDto> getAllUsers();
	   UserDto updateUser(int userId,UserDto userDto);
	   void delete(int userId);
}

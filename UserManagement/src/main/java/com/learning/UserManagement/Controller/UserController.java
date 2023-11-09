package com.learning.UserManagement.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.UserManagement.Entity.User;
import com.learning.UserManagement.Payload.UserDto;
import com.learning.UserManagement.Service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")//this is for connecting our frontend application to the backend
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody User user){
		UserDto savedUserDto = this.userService.addUser(user);
		return new ResponseEntity<>(savedUserDto,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
		UserDto userById = this.userService.getUserById(userId);
		return new ResponseEntity<>(userById,HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<UserDto>> getAll(){
		List<UserDto> allUsers = this.userService.getAllUsers();
		return new ResponseEntity<>(allUsers,HttpStatus.OK);
	}
	
	@PutMapping("/user/{userId}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Integer userId,@RequestBody UserDto userDto){
		UserDto updateUser = this.userService.updateUser(userId, userDto);
	    return new ResponseEntity<UserDto>(updateUser,HttpStatus.OK);
	
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer userId){
	      this.userService.delete(userId);	
		return new ResponseEntity<>("User deleted successfully",HttpStatus.OK);	
	}
	
	
	
}

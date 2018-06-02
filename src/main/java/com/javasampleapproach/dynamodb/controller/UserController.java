package com.javasampleapproach.dynamodb.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.dynamodb.model.User;
import com.javasampleapproach.dynamodb.repo.UserRepository;


@RestController
public class UserController {

	@Autowired
	UserRepository repository;
	
	
	@GetMapping("/users")
	public List<User> getAll() throws Exception{
		List<User> users = (List<User>) repository.findAll();
		return users;
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable String id) throws Exception  {
		if(repository.exists(id))
		{
			return repository.findOne(id);
		}
		else
		{
			throw new Exception("userId doesnt exists");
		}
	}
	
	@PostMapping("/user")
	public void createUser(@RequestBody User users) throws Exception {
		if(!repository.exists(users.getId()))
			{
					repository.save(users);
			}
			else {			
				throw new Exception("userId already exists");
			}
	
    }
	
	@PutMapping("/user/{id}")
	public void update(@RequestBody User user, @PathVariable String id) throws Exception {
		if(repository.exists((user.getId())))
		{
			System.out.println("updated user");
			repository.save(user);
		}
		else {
			System.out.println("Created new user as user with id: "+id+" doesnt exist ");
			repository.save(user);
		}
		
	}
	
	
	@DeleteMapping("user/{id}")
	public boolean deleteUser(@PathVariable String id) throws Exception {
		if(repository.exists(id))
		{
			repository.delete(id); 
			return true;
		}
		else
		{
			throw new Exception("userId doesnt exists");
		}
		
	}
	
	
}

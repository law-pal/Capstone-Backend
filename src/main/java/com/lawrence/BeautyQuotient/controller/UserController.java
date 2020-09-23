package com.lawrence.BeautyQuotient.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawrence.BeautyQuotient.model.User;
import com.lawrence.BeautyQuotient.repository.UserRepository;



@RestController
@RequestMapping("/beauty_api/v1")
public class UserController {

	 @Autowired
	    private UserRepository userRepository;
	 
	 //Get all users
	 
	    @GetMapping(value = "/users")
	    public List<User> getAllUsers(Model model) {
	        return this.userRepository.findAll();
	    }
	    
	    //get user by id
	    @GetMapping("/user/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable(value = "id")Long id)
	    	throws ResourceNotFoundException{
	    	User user = userRepository.findById(id)
	    			.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
	    	return ResponseEntity.ok().body(user);
	   }
	    
	    //create a user
	  	@PostMapping("user")
	  	public User creatUser(@RequestBody User user) {
	  		return this.userRepository.save(user);
	  	}
	    
	    //update user
	  	@PutMapping("user/{id}")
	  	public ResponseEntity<User> updateUser(@PathVariable(value = "id")Long id, @Valid @RequestBody User userDetails) throws ResourceNotFoundException{
	  		User user = userRepository.findById(id)
	  				.orElseThrow(() -> new ResourceNotFoundException("User not found :: " + id));
	  		user.setFirstName(userDetails.getFirstName());
	  		user.setLastName(userDetails.getLastName());
	  		user.setEmail(userDetails.getEmail());
	  		
	  		return ResponseEntity.ok(this.userRepository.save(user));
	  	}
	     
	  	
	  	//Delete user
	  	@DeleteMapping("/user/{id}")
	  	ResponseEntity<User>deleteUser(@PathVariable Long id){
	  		userRepository.deleteById(id);
	  		return ResponseEntity.ok().build();
	  	}
}	    










/**
 * 
 */
package com.abhi.MongoDB.MongoDB.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.MongoDB.MongoDB.Model.User;
import com.abhi.MongoDB.MongoDB.Service.UserService;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ABHISEK GARAI
 *
 */
@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@ApiIgnore
	@RequestMapping("/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}
	
	@GetMapping("/Users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("/User")
	public User addUser(@RequestBody User newUser) {
		return userService.addUser(newUser);
	}
	
	@GetMapping("/Users/{text}")
	public List<User> searchUser(@PathVariable String text){
		return userService.searchUser(text);
	}
}

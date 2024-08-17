/**
 * 
 */
package com.abhi.MongoDB.MongoDB.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.MongoDB.MongoDB.Model.User;
import com.abhi.MongoDB.MongoDB.Repo.SearchUserRepo;
import com.abhi.MongoDB.MongoDB.Repo.UserRepository;

/**
 * @author ABHISEK GARAI
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	SearchUserRepo sRepo;
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}

	public User addUser(User newUser) {
		return userRepo.save(newUser);
	}

	public List<User> searchUser(String text) {
		
		return sRepo.findByText(text);
	}

	
}

/**
 * 
 */
package com.abhi.MongoDB.MongoDB.Repo;

import java.util.List;

import com.abhi.MongoDB.MongoDB.Model.User;

/**
 * @author ABHISEK GARAI
 *
 */
public interface SearchUserRepo {
	
	List<User> findByText(String text);

}

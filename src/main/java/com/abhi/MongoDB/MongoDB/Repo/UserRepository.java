/**
 * 
 */
package com.abhi.MongoDB.MongoDB.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abhi.MongoDB.MongoDB.Model.User;

/**
 * @author ABHISEK GARAI
 *
 */
public interface UserRepository extends MongoRepository<User, String> {

}

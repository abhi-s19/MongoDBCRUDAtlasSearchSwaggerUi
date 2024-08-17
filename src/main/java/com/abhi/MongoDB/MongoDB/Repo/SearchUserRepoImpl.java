/**
 * 
 */
package com.abhi.MongoDB.MongoDB.Repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.abhi.MongoDB.MongoDB.Model.User;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author ABHISEK GARAI
 *
 */
@Component
public class SearchUserRepoImpl implements SearchUserRepo {
	
	@Autowired
	MongoClient mongoClient;

	@Autowired
	MongoConverter mongoConverter;
	
	@Override
	public List<User> findByText(String text) {
		
		final List<User> users = new ArrayList<>();
		
		
		MongoDatabase database = mongoClient.getDatabase("sample_mflix");
		MongoCollection<Document> collection = database.getCollection("users");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
		    new Document("text", 
		    new Document("query", text)
		                .append("path", Arrays.asList("name", "email")))), 
		    new Document("$sort", 
		    new Document("name", 1L)), 
		    new Document("$limit", 5L)));

		
		for(Document doc: result) {
			
			User user = mongoConverter.read(User.class, doc);
			users.add(user);
		}
		
		return users;
	}

}

package com.javasampleapproach.dynamodb.repo;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;


import com.javasampleapproach.dynamodb.model.User;

@EnableScan
public interface UserRepository extends DynamoDBCrudRepository<User, String> {

	List<User> findByLastName(String lastName);
}

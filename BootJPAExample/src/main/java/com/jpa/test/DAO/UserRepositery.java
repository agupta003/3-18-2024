package com.jpa.test.DAO;

import org.springframework.data.repository.CrudRepository;

import com.jpa.test.entities.User;


public interface UserRepositery extends CrudRepository<User, Integer>{

}

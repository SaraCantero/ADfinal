package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository <User, Serializable> {
	
	public User findByUsername(String username);
	
	public List<User> findByRole(String role);
	
	public com.example.demo.entity.User findById(int id);
}

package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.User;


public interface userService {

		
		public abstract List<User> listAllUser();
		public abstract User registrar(User user);
		public abstract int removeUser(int id);
		public abstract User updateUser(User user);
		
	}



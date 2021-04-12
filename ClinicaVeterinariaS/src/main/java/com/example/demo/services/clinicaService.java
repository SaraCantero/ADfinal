package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.User;


public interface clinicaService {

		
		public abstract List<User> listAllUser();
		public abstract User addUSer(User user);
		public abstract int removeUser(int id);
		public abstract User updateUser(User user);
		
	}



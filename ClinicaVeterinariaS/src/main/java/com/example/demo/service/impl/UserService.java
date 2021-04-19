package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;
import com.example.demo.services.userService;

@Service("userService")
public class UserService implements UserDetailsService, userService{
	
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.demo.entity.User usuario=userRepository.findByUsername(username);
		
		UserBuilder builder=null;
		
		
		if(usuario!=null)
		{
			builder=User.withUsername(username);
			builder.password(usuario.getPassword());
			builder.authorities(new SimpleGrantedAuthority(usuario.getRole()));
		}//más de un rol, cambiar. Recorrer la lista e ir añadiendo cada uno de lso permisos
		else
			throw new UsernameNotFoundException("Usuario no encontrado");
		return builder.build();
	}


	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public com.example.demo.entity.User registrar(com.example.demo.entity.User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		user.setRole("ROL_USER");
		return userRepository.save(user);
	}
	

	public List<com.example.demo.entity.User> listAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public int removeUser(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		return 0;
	}


	@Override
	public com.example.demo.entity.User addUser(com.example.demo.entity.User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}


	@Override
	public com.example.demo.entity.User updateUser(com.example.demo.entity.User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	

}

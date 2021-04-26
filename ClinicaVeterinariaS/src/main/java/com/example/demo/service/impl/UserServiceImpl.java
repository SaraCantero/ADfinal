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

import com.example.demo.entity.Mascota;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.userService;

@Service("userService")
public class UserServiceImpl implements UserDetailsService, userService{
	
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("mascotaRepository")
	private MascotaRepository mascotaRepository;

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
		
	@Override
	public com.example.demo.entity.User añadirCliente(com.example.demo.entity.User user) {
		user.setRole("ROLE_CLIENTE");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		return userRepository.save(user);
	}
	
	@Override
	public com.example.demo.entity.User añadirVeterinario(com.example.demo.entity.User user) {
		user.setRole("ROLE_VETERINARIO");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		return userRepository.save(user);
	}
	
	
	public List<com.example.demo.entity.User> listarClientes(){
		return userRepository.findByRole("ROLE_CLIENTE");
	}

	public List<com.example.demo.entity.User> listarVeterinarios(){
		return userRepository.findByRole("ROLE_VETERINARIO");
	}
	
	@Override
	public List<com.example.demo.entity.User> listarId(com.example.demo.entity.User user){
		return userRepository.findById(user.getId());
	}
	



	@Override
	public int borrarCliente(int id) {
		userRepository.deleteById(id);
		return 0;
	}
	

	@Override
	public int borrarVeterinario(int id) {
		userRepository.deleteById(id);
		return 0;
	}



	@Override
	public com.example.demo.entity.User modificarCliente(com.example.demo.entity.User user) {
		return userRepository.save(user);
	}



	@Override
	public com.example.demo.entity.User modificarVeterinario(com.example.demo.entity.User user) {
		return userRepository.save(user);
	}

	@Override
	public com.example.demo.entity.User registrar(com.example.demo.entity.User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEnabled(false);
		user.setRole("ROLE_CLIENTE");
		return userRepository.save(user);
	}

	@Override
	public List<Mascota> listAllMascotas(com.example.demo.entity.User user) {
		return mascotaRepository.findByUser(user);
	}

	
	

	

	


	
}

package com.webapp.edu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webapp.edu.models.Usuario;
import com.webapp.edu.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario =  repository.findByEmail(email)
		.orElseThrow(()-> new UsernameNotFoundException("El usuario con email " + email + " no existe.") );
		
		return new UserDetailsImpl(usuario);
	}
	
}

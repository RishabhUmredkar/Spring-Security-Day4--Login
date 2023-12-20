package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Implement.UserDetailsImplement;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repo.findByUname(username);
		if(user==null)
			throw new UsernameNotFoundException("User not found");
		
		return new UserDetailsImplement(user);	}
	
}

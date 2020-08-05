package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository myUserDetailsService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = myUserDetailsService.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("NOT Found"));
		return user.map(MyUserDetails::new).get();
	}

}

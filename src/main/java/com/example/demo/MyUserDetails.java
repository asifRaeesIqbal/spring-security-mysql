package com.example.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.User;

public class MyUserDetails implements UserDetails {
	
	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;

	public MyUserDetails(String username) {
		super();
		this.username = username;
	}

	public MyUserDetails() {
		super();
	}

	public MyUserDetails(User user) {
		// map all the details... can use something mapstruct
		// with auhtorities you can split the string using the delimeter "," fromt he string roles and sve
		// to a list
		this.username = user.getUsername();
		this.authorities = Arrays.stream(user.getRoles().split(","))
								.map(SimpleGrantedAuthority::new)
								.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return "pass";
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	

}

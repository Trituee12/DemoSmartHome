package baithi.tuentpd01983.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import baithi.tuentpd01983.entity.Role;
import baithi.tuentpd01983.entity.User;
import baithi.tuentpd01983.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRopository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRopository.findByUserName(username);

		Set<Role> roles =  user.getRoles();
		
		Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();

		for(Role role : roles) {
		grantList.add( new SimpleGrantedAuthority(role.getNameRole()));
		}

        boolean enabled = user.isActive();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPasswordEcryted(),enabled, accountNonExpired, //
                credentialsNonExpired, accountNonLocked, grantList);
	}}

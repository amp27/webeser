package org.deu.eser.security;

import java.util.Locale;

import org.deu.eser.model.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails result = userRepository.findByUsername(username.toLowerCase(Locale.ENGLISH));
		if (result == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return result;
	}

}

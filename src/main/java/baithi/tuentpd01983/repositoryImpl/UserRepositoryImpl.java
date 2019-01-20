package baithi.tuentpd01983.repositoryImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import baithi.tuentpd01983.ClassGenerate.RegisterUserArea;
import baithi.tuentpd01983.entity.Role;
import baithi.tuentpd01983.entity.User;
import baithi.tuentpd01983.repository.UserRepository;
import baithi.tuentpd01983.services.UserServices;
import baithi.tuentpd01983.services.roleServices;

@Service
public class UserRepositoryImpl implements UserServices {

	@Autowired
	UserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private roleServices roleServices;
	
	

	@Override
	public Iterable<User> findall() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public User save(User user) {
		user.setPasswordEcryted(passwordEncoder.encode(user.getPasswordEcryted()));
		user.setActive(true);
		HashSet<Role> roles = new HashSet<>();
		roles.add(roleServices.findByRoleName("USER"));
		user.setRoles(roles);
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public long Count() {
		// TODO Auto-generated method stub
		return repository.count();
	}

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return repository.findByUserName(userName);
	}
}

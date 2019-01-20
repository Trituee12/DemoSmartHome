package baithi.tuentpd01983.services;

import java.util.List;
import java.util.Optional;

import baithi.tuentpd01983.entity.User;

public interface UserServices {
	
	public Iterable<User> findall();
	
	public Optional<User> findById(Long id);
	
	public User save(User user);
	
	public long Count();
//	
//	public void RegisterUserArea(User u);

	public User findByUserName(String userName);
}

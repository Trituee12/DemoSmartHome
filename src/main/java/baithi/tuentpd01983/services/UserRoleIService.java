package baithi.tuentpd01983.services;

import java.util.Optional;

import baithi.tuentpd01983.entity.UserRole;

public interface UserRoleIService {
	
	public Iterable<UserRole> findall();
	
	public Optional<UserRole> findById(Long id);
	
	public UserRole save(UserRole user);
	
	public long Count();
	

}

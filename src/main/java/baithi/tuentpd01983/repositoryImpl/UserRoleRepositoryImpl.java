package baithi.tuentpd01983.repositoryImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baithi.tuentpd01983.entity.UserRole;
import baithi.tuentpd01983.repository.UserRoleRepository;
import baithi.tuentpd01983.services.UserRoleIService;

@Service
public class UserRoleRepositoryImpl implements UserRoleIService{

	@Autowired
	UserRoleRepository UserRoleRepo;
	
	@Override
	public Iterable<UserRole> findall() {
		// TODO Auto-generated method stub
		return UserRoleRepo.findAll();
	}

	@Override
	public Optional<UserRole> findById(Long id) {
		// TODO Auto-generated method stub
		return UserRoleRepo.findById(id);
	}

	@Override
	public UserRole save(UserRole user) {
		// TODO Auto-generated method stub
		return UserRoleRepo.save(user);
	}

	@Override
	public long Count() {
		// TODO Auto-generated method stub
		return UserRoleRepo.count();
	}

}

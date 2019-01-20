package baithi.tuentpd01983.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baithi.tuentpd01983.entity.Role;
import baithi.tuentpd01983.repository.RoleRepository;
import baithi.tuentpd01983.services.roleServices;

@Service
public class RoleReposirotyIpml implements roleServices {
	
	@Autowired
	RoleRepository rolerepo;

	@Override
	public Role findId() {
		// TODO Auto-generated method stub
		return rolerepo.findId();
	}
	
	@Override
	public Role findId2() {
		// TODO Auto-generated method stub
		return rolerepo.findId2();
	}

	@Override
	public Role findByRoleName(String name) {
		// TODO Auto-generated method stub
		return rolerepo.findByNameRole(name);
	}

	@Override
	public Role save(Role role) {
		// TODO Auto-generated method stub
		return rolerepo.save(role);
	}
	
	

}

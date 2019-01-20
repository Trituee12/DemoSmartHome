package baithi.tuentpd01983.services;

import baithi.tuentpd01983.entity.Role;


public interface roleServices {
	Role findId();
	Role findId2();
	Role findByRoleName(String name);
	Role save(Role role);
}


package baithi.tuentpd01983.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import baithi.tuentpd01983.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query(value = "select * from role r where r.id = 1 ", nativeQuery = true)
	Role findId();
//	@Query(name = "", nativeQuery = true)
//	Iterable<T> findAreaDevice();
	
	@Query(value = "select * from role r where r.id = 2 ", nativeQuery = true)
	Role findId2();
	
	Role findByNameRole(String nameRole);
}

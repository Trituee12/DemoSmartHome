package baithi.tuentpd01983.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import baithi.tuentpd01983.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value = "select * from user where user_name = ?1", nativeQuery = true)
	User findByUserName(String userName);
//	@Query(name = "", nativeQuery = true)
//	Iterable<T> findAreaDevice();
	

}

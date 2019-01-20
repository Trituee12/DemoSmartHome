package baithi.tuentpd01983.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import baithi.tuentpd01983.entity.Area;
import baithi.tuentpd01983.entity.AreaDevice;

@Repository
public interface AreaRepository extends  JpaRepository<Area, String>{

	@Query(value = "select * from area r where r.area_id = ?1", nativeQuery = true)
	Area findByaId(String areaId);
			
	@Query(value = "select * from area a inner join user b on a.user_id = b.user_id where b.user_id = ?1", nativeQuery = true)
	Iterable<Area> findAreaByIdUser(Long id);

	@Query(value = "select * from area a inner join user b on a.user_id = b.user_id where b.user_name = ?1 group by a.area_name", nativeQuery = true)
	Iterable<Area> findAreaByUser(String username);
	
	@Query(value = "select a.area_name from area a inner join user b on a.user_id = b.user_id where b.user_id = ?1 and a.area_name = ?2", nativeQuery = true)
	List<String> findNameById(Long id, String area);
	
	@Query(value = "select r.area_note from area r where r.area_name = ?1", nativeQuery = true)
	List<String> findByaAreaName(String areaId);
}

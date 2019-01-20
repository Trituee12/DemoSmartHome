package baithi.tuentpd01983.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import baithi.tuentpd01983.entity.Area;
import baithi.tuentpd01983.entity.Device;
import baithi.tuentpd01983.entity.DeviceStatus;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer>{
	
	@Query(value = "select * from area a inner join area_device b on a.area_id = b.area_id inner join device c on b.id = c.id where a.user_id = ?1", nativeQuery = true)
	Iterable<Device> findAreaByIdUser(Long id);
	
	@Query(value = "select a.* from device a inner join area_device b on a.id = b.id inner join area c on b.area_id = c.area_id inner join user d on c.user_id = d.user_id where d.user_name = ?1 and c.area_name = ?2", nativeQuery = true)
	Iterable<Device> findAreaByIdUserName(String username, String areaname);
	
	@Query(value = "select a.* from device a inner join area_device b on a.id = b.id inner join area c on b.area_id = c.area_id inner join user d on c.user_id = d.user_id where d.user_name = ?1 and c.area_name = ?2 group by b.id", nativeQuery = true)
	List<Device> findAreaByIdUserNamedevice(String username, String areaname);
	
}

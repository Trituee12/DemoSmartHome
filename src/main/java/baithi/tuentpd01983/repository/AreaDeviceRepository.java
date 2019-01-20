package baithi.tuentpd01983.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import baithi.tuentpd01983.entity.Area;
import baithi.tuentpd01983.entity.AreaDevice;
import baithi.tuentpd01983.entity.DeviceStatus;

@Repository
public interface AreaDeviceRepository  extends JpaRepository<AreaDevice, Long>{

	@Query(value = "select c.* from device_status a inner join device b on a.device_id = b.device_id inner join area_device c on b.id = c.id inner join area d on c.area_id = d.area_id where d.user_id = ?1 and d.area_name like ?2", nativeQuery = true)
	List<AreaDevice> findAreaDeviceByUser(Long id, String area);
	
	@Query(value = "select a.* from area_device a inner join area b on a.area_id = b.area_id where b.user_id = ?1", nativeQuery = true)
	List<AreaDevice> findallbyUserId(Long id);
	
	@Query(value = "select a.* from area_device a inner join area b on a.area_id = b.area_id inner join user c on b.user_id = c.user_id where c.user_name = ?1", nativeQuery = true)
	List<AreaDevice> findallbyUsername(String id);
	
	@Query(value = "select a.area_id from area a inner join user b on a.user_id = b.user_id where b.user_id = ?1 and a.area_name = ?2", nativeQuery = true)
	Long findNameByUsername(String id, String area);
	
	@Query(value = "select * from device_status a inner join device b on a.device_id = b.device_id inner join area_device c on b.id = c.id inner join area d on c.area_id = d.area_id inner join user e on d.user_id = e.user_id where e.user_name = ?1 and d.area_name like ?2 and b.device_id = ?3", nativeQuery = true)
	List<AreaDevice> findAreaDeviceNameByUser(String username, String area, Long deviceId);
}

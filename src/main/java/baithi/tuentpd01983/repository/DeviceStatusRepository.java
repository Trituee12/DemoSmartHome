package baithi.tuentpd01983.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import baithi.tuentpd01983.entity.Device;
import baithi.tuentpd01983.entity.DeviceStatus;

@Repository
public interface DeviceStatusRepository extends JpaRepository<DeviceStatus, Long> {
	
	@Query(value = "select a.* from device_status a inner join device b on a.device_id = b.device_id inner join area_device c on b.id = c.id inner join area d on c.area_id = d.area_id where d.user_id = ?1 and d.area_name like ?2", nativeQuery = true)
	List<DeviceStatus> findAreaDeviceByUser(Long id, String area);
	
	@Query(value = "SELECT * FROM device_status d inner join device a on d.device_id = a.device_id inner join area_device b on a.id = b.id inner join area c on b.area_id = c.area_id WHERE c.user_id = ?1", nativeQuery = true)
	Iterable<DeviceStatus> findallDeviceByUser(Long id);
	
}

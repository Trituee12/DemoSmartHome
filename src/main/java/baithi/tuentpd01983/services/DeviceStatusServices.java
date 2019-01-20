package baithi.tuentpd01983.services;

import java.util.List;
import java.util.Optional;

import baithi.tuentpd01983.entity.DeviceStatus;

public interface DeviceStatusServices {


	public Iterable<DeviceStatus> findall();
	
	public Optional<DeviceStatus> findById(Long id);
	
	public DeviceStatus save(DeviceStatus deviceStatus);
	
	public long Count();
	
	List<DeviceStatus> findAreaDeviceByUser(Long id, String area);
	public 	Iterable<DeviceStatus> findallDeviceByUser(Long id);

	
}

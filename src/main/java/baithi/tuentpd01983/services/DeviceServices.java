package baithi.tuentpd01983.services;

import java.util.List;
import java.util.Optional;

import baithi.tuentpd01983.entity.Area;
import baithi.tuentpd01983.entity.Device;

public interface DeviceServices {

	public Iterable<Device> findall();
	
	public Optional<Device> findById(int id);
	
	public Device save(Device device);
	
	public long Count();
	
	Iterable<Device> findAreaByIdUser(Long id);
	
	public 	Iterable<Device> findAreaByIdUserName(String username, String areaname);
	public 	List<Device> findAreaByIdUserNamedevice(String username, String areaname);
	
}

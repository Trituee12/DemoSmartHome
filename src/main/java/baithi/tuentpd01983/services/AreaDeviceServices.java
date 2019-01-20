package baithi.tuentpd01983.services;

import java.util.List;
import java.util.Optional;

import baithi.tuentpd01983.entity.Area;
import baithi.tuentpd01983.entity.AreaDevice;

public interface AreaDeviceServices {
	public Iterable<AreaDevice> findall();
	
	public Optional<AreaDevice> findById(Long id);
	
	public AreaDevice save(AreaDevice AreaDevice);
	
	public long Count();
	
	public List<AreaDevice> findAreaDeviceByUser(Long id, String area);
	
	public 	List<AreaDevice> findallbyUserId(Long id);
	
	public List<AreaDevice> findallbyUsername(String id);
	
	public Long findNameByUsername(String id, String area);
	
	public 	List<AreaDevice> findAreaDeviceNameByUser(String username, String area, Long devicename);
}

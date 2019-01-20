package baithi.tuentpd01983.services;

import java.util.List;
import java.util.Optional;

import baithi.tuentpd01983.entity.Area;

public interface AreaServices {

	public Iterable<Area> findall();
	
	public Optional<Area> findById(String id);
	
	public Area save(Area area);
	
	public long Count();
	
	public Area findByaId(String id);
	
	public Iterable<Area> findAreaByIdUser(Long id);
	
	public Iterable<Area> findAreaByUser(String username);
	
	public List<String> findNameById(Long id, String area);
	
	public 	List<String> findByaAreaName(String areaId);
}

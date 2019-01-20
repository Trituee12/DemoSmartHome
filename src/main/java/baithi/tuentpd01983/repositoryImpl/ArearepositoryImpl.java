package baithi.tuentpd01983.repositoryImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baithi.tuentpd01983.entity.Area;
import baithi.tuentpd01983.repository.AreaRepository;
import baithi.tuentpd01983.services.AreaServices;

@Service
public class ArearepositoryImpl implements AreaServices {
	
	@Autowired
	AreaRepository areaRepository;

	@Override
	public Iterable<Area> findall() {
		// TODO Auto-generated method stub
		return areaRepository.findAll();
	}

	@Override
	public Optional<Area> findById(String id) {
		// TODO Auto-generated method stub
		return areaRepository.findById(id);
	}

	@Override
	public Area save(Area area) {
		// TODO Auto-generated method stub
		return areaRepository.save(area);
	}

	@Override
	public long Count() {
		// TODO Auto-generated method stub
		return areaRepository.count();
	}


	@Override
	public Iterable<Area> findAreaByIdUser(Long id) {
		// TODO Auto-generated method stub
		return areaRepository.findAreaByIdUser(id);
	}

	@Override
	public Area findByaId(String id) {
		// TODO Auto-generated method stub
		return areaRepository.findByaId(id);
	}

	@Override
	public Iterable<Area> findAreaByUser(String username) {
		// TODO Auto-generated method stub
		return areaRepository.findAreaByUser(username);
	}

	@Override
	public List<String> findNameById(Long id, String area) {
		// TODO Auto-generated method stub
		return areaRepository.findNameById(id, area);
	}

	@Override
	public List<String> findByaAreaName(String areaId) {
		// TODO Auto-generated method stub
		return areaRepository.findByaAreaName(areaId);
	}

	


}

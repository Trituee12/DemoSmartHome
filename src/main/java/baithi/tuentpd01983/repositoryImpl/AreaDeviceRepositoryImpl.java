package baithi.tuentpd01983.repositoryImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baithi.tuentpd01983.entity.AreaDevice;
import baithi.tuentpd01983.repository.AreaDeviceRepository;
import baithi.tuentpd01983.services.AreaDeviceServices;

@Service
public class AreaDeviceRepositoryImpl implements AreaDeviceServices {
	
	@Autowired
	private AreaDeviceRepository areaDevice;

	@Override
	public Iterable<AreaDevice> findall() {
		// TODO Auto-generated method stub
		return areaDevice.findAll();
	}

	@Override
	public Optional<AreaDevice> findById(Long id) {
		// TODO Auto-generated method stub
		return areaDevice.findById(id);
	}

	@Override
	public AreaDevice save(AreaDevice AreaDevice) {
		// TODO Auto-generated method stub
		return areaDevice.save(AreaDevice);
	}

	@Override
	public long Count() {
		// TODO Auto-generated method stub
		return areaDevice.count();
	}

	@Override
	public List<AreaDevice> findAreaDeviceByUser(Long id, String area) {
		// TODO Auto-generated method stub
		return areaDevice.findAreaDeviceByUser(id, area);
	}

	@Override
	public List<AreaDevice> findallbyUserId(Long id) {
		// TODO Auto-generated method stub
		return areaDevice.findallbyUserId(id);
	}

	@Override
	public List<AreaDevice> findallbyUsername(String id) {
		// TODO Auto-generated method stub
		return areaDevice.findallbyUsername(id);
	}

	@Override
	public Long findNameByUsername(String id, String area) {
		// TODO Auto-generated method stub
		return areaDevice.findNameByUsername(id, area);
	}

	@Override
	public 	List<AreaDevice> findAreaDeviceNameByUser(String username, String area, Long devicename) {
		// TODO Auto-generated method stub
		return areaDevice.findAreaDeviceNameByUser(username, area, devicename);
	}


}

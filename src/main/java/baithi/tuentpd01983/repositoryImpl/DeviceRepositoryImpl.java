package baithi.tuentpd01983.repositoryImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baithi.tuentpd01983.entity.Device;
import baithi.tuentpd01983.repository.DeviceRepository;
import baithi.tuentpd01983.services.DeviceServices;

@Service
public class DeviceRepositoryImpl implements DeviceServices{

	@Autowired
	private DeviceRepository devicerepo;
	
	@Override
	public Iterable<Device> findall() {
		// TODO Auto-generated method stub
		return devicerepo.findAll();
	}

	@Override
	public Optional<Device> findById(int id) {
		// TODO Auto-generated method stub
		return devicerepo.findById(id);
	}

	@Override
	public Device save(Device device) {
		// TODO Auto-generated method stub
		return devicerepo.save(device);
	}

	@Override
	public long Count() {
		// TODO Auto-generated method stub
		return devicerepo.count();
	}

	@Override
	public Iterable<Device> findAreaByIdUser(Long id) {
		// TODO Auto-generated method stub
		return devicerepo.findAreaByIdUser(id);
	}

	@Override
	public Iterable<Device> findAreaByIdUserName(String username, String areaname) {
		// TODO Auto-generated method stub
		return devicerepo.findAreaByIdUserName(username, areaname);
	}

	@Override
	public List<Device> findAreaByIdUserNamedevice(String username, String areaname) {
		// TODO Auto-generated method stub
		return devicerepo.findAreaByIdUserNamedevice(username, areaname);
	}





}

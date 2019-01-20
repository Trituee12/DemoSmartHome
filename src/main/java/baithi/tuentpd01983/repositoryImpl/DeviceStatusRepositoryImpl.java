package baithi.tuentpd01983.repositoryImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baithi.tuentpd01983.entity.DeviceStatus;
import baithi.tuentpd01983.repository.DeviceStatusRepository;
import baithi.tuentpd01983.services.DeviceStatusServices;

@Service
public class DeviceStatusRepositoryImpl implements DeviceStatusServices{
	
	@Autowired
	DeviceStatusRepository devicestatusrepo;

	@Override
	public Iterable<DeviceStatus> findall() {
		// TODO Auto-generated method stub
		return devicestatusrepo.findAll();
	}

	@Override
	public Optional<DeviceStatus> findById(Long id) {
		// TODO Auto-generated method stub
		return devicestatusrepo.findById(id);
	}

	@Override
	public DeviceStatus save(DeviceStatus deviceStatus) {
		// TODO Auto-generated method stub
		return devicestatusrepo.save(deviceStatus);
	}

	@Override
	public long Count() {
		// TODO Auto-generated method stub
		return devicestatusrepo.count();
	}

	@Override
	public List<DeviceStatus> findAreaDeviceByUser(Long id, String area) {
		// TODO Auto-generated method stub
		return devicestatusrepo.findAreaDeviceByUser(id,area);
	}

	@Override
	public Iterable<DeviceStatus> findallDeviceByUser(Long id) {
		// TODO Auto-generated method stub
		return devicestatusrepo.findallDeviceByUser(id);
	}

}

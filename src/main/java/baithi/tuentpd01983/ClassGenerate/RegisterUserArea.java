package baithi.tuentpd01983.ClassGenerate;

import java.sql.Time;
import java.util.Calendar;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import baithi.tuentpd01983.entity.Area;
import baithi.tuentpd01983.entity.AreaDevice;
import baithi.tuentpd01983.entity.Device;
import baithi.tuentpd01983.entity.DeviceStatus;
import baithi.tuentpd01983.entity.User;
import baithi.tuentpd01983.services.AreaDeviceServices;
import baithi.tuentpd01983.services.AreaServices;
import baithi.tuentpd01983.services.DeviceServices;
import baithi.tuentpd01983.services.DeviceStatusServices;
import baithi.tuentpd01983.services.UserServices;


@Transactional
@Repository
public class RegisterUserArea {
	
	  @Autowired
	    private UserServices userRepository;

	  @Autowired
	    private AreaServices areaRepository;

	  @Autowired
	    private DeviceServices deviceRepository;
	  

	  @Autowired
	    private AreaDeviceServices areaDeviceServices;
	  
	  
	  @Autowired
	    private DeviceStatusServices devicestatusrepotory;
	  
	  public void AutoCreateAreaDevice(User user) {
		  
		  HashSet<Area> areas = new HashSet<Area>();
		  areas.add(new Area("Living Room","Rộng 30m2", user));
		  areas.add(new Area("Bed Room","Rộng 10m2", user));
		  areas.add(new Area("Kitchen Room","Rộng 10m2", user));
		  for(Area a : areas) {
			  areaRepository.save(a);
		  }
	        
		  for(Area area : areaRepository.findAreaByIdUser(user.getUserId())) {
			  areaDeviceServices.save(new AreaDevice(area));
		  }
		  
		  for(AreaDevice area : areaDeviceServices.findallbyUserId(user.getUserId())) {
		  deviceRepository.save(new Device("MODEN WIFI", area));
		  }
		  for(Device devi : deviceRepository.findAreaByIdUser(user.getUserId())) {
			  devicestatusrepotory.save(new DeviceStatus(true,true,true,1,2,true,devi));
			  }

	  }

	  
	  
}

package baithi.tuentpd01983.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import baithi.tuentpd01983.entity.AreaDevice;
import baithi.tuentpd01983.services.AreaDeviceServices;
import baithi.tuentpd01983.services.AreaServices;

@RestController
public class CalenderDeviceRestController {
	
	@Autowired
	AreaServices areaService;
	
	@Autowired
	AreaDeviceServices areaDeviceServices;
	
	@GetMapping(value = "/myarea/{areaname}/{devicename}"  )
	public List<AreaDevice> areaCanlender( ModelAndView model,@PathVariable String areaname, @PathVariable Long devicename, Principal principal,AreaDevice areaDevice   ) {	
		List<AreaDevice> list = new ArrayList<AreaDevice>();
		for(AreaDevice areas :	areaDeviceServices.findAreaDeviceNameByUser(principal.getName(), areaname, devicename))	{
			list.add(areas);
		}
		
		System.out.println(list.iterator().next().getAreas().getAreaId());
		return list;
	}
}

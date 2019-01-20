package baithi.tuentpd01983.UserController;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import baithi.tuentpd01983.entity.Area;
import baithi.tuentpd01983.entity.AreaDevice;
import baithi.tuentpd01983.entity.Device;
import baithi.tuentpd01983.entity.DeviceStatus;
import baithi.tuentpd01983.services.AreaDeviceServices;
import baithi.tuentpd01983.services.AreaServices;
import baithi.tuentpd01983.services.DeviceServices;
import baithi.tuentpd01983.services.DeviceStatusServices;
import baithi.tuentpd01983.services.HistoryStatusServices;
import baithi.tuentpd01983.services.UserServices;

@Controller
public class DashboardUserController {
	@Autowired
	private AreaServices areasrive;
	
	@Autowired
	private HistoryStatusServices historyStatusServices;
	
	
	@Autowired
	private DeviceServices deviceServices;
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private AreaDeviceServices areaDevicea;
	

	  @Autowired
	    private DeviceStatusServices devicestatusrepotory;
	
	
	@GetMapping(value = "/myarea/home" )
	public ModelAndView getMyAreaHome(ModelAndView model, Authentication authentication,Principal principal ) {

		System.out.println(areasrive.findAreaByUser(principal.getName()));
			model.addObject("listarea", areasrive.findAreaByUser(principal.getName()));
			model.setViewName("homeUser");
			return model;
	}
	
	
	@GetMapping(value = "/myarea/history-status" )
	public ModelAndView getHistoryStatus(ModelAndView model, Authentication authentication,Principal principal ) {
			model.addObject("listarea", areasrive.findAreaByUser(principal.getName()));
			model.addObject("listhistory", historyStatusServices.findHistoryByUser(principal.getName()));
			model.setViewName("historyStatus");
			return model;
	}
	
	@GetMapping(value = "/myarea/my-device/{areaname}" )
	public ModelAndView getMyDevice(@PathVariable String areaname ,ModelAndView model, Authentication authentication,Principal principal ) {
			model.addObject("listarea", areasrive.findAreaByUser(principal.getName()));
			model.addObject("listmydevice", deviceServices.findAreaByIdUserName(principal.getName(), areaname));
			model.addObject("areaname", areaname);
			model.addObject("areanote", areasrive.findByaAreaName(areaname).iterator().next().toString());
			model.setViewName("myDevice");
			return model;
	}
	
	@PostMapping("/myarea/add-device")
	public String deivceadd( @Valid Device device,Principal principal, @RequestParam("nameArea") String nameArea, @RequestParam("noteArea") String noteArea) {
		
		for(int i = 0; i < deviceServices.findAreaByIdUserNamedevice(principal.getName(), nameArea).size(); i++) {
			if(device.getDeviceId() == deviceServices.findAreaByIdUserNamedevice(principal.getName(), nameArea).get(i).getDeviceId()) {
				 deviceServices.save(new Device(device.getDeviceId(),device.getDeviceName(),new AreaDevice(new Area(nameArea,noteArea,userServices.findByUserName(principal.getName())))));
						 return "redirect:/myarea/my-device/"+nameArea;
			}
			else if(device.getDeviceId() == null) {		
				  devicestatusrepotory.save(new DeviceStatus(true,true,true,1,2,true,new Device(device.getDeviceName(),new AreaDevice(new Area(nameArea,noteArea,userServices.findByUserName(principal.getName()))))));
				 return "redirect:/myarea/my-device/"+nameArea;
			}
			else {		
				  devicestatusrepotory.save(new DeviceStatus(true,true,true,1,2,true,new Device(device.getDeviceName(),new AreaDevice(new Area(nameArea,noteArea,userServices.findByUserName(principal.getName()))))));
				 return "redirect:/myarea/my-device/"+nameArea;
			
			}
			 }
			return null;
		}
		
		
	}



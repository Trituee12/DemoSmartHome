package baithi.tuentpd01983.UserController;

import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import baithi.tuentpd01983.entity.AreaDevice;
import baithi.tuentpd01983.entity.DeviceStatus;
import baithi.tuentpd01983.entity.HistoryStatus;
import baithi.tuentpd01983.mainController.Class.ListDeviceStatus;
import baithi.tuentpd01983.services.AreaDeviceServices;
import baithi.tuentpd01983.services.AreaServices;
import baithi.tuentpd01983.services.DeviceServices;
import baithi.tuentpd01983.services.DeviceStatusServices;
import baithi.tuentpd01983.services.HistoryStatusServices;
import baithi.tuentpd01983.services.UserServices;

@Controller
public class AreaDeviceController {

	@Autowired
	private DeviceStatusServices devicesrive;
	
	@Autowired
	private AreaServices AreaServices;
	
	@Autowired
	private DeviceServices deviceServices;
	
	@Autowired
	private AreaDeviceServices areadeviceService;
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private HistoryStatusServices historyStatusServices;
	
	@GetMapping(value = "/myarea/areas/{id}/{area}" )
	public ModelAndView getMyAreas(@PathVariable Long id,@PathVariable String area,ModelAndView model, Authentication authentication,Principal principal ) throws ParseException {
			model.addObject("listarea", AreaServices.findAreaByUser(principal.getName()));
			model.addObject("listad", devicesrive.findAreaDeviceByUser(id,area));
			model.addObject("listad1", areadeviceService.findAreaDeviceByUser(id,area));
			model.addObject("nameRoom", AreaServices.findNameById(id, area).iterator().next().toString());
			List<Integer> number = new ArrayList<Integer>();
			for(int i = 0 ; i < 10; i++) {
			number.add(i);}
			model.addObject("number",number);
			model.setViewName("AreaDevice");
			return model;
			
	}
	
	@ModelAttribute("listStatus")
	public ListDeviceStatus listRole() {
		DeviceStatus u = new DeviceStatus();
		ListDeviceStatus list = new ListDeviceStatus();
		List<DeviceStatus> liststatus = new ArrayList<DeviceStatus>();
		for(int i = 0; i < liststatus.size(); i++) {
			liststatus.add(u);
		}
		list.setListStatus(liststatus);
		return list;
	}
	
	
	@PostMapping("/myarea/setdevice")
	private ModelAndView setDeviceStatus(@ModelAttribute("listStatus") ListDeviceStatus list,Principal principal) {
		ModelAndView model = new ModelAndView();
		for(DeviceStatus a : list.getListStatus()) {
			devicesrive.save(a);
		}
			for(DeviceStatus ds : devicesrive.findallDeviceByUser(userServices.findByUserName(principal.getName()).getUserId())) {
				if(ds.isUsed() == true) {
			historyStatusServices.save(new HistoryStatus(ds.getDevices().getDeviceName(), ds, "Hoạt động", ds.getDevices().getDeviceStatus().iterator().next().isUsed()));
				}
				else {
					historyStatusServices.save(new HistoryStatus(ds.getDevices().getDeviceName(), ds, "Không Hoạt động", ds.getDevices().getDeviceStatus().iterator().next().isUsed()));
					
				}
			}
			
			
		model.setViewName("redirect:/myarea/home");
		return model;
	}
	
	@PostMapping("/myarea/setdevice-area")
	private ModelAndView setDeviceArea(@Valid AreaDevice list) {
		ModelAndView model = new ModelAndView();
		areadeviceService.save(list);
		model.setViewName("redirect:/myarea/home");
		return model;
	}
	
}

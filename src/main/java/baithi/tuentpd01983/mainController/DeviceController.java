package baithi.tuentpd01983.mainController;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import baithi.tuentpd01983.entity.Device;
import baithi.tuentpd01983.services.DeviceServices;
import baithi.tuentpd01983.services.DeviceStatusServices;

@Controller
public class DeviceController {
	
//	private static final Log log = LogFactory.getLog(DeviceController.class);
	
	@Autowired
	DeviceServices deviceser;
	
	@Autowired
	DeviceStatusServices devicestatusser;
	

	@GetMapping("/homepage/deviceform")
	public ModelAndView deviceget(ModelAndView model) {
			model.addObject("listdevice", deviceser.findall());
			model.addObject("Device", new Device() );
			model.addObject("statusDevice", devicestatusser.findall());
			model.setViewName("device");
		return model;
	}
	
	@PostMapping("/homepage/adddevice")
	public ModelAndView deivceadd(ModelAndView model, @Valid Device device) {
		deviceser.save(device);
		model.setViewName("redirect:/homepage/deviceform");
		return model;
	}
}

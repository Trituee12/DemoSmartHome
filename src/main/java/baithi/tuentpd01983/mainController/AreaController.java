package baithi.tuentpd01983.mainController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import baithi.tuentpd01983.entity.Area;
import baithi.tuentpd01983.services.AreaServices;

@Controller
public class AreaController {
	
	@Autowired
	AreaServices areaService;

	@GetMapping("/homepage/areaform")
	public ModelAndView areaform(ModelAndView model) {
		model.addObject("Area",new Area());
		model.addObject("listArea", areaService.findall());
		model.setViewName("area");
		return model;
	}
	
	@PostMapping("/homepage/addarea")
	public ModelAndView areaAdd(ModelAndView model, @Valid Area area) {
		areaService.save(area);
		model.setViewName("redirect:/homepage/areaform");
		return model;
	}
}

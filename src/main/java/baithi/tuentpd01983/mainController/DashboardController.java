package baithi.tuentpd01983.mainController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import baithi.tuentpd01983.entity.DeviceStatus;
import baithi.tuentpd01983.entity.UserRole;
import baithi.tuentpd01983.mainController.Class.ListRoleUser;
import baithi.tuentpd01983.services.UserRoleIService;
import baithi.tuentpd01983.services.UserServices;

@Controller
public class DashboardController {
	@Autowired
	UserServices userService;
	
	@Autowired
	UserRoleIService userRoleIService;
	
	
	
	@GetMapping("/homepage/admin")
	public ModelAndView areaList() {
		ModelAndView model = new ModelAndView();
		model.addObject("countUser", userService.Count());
		model.addObject("listUser", userService.findall());
//		model.addObject("areaIduser", userService.findall().iterator().next().getAreas().iterator().next().getAreaId());	
	
		model.setViewName("home");
		
		return model;
	}
	
	
	@ModelAttribute("listrole")
	public ListRoleUser listRole() {
		UserRole u = new UserRole();
		ListRoleUser list = new ListRoleUser();
		List<UserRole> listrole = new ArrayList<UserRole>();
		for(int i = 0; i < listrole.size(); i++) {
			listrole.add(u);
		}
		list.setListroleuser(listrole);
		return list;
	}
	
	@PostMapping("/homepage/SetRole")
	private ModelAndView setRole(@ModelAttribute("listrole") ListRoleUser list) {
		ModelAndView model = new ModelAndView();
		for(UserRole u : list.getListroleuser()) {
			userRoleIService.save(u);
		}
		model.setViewName("redirect:/homepage/admin");
		return model;
	}
		
}

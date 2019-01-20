package baithi.tuentpd01983.mainController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import baithi.tuentpd01983.ClassGenerate.RegisterUserArea;
import baithi.tuentpd01983.entity.User;
import baithi.tuentpd01983.services.AreaServices;
import baithi.tuentpd01983.services.UserServices;

@Controller
public class RegisterController {
	
	
	@Autowired
	private UserServices userService;  
	
	@Autowired
	private RegisterUserArea registerUserArea;
	
	@Autowired
	private AreaServices areaser; 
	

	@GetMapping(value = "/register")
	public ModelAndView register(ModelAndView model) {
		model.addObject("User", new User());
	
		model.setViewName("register");
		return model;
	}
	
	@PostMapping(value = "/registerUser")
	public ModelAndView registerUser(ModelAndView model, @Valid User user) {
		System.out.println(user.getUserName());
		
		userService.save(user);
		
		registerUserArea.AutoCreateAreaDevice(user);
		model.setViewName("redirect:/login");
		return model;
	}
	
}

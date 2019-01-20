package baithi.tuentpd01983.mainController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@GetMapping(value = "/login")
	public ModelAndView login(String error, String logout, HttpServletRequest ck) {
		ModelAndView model = new ModelAndView();
		
		if (ck.getUserPrincipal() != null) {
			model.setViewName("redirect:/homepage/admin");
			return model;
		} else {
			if (error != null) {
				model.addObject("error", "Bạn nhập sai email hoặc mật khẩu");

			}
			if (logout != null) {
				model.addObject("logout", "Bạn đã đăng xuất thành công");

			}
			model.setViewName("loginPage");
			return model;
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null) {
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login";
	}
	
}
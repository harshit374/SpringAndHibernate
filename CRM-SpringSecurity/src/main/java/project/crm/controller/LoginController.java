package project.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "fancy-login";
	}
	
	@GetMapping("/access-denied")
	public String accessdenied() {
		return "access-denied";
	}
	
}

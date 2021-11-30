package de.tekup.vue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexCtrl {
	
	@GetMapping({"/","/index"})
	public String getIndex(Model model) {
		WelcomeMsg welcomeMsg = new WelcomeMsg("Hello GLSI-N", "Welcome to Spring class");
		
		model.addAttribute("msg", welcomeMsg);
		return "index";
	}

}

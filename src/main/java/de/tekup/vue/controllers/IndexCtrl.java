package de.tekup.vue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.vue.model.User;
import de.tekup.vue.model.UserDB;

@Controller
public class IndexCtrl {
	
	@GetMapping({"/","/index"})
	public String getIndex(Model model) {
		WelcomeMsg welcomeMsg = new WelcomeMsg("Hello GLSI-N", "Welcome to Spring class");
		
		model.addAttribute("msg", welcomeMsg);
		return "index";
	}
	
	@GetMapping("/show/users")
	public String getShowUsers(Model model) {
		model.addAttribute("listUsers", UserDB.getUsers());
		return "user/show-users";
	}
	
	@GetMapping("/delete/user/{id}")
	public String deleteUser(@PathVariable int id) {
		UserDB.remove(id);
		return "redirect:/show/users";
	}
	
	@GetMapping("/add/user")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "user/add-user";
	}
	
	@PostMapping("/add/user")
	public String postAddUser(@ModelAttribute("user") User user) {
		UserDB.add(user);
		return "redirect:/show/users";
	}
	
	@GetMapping("/update/user/{id}")
	public String updateUser(@PathVariable int id, Model model) {
		model.addAttribute("user", UserDB.get(id));
		return "user/add-user";
	}

}

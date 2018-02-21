package com.sapphire.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sapphire.mvc.data.entities.Project;

@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public String goHomeAgain(Model model, @ModelAttribute("project") Project project) {
		model.addAttribute("currentProject", project);
		return "home";
	}
	
	/*
	@RequestMapping("/")
	
	public String goHome(Model model) {
		Project project = new Project();
		project.setName("First project");
		
		project.setDescription("This is a simple project sponcerd by NASA");
		model.addAttribute("currentProject",project);
		return "welcome";
	}*/
}

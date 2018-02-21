package com.sapphire.mvc.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sapphire.mvc.data.entities.Resource;
import com.sapphire.mvc.controllers.data.services.ResourceService;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
public class ResourceController {

	@Autowired
	private ResourceService services;
	
	@RequestMapping("/add")
	public String add(Model model){
		return "resource_add";
	}
	
	@RequestMapping("/{resourceId}")
	@ResponseBody
	public Resource findResource(@PathVariable("resourceId") Long resourceId) {
		return services.find(resourceId);
		
	}
	
	@RequestMapping("/find")
	public String find(Model model) {
		model.addAttribute("resources", services.findAll());
		return "resources";
	}

	
	/*@ExceptionHandler(NullPointerException.class)
	public String handleError(HttpServletRequest request) {
		return "controller_error";
	}*/
	
	@RequestMapping("/review")
	public String review(@ModelAttribute Resource resource) {
		System.out.println("Invoking review()");
		return "resource_review";
	}
	
	@ModelAttribute("resource")
	public Resource getResource() {
		System.out.println("Adding a new resource to the model.");
		return new Resource();
	}

	@ModelAttribute("typeOptions")
	public List<String> getOptions(){
		return new LinkedList<>(Arrays.asList(new String[] {
				"Material","Other","Staff","Technical Equipment"
				}));
	}
	
	@ModelAttribute("radioOptions")
	public List<String> getRadios(){
		return new LinkedList<>(Arrays.asList(new String[] {
				"Hours","Piece","Tons"
				}));
	}
	
	@ModelAttribute("checkOptions")
	public List<String> getChecks(){
		return new LinkedList<>(Arrays.asList(new String[] {
				"Lead Time", "Special Rate", "Requires Approval"
				}));
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource, SessionStatus status){
		System.out.println(resource);
		status.setComplete();
		return "redirect:/resource/add";
	}
}

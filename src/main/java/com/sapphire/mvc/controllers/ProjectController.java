package com.sapphire.mvc.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sapphire.mvc.controllers.data.services.ProjectService;
import com.sapphire.mvc.controllers.data.validators.ProjectValidator;
import com.sapphire.mvc.data.entities.Project;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "find/{projectId}")
	public @ResponseBody Project findProjectObject(Model model, @PathVariable("projectId") Long projectId) {
		return this.projectService.find(projectId);
	}

	@RequestMapping(value = "/{projectId}")
	private String findProject(Model model, @PathVariable("projectId") Long projectId) {
		model.addAttribute("project", this.projectService.find(projectId));
		return "project";
	}

	@RequestMapping(value = "/find")
	public String find(Model model) {
		model.addAttribute("projects", this.projectService.findAll());
		return "projects";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProject(Model model) {
		List<String> options = new LinkedList<>(Arrays.asList(new String[] { "Single Year", "Multi Year", "Other" }));
		model.addAttribute("typeOptions", options);
		model.addAttribute("project", new Project());
		return "project_add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveProject(@Valid @ModelAttribute Project project, Errors errors, RedirectAttributes attributes) {
		project.setProjectId(55L);
		this.projectService.save(project);
		attributes.addFlashAttribute("project", project);
		System.out.println("invoking saveProject()\n" + project);
//		throw new NullPointerException();
		return "redirect:/";
	}

	/*@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProjectValidator());
	}*/

	/*
	 * @RequestMapping(value="/add", method=RequestMethod.POST, params=
	 * {"type=multi"}) public String saveMultiYearProject(){
	 * System.out.println("Invoking saveMultiYearProject()"); return "project_add";
	 * }
	 * 
	 * @RequestMapping(value="/add", method=RequestMethod.POST, params=
	 * {"type=multi","special"}) public String saveSpecialProject(){
	 * System.out.println("Invoking saveSpecialProject()"); return "project_add"; }
	 */
}

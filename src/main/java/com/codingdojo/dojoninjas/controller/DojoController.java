package com.codingdojo.dojoninjas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojoninjas.models.Dojo;
import com.codingdojo.dojoninjas.models.Ninja;
import com.codingdojo.dojoninjas.services.DojoService;
import com.codingdojo.dojoninjas.services.NinjaService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojoController (DojoService dojoService, NinjaService ninjaService) {
		this.dojoService=dojoService;
		this.ninjaService=ninjaService;
	}
	
	
	
	@RequestMapping("/dojo/new")
	public String showNew(@ModelAttribute("dojo") Dojo dojo) {
		
		return "newdojo.jsp";
		
	}
	@PostMapping("/dojos")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newdojo.jsp";
		}else {
			Dojo createdDojo=dojoService.createDojo(dojo);
			return "redirect:/dojos/"+createdDojo.getId();
		}
		
	}
	@GetMapping("dojos/{dojoId}")
	public String show(@PathVariable("dojoId") Long dojoId, Model model) {
		Dojo dojo=dojoService.findDojo(dojoId);
		
		model.addAttribute("dojo",dojo);
		
		return "show.jsp";
	}
}
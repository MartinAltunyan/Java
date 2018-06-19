package com.codingdojo.dojoninjas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojoninjas.models.Ninja;
import com.codingdojo.dojoninjas.services.DojoService;
import com.codingdojo.dojoninjas.services.NinjaService;

@Controller
public class NinjaController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	public NinjaController(DojoService dojoService,NinjaService ninjaService) {
		this.dojoService=dojoService;
		this.ninjaService=ninjaService;
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninjas") Ninja ninja, Model model) {
		model.addAttribute("allDojos",dojoService.findAllDojos());
		return "new.jsp";
	}
	
	@PostMapping("/ninjas")
	public String createNinja(@Valid @ModelAttribute("nijas") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/ninjas/new.jsp";
		}else {
			Ninja createdNinja=ninjaService. createNinja(ninja);
			return "redirect:/dojos/" + createdNinja.getDojo().getId();
			
	}
 }		
}	

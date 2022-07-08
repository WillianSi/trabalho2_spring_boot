package br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.Role;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.RoleRepository;

@Controller
public class RoleController {
	
	@Autowired
	private RoleRepository roleRepo;
	
	@GetMapping("/roles")
	public String roles(Model model) {
		List<Role> roles = roleRepo.findAll();
		
		model.addAttribute("roles", roles);
		
		return "cargo";
	}
	
	@GetMapping("/roles/form")
	public String roleForm(@ModelAttribute("role") 
						   Role role) {
		return "role_form";
	}
	
	@PostMapping("/roles/new")
	public String userNew(@Valid
						  @ModelAttribute("role") 
	   					   Role role,
	   					   BindingResult br) {
		if(br.hasErrors()) {
			return "role_form";
		}
		
		roleRepo.save(role);
		
		return "redirect:/roles";
	}
	
	@GetMapping("/roles/{id}")
	public String roleUpdate(@PathVariable("id") 
	                         Integer id, 
	                         Model model) {
		
		Optional<Role> roleOpt = roleRepo.findById(id);
		
		if (roleOpt.isEmpty())
			throw new IllegalArgumentException("Cargo inválido!");
		
		Role role = roleOpt.get();
		model.addAttribute("role", role);
		
		return "role_form";
	}
	
	@GetMapping("/roles/delete/{id}")
	public String roleDelete(@PathVariable("id") 
							 Integer id) {
		
		Optional<Role> roleOpt = roleRepo.findById(id);
		
		if (roleOpt.isEmpty())
			throw new IllegalArgumentException("Cargo inválido!");
		
		Role role = roleOpt.get();
		
		roleRepo.delete(role);
		
		return "redirect:/roles";
	}
}
package br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class Inicial {
	@GetMapping("/")
	public String users(Model model) {
		return "index";
	}
}

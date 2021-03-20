package com.idat.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.idat.modelo.Aula;
import com.idat.modelo.Escuela;
import com.idat.servicios.AulaService;
import com.idat.servicios.EscuelaService;


@Controller
@RequestMapping
public class AulaControl {


	@Autowired
	 AulaService service;
	
	@Autowired
	EscuelaService service2;
	
	@GetMapping("/aulas")
	public String listar(Model model) {
		List <Aula> aulas = service.listar() ;
		model.addAttribute("aulas", aulas);
		return "/aula";
	}
	
	@GetMapping("new_aul")
	public String nuevo( Model model) {
		model.addAttribute("aulas", new Aula());
		
		List<Escuela> escuelas = service2.listar();
		model.addAttribute("escuelas", escuelas);
		return "/formAulas";
	}
	@PostMapping("/save_aul")
	public String save(Model model, Aula aul) {
		service.save(aul);
		return "redirect:/aulas";
	}
	@GetMapping("/edit_aul/{id}")
	public String listar(@PathVariable String id,Model model) {
		Optional<Aula> aulas = service.listarId(id);
		model.addAttribute("aulas", aulas);
		
		List<Escuela> escuelas = service2.listar();
		model.addAttribute("escuelas", escuelas);
		return "/formAulas";
	}
	
	@GetMapping("/delete_aul/{id}")
	public String listar(@PathVariable String id) {
		service.delete(id);
		return "redirect:/aulas";
	}
}

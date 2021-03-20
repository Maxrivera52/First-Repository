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

import com.idat.modelo.Escuela;
import com.idat.servicios.EscuelaService;

@Controller
@RequestMapping
public class EscuelaControl {


	@Autowired
	EscuelaService service;

	
	@GetMapping("/escuelas")
	public String listar(Model model) {
		List<Escuela> escuelas = service.listar() ;
		model.addAttribute("escuelas", escuelas);
		return "/escuela";
	}
	
	@GetMapping("new_esc")
	public String nuevo( Model model) {
		model.addAttribute("escuelas", new Escuela());
		return "/formEscuela";
	}
	@PostMapping("/save_esc")
	public String save(Model model, Escuela ret) {
		service.save(ret);
		return "redirect:/escuelas";
	}
	@GetMapping("/edit_esc/{id}")
	public String listar(@PathVariable int id,Model model) {
		Optional<Escuela> escuelas = service.listarId(id);
		model.addAttribute("escuelas", escuelas);
		return "/formEscuela";
	}
	
	@GetMapping("/delete_esc/{id}")
	public String listar(@PathVariable int id) {
		service.delete(id);
		return "redirect:/escuelas";
	}
}

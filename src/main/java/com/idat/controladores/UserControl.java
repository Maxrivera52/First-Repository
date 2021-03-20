package com.idat.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.idat.modelo.Usuario;
import com.idat.servicios.UsuarioService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class UserControl {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	BCryptPasswordEncoder code =  new BCryptPasswordEncoder();
	
	@GetMapping("/vistaUsuario")
	private String listUsuario(Model model) {
		List<Usuario> usuarios = service.listar(); 
		model.addAttribute("usuarios", usuarios);
		return "/usuario";
	}
	
	@GetMapping("/newUsuario")
	private String newU(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "/formUsuario";
	}
	
	@PostMapping("/saveUsuario")
	private String save(Usuario u, Model model){
		Usuario us = new Usuario();
		us.setId(u.getId());
		us.setNombre(u.getNombre());
		us.setClave(code.encode(u.getClave()));
		service.save(us);
		return "redirect:/vistaUsuario";
	}
	
	@GetMapping("/editUsuario/{id}")
	private String edit(Model model, @PathVariable int id) {
		Optional<Usuario> usuario = service.listarId(id);
		model.addAttribute("usuario", usuario);
		return "/formUsuario";
	}
	
	@GetMapping("/deleteUsuario/{id}")
	private String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/vistaUsuario";
	}
}

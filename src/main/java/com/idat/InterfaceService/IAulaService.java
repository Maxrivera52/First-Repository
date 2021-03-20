package com.idat.InterfaceService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.idat.modelo.Aula;

@Service
public interface IAulaService {

	public List<Aula>listar();
	public Optional<Aula>listarId(String id);
	
	public int save(Aula a);
	public void delete(String id);
}

package com.idat.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.idat.modelo.Escuela;

public interface IEscuelaService {

	public List<Escuela>listar();
	public Optional<Escuela>listarId(int id);
	
	public int save(Escuela e);
	public void delete(int id);
}

package com.idat.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.InterfaceService.IEscuelaService;
import com.idat.Interfaces.IEscuela;
import com.idat.modelo.Escuela;

@Service
public class EscuelaService implements IEscuelaService {

	@Autowired
	IEscuela data;
	
	@Override
	public List<Escuela> listar() {
		// TODO Auto-generated method stub
		return (List<Escuela>)data.findAll();
	}

	@Override
	public Optional<Escuela> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Escuela e) {
		int res = 0;
		Escuela escuela =data.save(e);
		if (!escuela.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

}

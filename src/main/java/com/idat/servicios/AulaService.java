package com.idat.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.InterfaceService.IAulaService;
import com.idat.Interfaces.IAula;
import com.idat.modelo.Aula;

@Service
public class AulaService implements IAulaService {

	@Autowired
	IAula data;
	
	@Override
	public List<Aula> listar() {
		// TODO Auto-generated method stub
		return (List<Aula>) data.findAll();
	}

	@Override
	public Optional<Aula> listarId(String id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int save(Aula a) {
		int res = 0;
		Aula aula =data.save(a);
		if (!aula.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		data.deleteById(id);
	}
	

}

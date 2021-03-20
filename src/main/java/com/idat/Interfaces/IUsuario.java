package com.idat.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.modelo.Usuario;

@Repository
public interface IUsuario extends CrudRepository<Usuario, Integer> {
	Usuario findByNombre(String nombre);
}

package com.idat.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.modelo.Escuela;

@Repository
public interface IEscuela extends CrudRepository<Escuela, Integer> {

}

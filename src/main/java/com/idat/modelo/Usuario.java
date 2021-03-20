package com.idat.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuario")

@Data @AllArgsConstructor @NoArgsConstructor
public class Usuario {
	@Id
	private int id;
	@Column (name="nombre" , length = 20)
	private String nombre;
	@Column (name="clave" , length = 100)
	private String clave;
}
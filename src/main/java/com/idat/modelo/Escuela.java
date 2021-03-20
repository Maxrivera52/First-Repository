package com.idat.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "escuela")
@Data @AllArgsConstructor @NoArgsConstructor
public class Escuela {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_escu;
	@Column(name = "nombre",length = 40)
	private String nombre;
	@Column(name = "direccion",length = 50)
	private String direccion;
}

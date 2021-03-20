package com.idat.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "aula")
@Data @AllArgsConstructor @NoArgsConstructor
public class Aula {
	
	@Id
	private String id_aula;
	@Column(name = "asientos")
	private int asientos;
	@Column(name = "piso")
	private int piso;
	
	@ManyToOne
	@JoinColumn(name = "escuela")
	private Escuela escuela;
}

package com.idat;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.idat.Interfaces.IUsuario;
import com.idat.modelo.Usuario;

@SpringBootTest
class RiveraMoran001ApplicationTests {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private IUsuario repo;
	
	@Test
	void contextLoads() {
		Usuario us = new Usuario();
		
		us.setId(2);
		us.setNombre("idat");
		us.setClave(encoder.encode("123"));
		Usuario retorno = repo.save(us);
		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
	}

}

package com.webapp.edu;

import static org.mockito.Mockito.*;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import com.webapp.edu.controllers.EntidadController;
import com.webapp.edu.models.Entidad;
import com.webapp.edu.service.EntidadService;
import static com.webapp.edu.Datos.*;


@WebMvcTest(EntidadController.class)
class EntidadControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private EntidadService entidadService;
	
	@Test
	void testDetalle() throws Exception {
		when(entidadService.findByIdEntidad(1)).thenReturn(crearEntidad001().orElseThrow());
		
		//mvc
		//.perform(get("/login").with(user("admin@gmail.com").password("admin")));
		
		mvc.perform(get("/api/entidad/1").with(user("admin").password("admin")).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.razonSocial").value("SQL"))
			.andExpect(jsonPath("$.nroDocumento").value("1478"));
	
		verify(entidadService).findByIdEntidad(1);
		
	}
	
	@Test
	void listEntidad() throws Exception {
		
		List<Entidad> entidades = new ArrayList<>();
		entidades.add(crearEntidad001().orElseThrow());
		entidades.add(crearEntidad002().orElseThrow());
		
		
		when(entidadService.getAllEntidades()).thenReturn(entidades);
		
		mvc.perform(get("/api/entidad").with(user("admin").password("admin")).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].razonSocial").value("SQL"))
		.andExpect(jsonPath("$[0].nroDocumento").value("1478"))
		.andExpect(jsonPath("$[1].razonSocial").value("Mysql"))
		.andExpect(jsonPath("$[1].nroDocumento").value("548")); //fallo
		
		verify(entidadService).getAllEntidades();
	}
	
	
	
	
	
	
	
}

package com.webapp.edu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.webapp.edu.models.Entidad;
import com.webapp.edu.repository.EntidadRepository;
import com.webapp.edu.repository.TipoContribuyenteRepository;
import com.webapp.edu.repository.TipoDocumentoRepository;

@DataJpaTest
public class IntegracionJpaTest {

	@Autowired
	EntidadRepository repository;
	
	@Autowired
	TipoContribuyenteRepository tipoContribuyenteRepository;
	
	@Autowired
	TipoDocumentoRepository documentoRepository;

	
	@Test
	void testFindById() {
		Optional<Entidad> entidad = repository.findById(1);
		assertTrue(entidad.isPresent());
		assertEquals(entidad.orElseThrow().getNroDocumento(), "20505327552");
	}

	@Test
	void testSave() {
		Entidad newEntidad = Datos.crearEntidad001().orElseThrow();
		Entidad save = repository.save(newEntidad);
		
		Entidad entidad = repository.findById(save.getIdEntidad()).orElseThrow();
		assertEquals(10, entidad.getIdEntidad());
		assertEquals("Adidas", entidad.getNombreComercial());
		
	}
	
	@Test
	void testUpdate() {
		Entidad newEntidad = Datos.crearEntidad001().orElseThrow();
		Entidad entidadSave = repository.save(newEntidad);
		
		
		entidadSave.setNombreComercial("Actualizacion de direccion");
		entidadSave.setNroDocumento("4");
		
		Entidad entidadActualizada = repository.save(entidadSave);
		
		assertEquals("Actualizacion de direccion", entidadActualizada.getNombreComercial());
		assertEquals("4", entidadActualizada.getNroDocumento());
		
	}
	
	@Test
	void testDelete() {
		Entidad entidad = repository.findById(1).orElseThrow();
		repository.delete(entidad);
		assertThrows(NoSuchElementException.class, () -> {
			repository.findById(1).orElseThrow();
		});	
	}
}

package POO.Serializacion;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import POO.Serializacion.application.CrearEstudiantesRandom;
import POO.Serializacion.domain.AdministradorDeEstudiantes;
import POO.Serializacion.entities.Estudiante;

class TestAdministradorDeEstudiantes {
	private static Random  rnd = new Random();
	private static Estudiante estudianteEnEstudio;
	private static AdministradorDeEstudiantes administrador;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		administrador = AdministradorDeEstudiantes.getInstance();
		CrearEstudiantesRandom.CrearEstudiantes();
		
	}

	@BeforeEach
	void setUp() throws Exception {
		int index = rnd.nextInt(administrador.size());
		estudianteEnEstudio = administrador.get(index);
	}

	@Test
	void testFindByLegajo_exist() {
		System.out.println("buscando a " + estudianteEnEstudio);
		assertNotNull(administrador.findByLegajo(estudianteEnEstudio.getLegajo()));
	}

	@Test
	void testFindByLegajo_does_not_exist() {
		System.out.println("eliminando a " + estudianteEnEstudio);
		administrador.remove(estudianteEnEstudio);
		assertNull(administrador.findByLegajo(estudianteEnEstudio.getLegajo()));
	}
	
}

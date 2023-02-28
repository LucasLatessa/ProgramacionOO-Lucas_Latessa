package POO.Serializacion.application;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

import POO.Serializacion.domain.AdministradorDeEstudiantes;
import POO.Serializacion.entities.Carrera;
import POO.Serializacion.entities.Estudiante;
import POO.Serializacion.entities.PlanEstudio;

public class CrearEstudiantesRandom {
	private static Carrera[] carreras = new Carrera[10]; 
	private static PlanEstudio[] planes = new PlanEstudio[10];
	private static ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	private static Random  rnd = new Random();
	private static Estudiante estudianteEnEstudio;
	private static AdministradorDeEstudiantes administrador;

	public static void CrearEstudiantes() {
		for(int x = 0; x < carreras.length; x ++) 
			carreras[x] = new Carrera(x + 1, "Carrera " + (x + 1));
		for(int x = 0; x < planes.length; x ++) {
			Date fecha = crearARandomDate();
			planes[x] = new PlanEstudio((int) ((Math.random() * 10) + 1), carreras[x],fecha);
			// System.out.println(planes[x]);
		}
		
		String[] nombres = {"Juan","Pedro", "Jose","Esteban","Claudia","Maria", "Lucila", "Elias"};
		String[] apellidos = {"Ramirez","Perez", "Litchboj","Ortiz","Di Leo","Dominguez", "Kraus", "Frued"};
		
		for(int x = 0; x < 30; x ++) {
			int nombre = rnd.nextInt(nombres.length);
			int apellido = rnd.nextInt(apellidos.length);
			estudiantes.add(new Estudiante(rnd.nextInt(10000),apellidos[apellido],
					        nombres[nombre],planes[rnd.nextInt(planes.length)]));
			// System.out.println(estudiantes[x]);	
		}
		
		administrador = AdministradorDeEstudiantes.getInstance();
		
		administrador.clear();
		
		administrador.addAll(estudiantes);
		
	}
	
	/* follow the example provided from T.J. Crowder on stackOverflow */
	private static Date crearARandomDate() {
		long    ms;
		// Get a new random instance, seeded from the clock
		rnd = new Random();
		// Get an Epoch value roughly between 1940 and 2010
		// -946771200000L = January 1, 1940
		// Add up to 70 years to it (using modulus on the next long)
		ms = -946771200000L + (Math.abs(rnd.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
		// Construct a date
		return new Date(ms);
	}
}

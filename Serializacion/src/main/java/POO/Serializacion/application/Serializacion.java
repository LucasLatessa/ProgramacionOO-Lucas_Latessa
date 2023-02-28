package POO.Serializacion.application;

import POO.Serializacion.domain.AdministradorDeEstudiantes;
import POO.Serializacion.entities.Estudiante;
import POO.Serializacion.services.Serializador;

public class Serializacion {
    private static AdministradorDeEstudiantes administrador;
    private static Serializador serializador = new Serializador("datos.dat");

	public static void main(String[] args) {

		administrador = AdministradorDeEstudiantes.getInstance();
		CrearEstudiantesRandom.CrearEstudiantes();
		
		System.out.println(" - Fase 1 - Mostramos los primero 10 elementos ");
		int cantEstudiantes = administrador.size();
		int indice = 0;
		while(indice < cantEstudiantes && indice < 10)
			System.out.println(administrador.get(indice ++));
		
		
		System.out.println(" - Fase 2 - Guardar los datos ");
		if (administrador.size() >= 1) {
			serializador.writeOneObject(administrador.get(0));
			for(int x = 1; x < administrador.size(); x ++) {
				serializador.addOneObject(administrador.get(x));
			}
		}
		
		administrador.clear();

		System.out.println(" - Fase 3 - Mostramos que no hay datos ");
		cantEstudiantes = administrador.size();
		indice = 0;
		while(indice < cantEstudiantes && indice < 10)
			System.out.println(administrador.get(indice ++));

		System.out.println(" - Fase 4 - Recuperar datos ");
			
		Object[] recuperado = serializador.readObjects();
		for(int x = 0; x < recuperado.length; x ++) {
			administrador.add((Estudiante) recuperado[x]);
		}
		
		System.out.println(" - Fase 5 - Mostramos 10 elementos ");
		cantEstudiantes = administrador.size();
		indice = 0;
		while(indice < cantEstudiantes && indice < 10)
			System.out.println(administrador.get(indice ++));
		
		
	}
}

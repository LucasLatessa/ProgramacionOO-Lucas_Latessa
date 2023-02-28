package POO.Serializacion.domain;


import java.util.ArrayList;
import java.util.Collection;

import POO.Serializacion.entities.Estudiante;


public class AdministradorDeEstudiantes {
	ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	private static AdministradorDeEstudiantes instancia;
	public static AdministradorDeEstudiantes getInstance() {
		if (instancia == null) {
			instancia = new AdministradorDeEstudiantes();
		}
		return instancia;
	}
	
	
	private AdministradorDeEstudiantes() {
		super();
	}


	public Estudiante findByLegajo(Integer legajo) {
		for(Estudiante e : estudiantes) {
			if (e.getLegajo().equals(legajo)) {
				return e;
			}
		}
		return null;	
	}

	public boolean isEmpty() {
		return estudiantes.isEmpty();
	}

	public boolean add(Estudiante e) {
		return estudiantes.add(e);
	}

	public boolean remove(Object o) {
		return estudiantes.remove(o);
	}

	public boolean addAll(Collection<? extends Estudiante> c) {
		return estudiantes.addAll(c);
	}

	public void clear() {
		estudiantes.clear();
	}

	public Estudiante get(int index) {
		return estudiantes.get(index);
	}


	public int size() {
		return estudiantes.size();
	}


	public ArrayList<Estudiante> getAll() {
		return estudiantes;
	}

	

}

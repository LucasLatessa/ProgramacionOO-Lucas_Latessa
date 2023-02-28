import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Fecha {
	static LocalDate fecha;
	public Fecha(String s,FormatosdeFecha formato) {
		try {
			fecha=convertirAFecha(s,formato);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static LocalDate convertirAFecha(String string, FormatosdeFecha formato) throws Exception {
		try {
			fecha=LocalDate.parse(string,DateTimeFormatter.ofPattern(formato.getMascara()));
			return fecha;	
		} catch (DateTimeParseException ex) {
			Exception excepcion = new Exception("Fecha no válida");
			throw excepcion;
		}
	}
	public boolean fechaMayorAOtra(Fecha fecha2) {
		//true si la 1 es mayor a la 2
		return fecha.compareTo(fecha2.fecha)>0;
	}
	public boolean fechaMenorAOtra(Fecha fecha2) {
		//true si la 1 es mayor a la 2
		return fecha.compareTo(fecha2.fecha)<0;
	}

	public boolean fechaEntreDosFechas(Fecha fecha2,Fecha fecha3) {
		//true si fecha 2<1<3
		return (fecha.compareTo(fecha2.fecha)>0) && (fecha.compareTo(fecha3.fecha)<0);
	}
	}

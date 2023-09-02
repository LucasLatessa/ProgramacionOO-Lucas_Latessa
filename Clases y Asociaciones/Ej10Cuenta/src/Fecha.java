import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Fecha {
	private LocalDate fecha;
	public Fecha(String s) throws Exception {
			this.convertirAFecha(s);
			if (fecha==null) {
				throw new Exception("Fecha invalida, fecha:"+s);
			}
	}
	
	private void convertirAFecha(String string) throws Exception {
			fecha=LocalDate.parse(string,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
	}
	public String convertirAString()  {
		return fecha.toString();
		
	}
	public Fecha sumarDias(int dias) throws Exception {
		String ss= this.fecha.plusDays(dias).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		Fecha fecha1=new Fecha(ss);
		return fecha1;
	}
	/**
	 * Determina si esta fecha es mayor a otra
	 * @param fecha2 La otra fecha a comparar
	 * @return true si esta instancia es mayor a la proporcionada por paramátro. falso en otro caso
	 */
	public boolean fechaMayorIgualAOtra(Fecha fecha2) {
		return fecha.compareTo(fecha2.fecha)>=0;
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

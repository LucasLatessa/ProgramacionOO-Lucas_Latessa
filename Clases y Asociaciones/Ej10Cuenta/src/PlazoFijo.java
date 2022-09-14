import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
/**
 * Representa un a pf
 * @author lucas
 *
 */
public class PlazoFijo {
	private int saldo;
	private Fecha fechaInicio;
	private int dias;
	private int interes=40;
	private CuentaNormal cuentaNorm;
	public PlazoFijo(int monto,int dias,String inicio) {
		saldo=monto;
		this.dias=dias;
		fechaInicio=new Fecha(inicio);
		
	}

	public boolean estaVencido() {
		Fecha fechahoy=new Fecha(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		Fecha fechaFinal= fechaInicio.sumarDias(dias);
		return fechahoy.fechaMayorAOtra(fechaFinal);
	}
	/*
	public int devolverIntereses()throws Exception {//exepcion
		if (this.estaVencido()) {
				return saldo*interes/100;
		}else {
			try { //exepcion cuando el plazo no esta vencido
			} catch (DateTimeParseException ex) {
				Exception excepcion = new Exception("El plazo fijo no esta vencido");
				throw excepcion;
		}
	}}
	*/
	public int devolverIntereses()throws Exception {// falta exepcion
		if (this.estaVencido()) {
				return saldo+(saldo*interes/100);
		}else {
			return 0;}}
	public int getMontoInvertido() {
		return saldo;
	}
}

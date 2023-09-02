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
	public PlazoFijo(int monto,int dias,String inicio) throws Exception {
		saldo=monto;
		this.dias=dias;
		fechaInicio=new Fecha(inicio);
		
	}

	public boolean estaVencido() throws Exception {
		Fecha fechahoy=new Fecha(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		Fecha fechaFinal= fechaInicio.sumarDias(dias);
		return fechahoy.fechaMayorIgualAOtra(fechaFinal);
	}
	
	public int devolverIntereses()throws Exception {
		if (!(this.estaVencido())) {
			throw new Exception("El plazo fijo no esta vencido. Vence el: "+(fechaInicio.sumarDias(dias)).convertirAString());
			}
		return saldo+(saldo*interes/100);
		}
	public int getMontoInvertido() {
		return saldo;
	}
}

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class ProgramaPrinc {

	public static void main(String[] args) throws Exception {
		Cliente cliente1=new Cliente(12,1000);
		cliente1.ingresarDinero(1000,Cuentas.CUENTA_NORMAL);
		System.out.println(cliente1.consultarCuentaNormal());
		cliente1.invertir(900, 10, "01-09-2022");
		System.out.println("Invierto 900 el 01-09-2022");
		System.out.println(cliente1.consultarCuentaNormal());
		cliente1.acreditarInversion();
		System.out.println("Saco inversion a dia de hoy");
		System.out.println(cliente1.consultarCuentaNormal());
	}

}

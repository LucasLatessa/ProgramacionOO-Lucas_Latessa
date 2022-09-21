import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class ProgramaPrinc {

	public static void main(String[] args) throws Exception {
		Cliente cliente1=new Cliente(12,1000);
		cliente1.ingresarDinero(1000,Cuentas.CUENTA_NORMAL);
		System.out.println("El saldo de la cuenta normal es: "+cliente1.saldoCuentaNormal());
		System.out.println("El limite de giro de la cuenta normal es: "+cliente1.giroCuentaNormal());
		cliente1.invertir(900, 10, "01-09-2022");
		System.out.println("Invierto 900 el 01-09-2022");
		cliente1.crearCCredito(200);
		System.out.println("El monto disponible para compras a credito es:"+cliente1.montoCuentaCredito());
		System.out.println("El saldo deudor es:"+cliente1.deudorCuentaCredito());
		System.out.println("El saldo de la cuenta normal es: "+cliente1.saldoCuentaNormal());
		System.out.println("El limite de giro de la cuenta normal es: "+cliente1.giroCuentaNormal());
		cliente1.acreditarInversion();
		System.out.println("Saco inversion a dia de hoy");
		System.out.println("El saldo de la cuenta normal es: "+cliente1.saldoCuentaNormal());
	}

}

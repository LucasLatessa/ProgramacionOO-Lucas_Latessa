import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class ProgramaPrinc {

	public static void main(String[] args) {
		
			System.out.println("#Creo cliente con 1000 de giro");
			Cliente cliente1=new Cliente(12,1000);
			System.out.println("El limite de giro es: "+cliente1.giroCuentaNormal());
			System.out.println("#Ingreso 2000 en cuenta normal");
			cliente1.ingresarDinero(2000,Cuentas.CUENTA_NORMAL);
			System.out.println("El saldo de la cuenta normal es: "+cliente1.saldoCuentaNormal());
			/* OPERACION DE PRUEBA COMPRA CTANormal
			 System.out.println("#Compro con cuenta normal 2500");
			try {
				cliente1.pagar(2500,Cuentas.CUENTA_NORMAL);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			System.out.println("El saldo de la cuenta normal es: "+cliente1.saldoCuentaNormal());
			System.out.println("El limite de giro es: "+cliente1.giroCuentaNormal());
			*/
			/* OPERACION DE PRUEBA COMPRA CTACredito
			 System.out.println("#Creo cuenta credito con 200");
			cliente1.crearCCredito(200);
			System.out.println("El monto disponible para compras a credito es:"+cliente1.montoCuentaCredito());
			System.out.println("El saldo deudor es:"+cliente1.deudorCuentaCredito());
			 */
			
			/*OPERACION DE PRUEBA CREO Y RETIRO PLAZO FIJO
			try{
				
				cliente1.invertir(200, 10, "11-09-2022");
				System.out.println("#Invierto $200 el 11-09-2022");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("El saldo de la cuenta normal es: "+cliente1.saldoCuentaNormal());
			System.out.println("El limite de giro de la cuenta normal es: "+cliente1.giroCuentaNormal());
			
			try{
				cliente1.acreditarInversion();
				System.out.println("#Saco inversion a dia de hoy");
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("El saldo de la cuenta normal es: "+cliente1.saldoCuentaNormal());
			*/
			
			
		
	}

}

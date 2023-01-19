import java.rmi.RemoteException;

import ar.edu.unlu.rmimvc.RMIMVCException;
import ar.edu.unlu.rmimvc.cliente.Cliente;
import controlador.Controlador;
import vista.IVista;
import vista.VistaConsola;
import vista.grafica.VistaGrafica;

public class AppCliente {

	public static void main(String[] args) {
		Integer puerto = Integer.valueOf(args[0]);
		System.out.println(puerto);
		//IVista vista = new VistaGrafica();
		IVista vista = new VistaConsola(puerto);
		Controlador controlador = new Controlador(vista);
		vista.setControlador(controlador);
		Cliente cliente = new Cliente("127.0.0.1", puerto, "127.0.0.1", 64000);
		try {
			cliente.iniciar(controlador);
			vista.iniciar(puerto);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RMIMVCException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

import java.rmi.RemoteException;

import ar.edu.unlu.rmimvc.RMIMVCException;
import ar.edu.unlu.rmimvc.cliente.Cliente;
import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import controlador.Controlador;
import vista.IVista;
import vista.VistaConsola;
import vista.VistaSimilConsola;
import vista.grafica.VistaGrafica;

public class IntermedioAppCliente {

	public static void main(String[] args) {
		Integer puerto = Integer.valueOf(args[0]);
		//IVista vista = new VistaSimilConsola();
		IVista vista = new VistaGrafica();
		IControladorRemoto controlador = new Controlador(vista);
		Cliente cliente = new Cliente("127.0.0.1", puerto, "127.0.0.1", 64000);
		try {
			cliente.iniciar(controlador);
			vista.iniciar();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RMIMVCException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

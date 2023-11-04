import java.rmi.RemoteException;

import ar.edu.unlu.rmimvc.RMIMVCException;
import ar.edu.unlu.rmimvc.cliente.Cliente;
import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import controlador.Controlador;
import vista.IVista;
//import vista.VistaSimilConsola;
import vista.grafica.VistaGrafica;
import ar.edu.unlu.rmimvc.servidor.Servidor;
import modelo.IJuego;
import modelo.Juego;
public class IntermedioAppServYCliente {

	public static void main(String[] args) {
		IJuego modelo = new Juego();
		Servidor servidor = new Servidor("127.0.0.1", 64000);
		System.out.println("Iniciando servidor...");
		try {
			servidor.iniciar(modelo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RMIMVCException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

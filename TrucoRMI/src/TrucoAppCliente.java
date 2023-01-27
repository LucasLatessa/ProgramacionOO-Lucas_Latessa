import java.rmi.RemoteException;

import ar.edu.unlu.rmimvc.RMIMVCException;
import ar.edu.unlu.rmimvc.cliente.Cliente;
import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import controlador.Controlador;
import vista.IVista;
import vista.VistaConsola;
import vista.grafica.VistaGrafica;

public class TrucoAppCliente {

	public static void main(String[] args) {
		Integer puerto = Integer.valueOf(args[0]);
		//System.out.println(puerto); PARA MOSTRAR EL PUERTO EN CONSOLA
		
		//IVista vista = new VistaGrafica();
		IVista vista = new VistaGrafica(Integer.toString(puerto));//PARA PRUEBAS USO PUERTO PARA EL NOMBRE DEL JUGADOR
		//IVista vista = new VistaConsola();
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

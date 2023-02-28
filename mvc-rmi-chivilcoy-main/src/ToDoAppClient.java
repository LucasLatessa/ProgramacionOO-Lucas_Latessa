import java.rmi.RemoteException;

import ar.edu.unlu.poo.todoapp.controlador.Controlador;
import ar.edu.unlu.poo.todoapp.vista.VistaConsola;
import ar.edu.unlu.rmimvc.RMIMVCException;
import ar.edu.unlu.rmimvc.cliente.Cliente;
import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;

public class ToDoAppClient {

	public static void main(String[] args) {
		Integer puerto = Integer.valueOf(args[0]);
		System.out.println(puerto);
		VistaConsola vista = new VistaConsola();
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

import java.rmi.RemoteException;

import ar.edu.unlu.poo.todoapp.modelo.IListadoDeTareas;
import ar.edu.unlu.poo.todoapp.modelo.ListadoDeTareas;
import ar.edu.unlu.rmimvc.RMIMVCException;
import ar.edu.unlu.rmimvc.servidor.Servidor;

public class ToDoAppServer {

	public static void main(String[] args) {
		IListadoDeTareas modelo = new ListadoDeTareas();
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

	}

}

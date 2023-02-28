import java.rmi.RemoteException;

import ar.edu.unlu.rmimvc.RMIMVCException;
import ar.edu.unlu.rmimvc.servidor.Servidor;
import modelo.IJuego;
import modelo.Juego;
public class IntermedioAppServidor {

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

	}

}

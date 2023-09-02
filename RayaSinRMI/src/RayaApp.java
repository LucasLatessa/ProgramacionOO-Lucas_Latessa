import controlador.Controlador;
import modelo.Juego;
import vista.VistaConsola;

public class RayaApp {

	public static void main(String[] args) {
		Juego modelo = new Juego();
		VistaConsola vista = new VistaConsola();
		new Controlador(modelo, vista);
		vista.iniciar(); 
	}

}

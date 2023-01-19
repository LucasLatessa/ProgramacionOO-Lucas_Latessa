import controlador.Controlador;
import modelo.Juego;
import vista.VistaConsola;

public class TrucoApp {

	public static void main(String[] args) {
		Juego modelo = new Juego();
		VistaConsola vista = new VistaConsola();
		Controlador controlador = new Controlador(modelo, vista);
		vista.iniciar(); 
	}

}

import Controlador.Controlador;
import Modelo.Juego;
import Vista.VistaConsola;

public class APP {

	public static void main(String[] args) {
		Juego modelo = new Juego();
		VistaConsola vista = new VistaConsola();
		Controlador controlador = new Controlador(modelo, vista);
		vista.iniciar();

	}

}

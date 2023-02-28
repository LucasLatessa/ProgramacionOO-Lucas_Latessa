
public class Auto {
	int combustible;
	int velocidad;
	boolean encendido; 
	public void Aumento_Velocidad(int n) {
		velocidad=velocidad+n;
	}
	public int obtenerVelocidadActual() {
		return velocidad;
	}
}

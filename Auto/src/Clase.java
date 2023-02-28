
public class Clase {

	public static void main(String[] args) {
		Auto auto1 = new Auto();
		Auto auto2 = new Auto();
		auto1.Aumento_Velocidad(10);
		auto2.Aumento_Velocidad(20);
		System.out.println(auto1.obtenerVelocidadActual());
		System.out.println(auto2.obtenerVelocidadActual());
	}
}



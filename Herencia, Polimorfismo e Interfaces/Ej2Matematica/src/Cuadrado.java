
public class Cuadrado extends Rectangulo {

	public Cuadrado(int lado) {
		super(lado, lado);
	}
	public void draw() {
		System.out.println("Dibuja cuadrado");
	}
	
	public double getArea() {
		return (double) largo * ancho;
	}

}
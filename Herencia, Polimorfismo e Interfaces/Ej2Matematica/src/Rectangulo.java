public class Rectangulo  implements IFiguraGeometrica{
	
	int largo, ancho;
	
	public Rectangulo(int largo, int ancho) {
		this.largo = largo;
		this.ancho = ancho;
	}
	public void draw() {
		System.out.println("Dibuja rectangulo");
	}
	
	public double getArea() {
		return (double) largo * ancho;
	}

}


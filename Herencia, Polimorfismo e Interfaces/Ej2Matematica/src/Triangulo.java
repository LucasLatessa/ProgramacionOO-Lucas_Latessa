
public class Triangulo implements IFiguraGeometrica{
		private double altura;
		private double base;
	public Triangulo(double base,double altura) {
		this.base=base;
		this.altura=altura;
	}
	public void draw() {
		System.out.println("Dibuja triángulo");
	}
	public double getArea() {
		return (altura*base)/2;
	}

}

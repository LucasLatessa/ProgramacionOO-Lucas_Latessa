
public class Circulo implements IFiguraGeometrica{
		private double radio;
	public Circulo(double radio) {
		this.radio=radio;
	}
	public void draw() {
		System.out.println("Dibuja circulo");
	}
	public double getArea() {
		return Math.PI * (Math.pow(radio,2));
	}

}

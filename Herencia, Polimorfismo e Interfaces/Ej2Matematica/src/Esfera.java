
public class Esfera implements IFigura3D{
		private double radio;
	public Esfera(double radio) {
		this.radio=radio;
	}
	public void draw() {
		System.out.println("Dibuja esfera");
		
	}
	public double getArea() {
		return 4 *Math.PI *(Math.pow( radio, 2));
	}
	public double getVolumen() {
		return Float.valueOf(4)/3 * (Math.PI)* (Math.pow( radio, 3)) ;
	}

}


public class Cubo implements IFigura3D{
		private double arista;
		
	public Cubo(double arista) {
		this.arista=arista;
	}
	public void draw() {
		System.out.println("Se dibujó el cubo");
	}
	public double getArea() {
		return 6 * (Math.pow(arista,2));
	}
	public double getVolumen() {
		return (Math.pow(arista,3));
	}

}

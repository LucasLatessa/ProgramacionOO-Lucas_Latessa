
public class Paralelepipedo implements IFigura3D{
	private double arista1;
	private double arista2;
	private double arista3;
	public Paralelepipedo(double arista1,double arista2,double arista3) {
		this. arista1= arista1;
		this. arista2= arista2;
		this. arista3= arista3;
	}
	public void draw() {
		System.out.println("Se dibujó el paralelepipedo");
	}
	public double getArea() {
		return 2 * (arista1 * arista2 + arista1 * arista3 + arista2 * arista3);
	}
	public double getVolumen() {
		return arista1 * arista2 * arista3;
	}

}

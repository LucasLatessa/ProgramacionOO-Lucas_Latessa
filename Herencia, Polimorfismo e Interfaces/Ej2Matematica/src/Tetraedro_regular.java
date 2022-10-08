
public class Tetraedro_regular implements IFigura3D{
		private double arista;
		
	public Tetraedro_regular(double arista) {
		this.arista=arista;
	}
	public void draw() {
		System.out.println("Se dibujó el tetraedro");
	}
	public double getArea() {
		return Math.pow(arista,2) * Math.sqrt(3);
	}
	public double getVolumen() {
		return Math.pow(arista,3) * (Math.sqrt(3)/12);
	}

}

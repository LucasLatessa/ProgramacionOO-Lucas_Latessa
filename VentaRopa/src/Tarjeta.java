
public class Tarjeta {
	private boolean dorada;
	public Tarjeta(boolean dorada) {
		this.dorada=dorada;
	}
	public boolean isdorada() {
		return this.dorada;
	}
	public double calcularDescuento(double total) {
		double descuento;
		if (this.isdorada()) {
			descuento=0.015*total+100;
		}else {
			descuento=0.010*total;
		}
		return descuento;
	}

}

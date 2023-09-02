import java.util.List;

public class Venta {
	private List<Prenda> prendas;
	private Tarjeta tarjeta;
	public Venta(List<Prenda> prendas) {
		this.prendas=prendas;
		this.totalVta();
	}
	public Venta(List<Prenda> prendas,Tarjeta tarjeta) {
		this(prendas);//llamo al contructor con un solo parametro(sobrecargado)
		this.tarjeta=tarjeta;
		this.totalVta();
	}
	public double totalVta() {
		double total=0;
		for(Prenda prenda:prendas) {
			total+=prenda.calcularCosto();
		}
		if (this.esConTarjeta())
		{
			total-=this.tarjeta.calcularDescuento(total);
		}
		return total;
	}
	public boolean esConTarjeta() {
		return this.tarjeta!=null;
	}
}

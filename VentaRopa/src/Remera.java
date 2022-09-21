
public class Remera extends Prenda{
	private double impuesto;
	
	public Remera(double porcenGanancia, double precioLista,double impuesto) throws Exception {
		super(porcenGanancia,precioLista);
		setImpuesto(impuesto);
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) throws Exception {
		if (impuesto<0) {
			throw new ValorNegException(impuesto);
		}
		else{
			this.impuesto = impuesto;
		}
	}
	@Override
	public double calcularCosto() {
		return this.getPrecioLista()+this.getImpuesto();
	}
}

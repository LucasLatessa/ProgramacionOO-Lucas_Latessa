
public class Prenda {
	private double porcenGanancia;
	private double precioLista;
	public Prenda(double porcenGanancia, double precioLista) throws Exception {
		setPorcenGanancia(porcenGanancia);
		setPrecioLista(precioLista);
	}
	public void setPorcenGanancia(double porcenGanancia) throws Exception {
		if (porcenGanancia<0) {
			throw new ValorNegException(porcenGanancia);
		}
		else{
			this.porcenGanancia = porcenGanancia;
		}
	}
	public void setPrecioLista(double precioLista) throws Exception {
		if (precioLista<0) {
			throw new ValorNegException(precioLista);
		}
		else{
			this.precioLista = precioLista;
		}	
	}
	public double getPrecioLista() {
		return precioLista;
	}
	public double getPorcenGanancia() {
		return porcenGanancia;
	}
	public double precioVta() {
		return (this.getPorcenGanancia()/10)*this.calcularCosto() + this.calcularCosto();
	}
	public double calcularCosto() {
		return this.getPrecioLista();
	}
}


public class Sweater extends Prenda{

	public Sweater(double porcenGanancia, double precioLista) throws Exception {
		super(porcenGanancia,precioLista);
	}
	@Override
	public double precioVta() {
		return (super.precioVta() +0.08*super.getPrecioLista())	;
		}
}

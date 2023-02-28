
public class CuentaCredito {
	int compras=0;
	int limiteCompra;
	int recargoFijo=5;
	public CuentaCredito( int limite){
		limiteCompra=limite;
	}
	public void compra(int valor) {// agg exepcion.
		if (limiteCompra<=valor){
			limiteCompra-=valor;
			compras+=valor+(valor*recargoFijo)/100;
		}
	}
	public void cargar(int valor) {
		limiteCompra+=valor-(valor*recargoFijo)/100;
		compras-=valor;
	}
	public int getMontoDisponible() {
		return limiteCompra;
	}
	public int getSaldoDeudor() {
		return compras;
	}
}

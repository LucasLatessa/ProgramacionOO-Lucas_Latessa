
public class CuentaNormal {
	int limiteDeGiro;
	int saldo;
	public CuentaNormal( int limite) {
		this.limiteDeGiro=limite;
	}
	/**
	 * @param monto
	 * @returndevuelvo saldo que use del giro, sino use es 0
	 */
	public int gastarDin(int monto) {
		int cant=0;
		if (saldo<monto){
			limiteDeGiro-=monto-saldo;
			cant= (monto-saldo);
			saldo=0;
		}else {
			saldo-=monto;
		}
		return cant;
	}
	public boolean gastarSinGiro(int monto) {
		if (monto<saldo){
			saldo-=monto;
		}
		return monto>=0;
	}
	public void cargar(int monto) {
		saldo+=monto;
	}
	public int getSaldo() {
		return saldo;
	}
	public int getLimiteGiro() {
		return limiteDeGiro;
	}
}

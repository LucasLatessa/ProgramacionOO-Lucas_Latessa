
public class CuentaNormal {
	int limiteDeGiro;
	int saldo;
	public CuentaNormal( int limite) {
		this.limiteDeGiro=limite;
	}
	/**
	 * @param monto
	 * @return devuelvo saldo que use del giro, sino use es 0
	 */
	public int gastarDin(int monto) throws Exception{
		int cant=0;
		if (monto>(saldo+limiteDeGiro)) {
			throw new Exception("No se pudo realizar compra. Saldo :"+saldo+", Limite de giro: "+limiteDeGiro);
		}
		if (saldo<monto){
			limiteDeGiro-=monto-saldo;
			cant= (monto-saldo);
			saldo=0;
		}else {
			saldo-=monto;
		}
		return cant;
	}
	public boolean gastarSinGiro(int monto) throws Exception{
		if (monto>saldo){
			throw new Exception("No se pudo realizar compra sin giro. Saldo :"+saldo);
		}
		 saldo-=monto;
		 return true;
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


public class ValorNegException extends Exception {
	public ValorNegException(double valor) {
		super ("No se admite un valor negativo, valor especificado:"+valor);
	}
	public ValorNegException(String Mensaje) {
		super (Mensaje);
	}
}

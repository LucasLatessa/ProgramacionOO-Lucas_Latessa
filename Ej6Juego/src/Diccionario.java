import java.util.ArrayList;

public class Diccionario {
	private ArrayList<String> palabras;
	public Diccionario() {
	 palabras=new ArrayList<String>();
	}
	public boolean validar_palab(String palabra) {
		int i=0;
		boolean retorno=false;
		while (palabras.size()>i && !retorno) {
			retorno=palabra.equals(palabras.get(i++));
		}
		return retorno;
	}
	public void addPalabra(String palabra) {
		palabras.add(palabra);
	}
}

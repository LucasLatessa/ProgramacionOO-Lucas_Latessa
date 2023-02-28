import java.util.ArrayList;

public class Buscar {
		public boolean metodo(String s, ArrayList<String> lista) {
			boolean retorno=false;
			int i=0;
			while (lista.size()>i && !retorno) {
				retorno=s.equals(lista.get(i++));
			}
			return retorno;
		}
	}

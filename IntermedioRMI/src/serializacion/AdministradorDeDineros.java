package serializacion;
import java.io.Serializable;
import java.util.ArrayList;
public class AdministradorDeDineros implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> nombres;
	private ArrayList<Integer> dinero;
	public AdministradorDeDineros() {
		nombres=new ArrayList<String>();
		dinero=new ArrayList<Integer>();
	}
	public void addJugador(String nombre,int cantDinero) {
		int dineroFavor=cantDinero;
		boolean encontrado=false;
		for(int i=0;i<nombres.size();i++) {
			if(nombre.equals(nombres.get(i))) {
				dineroFavor+=dinero.get(i);//el total del dinero de ese jugador
				dinero.remove(i);
				dinero.add(i, dineroFavor);
				encontrado=true;
			}
		}
		if (!encontrado) {
			nombres.add(nombre);
			dinero.add(cantDinero);
		}
	}
	public ArrayList<String> getNombresGanadores() {
		return nombres;
	}
	public ArrayList<Integer> getDineroAFavor() {
		return dinero;
	}
}
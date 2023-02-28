import java.util.ArrayList;

public class EjercicioClase {
	public static void main(String[] args) {
		ArrayList<String> nombreArrayList = new ArrayList<String>();
		nombreArrayList.add("hola");
		nombreArrayList.add("chau");
		nombreArrayList.add("perro");
		Buscar busqueda=new Buscar();
		System.out.println(busqueda.metodo("perro",nombreArrayList));
	}
}

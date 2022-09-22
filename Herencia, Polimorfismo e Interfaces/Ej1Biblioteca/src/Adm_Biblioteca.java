import java.util.ArrayList; 
public class Adm_Biblioteca {
	private ArrayList<Publicacion> publicaciones;

 public Adm_Biblioteca() {
	 publicaciones= new ArrayList<Publicacion>();
	}
 public void addLibro(String nombre,String editor,String telefono,int ejemplares) {
	 Publicacion publi1;
	 publi1= new Publicacion(nombre, editor, telefono,ejemplares);
	 publicaciones.add(publi1);
 }
 public Publicacion buscarUnLibro(String titulo,String autor) {
	 Publicacion retorno=null;
	 int i=1;
	while(i<publicaciones.size() && retorno==null) {
		 if (publicaciones.get(i).buscar(titulo, autor)) {
			 retorno=publicaciones.get(i);
		 }
		 i=i+1;
	 }
	 return retorno;
 }
 public boolean verificarSiPuedeLlevar(Publicacion publi) {
		 publi.prestar();
		 return true;
	 
 }
}

import java.util.ArrayList; 
public class Adm_Biblioteca {
	private ArrayList<Publicacion> publicaciones;

 public Adm_Biblioteca() {
	 publicaciones= new ArrayList<Publicacion>();
	}
 public void addLibro(String isbn, int anioPublicacion,int cantAutores,
			String autores,int ejemplares,String nombre,String editor,String telefono,int paginas) {
	 Publicacion publi1;
	 publi1= new Libro( isbn,  anioPublicacion, cantAutores,autores, ejemplares, nombre, editor, telefono, paginas);
	 publicaciones.add(publi1);
 }
 public void addRevista( String issn, int numero, int anioPublicacion, int ejemplares,String nombre,String editor,String telefono,int paginas) {
	 Publicacion publi1;
	 publi1= new Revista( issn,numero,  anioPublicacion, ejemplares, nombre, editor, telefono, paginas);
	 publicaciones.add(publi1);
}
 public void addDiario( String fechaPublicacion,String nombre,String editor,String telefono) throws Exception {
	 Publicacion publi1;
	 publi1= new Diario(fechaPublicacion, nombre, editor, telefono);
	 publicaciones.add(publi1);
}
 public void addTesis(String autor, int anioPublicacion, int mesPublicacion,String nombre,String editor,String telefono) {
	 Publicacion publi1;
	 publi1= new Tesis( autor,  anioPublicacion,  mesPublicacion, nombre, editor, telefono);
	 publicaciones.add(publi1);
}
 public Publicacion buscarPubli(String nombre,String editor) {
	 Publicacion retorno=null;
	 int i=0;
	while(i<publicaciones.size() && retorno==null) {
		 if (publicaciones.get(i).buscar(nombre, editor)) {
			 retorno=publicaciones.get(i);
		 }
		 i=i+1;
	 }
	 return retorno;
 }
 public boolean prestarPubli(Publicacion publi) {
		 publi.prestar();
		 return true;
	 
 }
}

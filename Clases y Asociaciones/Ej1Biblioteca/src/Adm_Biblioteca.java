import java.util.ArrayList; 
public class Adm_Biblioteca {
	private ArrayList<Libro> libros;

 public Adm_Biblioteca() {
		libros= new ArrayList<Libro>();
	}
 public void addLibro(String titulo,String autor,String isbn, int paginas, int ejemplares) {
	 Libro libro1;
	 if (isbn.equals("0")) {
		 libro1= new Libro(titulo,autor,paginas,ejemplares);
	 }
	 else {
		 libro1= new Libro(titulo,autor,isbn,paginas,ejemplares);
	 }
	libros.add(libro1);
 }
 public Libro buscarUnLibro(String titulo,String autor) {
	 Libro retorno=null;
	 int i=1;
	while(i<libros.size() && retorno==null) {
		 if (libros.get(i).buscar(titulo, autor)) {
			 retorno=libros.get(i);
		 }
		 i=i+1;
	 }
	 return retorno;
 }
 public boolean verificarSiPuedeLlevar(Libro libro) {
	 if (libro.getEjemplares()>1){
		 libro.prestar();//si se puede llevar(hay mas de q ejemplar) sumo uno a ejemplares prestados y resto a ejemplares
		 return true;
	 }
	 else {
	return false;}
 }
}

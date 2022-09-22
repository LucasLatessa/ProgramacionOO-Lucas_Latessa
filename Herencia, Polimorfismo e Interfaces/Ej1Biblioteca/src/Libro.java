import java.util.ArrayList;

public class Libro extends Publicacion{
	private String isbn;
	private int anioPublicacion;
	private ArrayList<String> autores;
	private int ejemplares;
	private int ejemplaresPrestados;

	public Libro(String isbn, int anioPublicacion,int cantAutores,String autores,int ejemplares,String nombre,String editor,String telefono,int paginas) {
		super( nombre, editor, telefono, paginas);
		this.anioPublicacion=anioPublicacion;
		this.isbn=isbn;
		this.ejemplares=ejemplares;
		this.ejemplaresPrestados=0;
		if (cantAutores==1) {
			this.autores.add(autores);//si tengo un solo autor lo agrego al arraylist
		} else {
			String[] partes = autores.split(";");
			for(int i = 0; i < cantAutores; i++)    //si tengo mas de uno estan separados por ; los voy agregando c/u 
			    {
				String autor1 = partes[i]; 
				this.autores.add(autor1);
			    }
		}
		
		
	}
	public Libro( int anioPublicacion, int cantAutores,String autores,int ejemplares,String nombre,String editor,String telefono,int paginas) {
		this("0",anioPublicacion,cantAutores,autores,ejemplares,nombre,editor,telefono,paginas);
		}
	public boolean coincideYPuedoPrestar(String nombre,String editor) {
		boolean retorno=false;
		if (super.coincide(nombre,editor)&& this.ejemplares>1) {
			ejemplares-=1;
			ejemplaresPrestados+=1;
			retorno=true;
		}
		return retorno;
	}
	/*
	public boolean buscar(String titulo,String autor) {
		return (titulo.equals(this.titulo) && autor.equals(this.autor));
	}
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public int getPaginas() {
		return paginas;
	}
	public int getEjemplares() {
		return ejemplares;
	}
	public int getEjemplaresPrestados() {
		return ejemplares_prestados;
	}*/
}

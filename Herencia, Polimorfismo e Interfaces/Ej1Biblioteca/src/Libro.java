import java.util.ArrayList;

public class Libro extends Publicacion{
	private String isbn;
	private int anioPublicacion;
	private ArrayList<Autor> autores;
	private int ejemplares;
	private int ejemplaresPrestados;
	private int paginas;

	public Libro(String isbn, int anioPublicacion,int cantAutores,
			String autores,int ejemplares,String nombre,String editor,String telefono,int paginas) {
		super( nombre, editor, telefono);
		this.paginas=paginas;
		this.anioPublicacion=anioPublicacion;
		this.isbn=isbn;
		this.ejemplares=ejemplares;
		this.ejemplaresPrestados=0;
		this.autores=new ArrayList<Autor>();
		if (cantAutores==1) {
			Autor aut=new Autor(autores);
			this.autores.add(aut);//si tengo un solo autor lo agrego al arraylist
		} else {
			String[] partes = autores.split(";");
			for(int i = 0; i < cantAutores; i++)    //si tengo mas de uno estan separados por ; los voy agregando c/u 
			    {
				String autor1 = partes[i]; 
				Autor aut=new Autor(autor1);
				this.autores.add(aut);
			    }
		}
		
		
	}
	public Libro( int anioPublicacion, int cantAutores,String autores,int ejemplares,String nombre,String editor,String telefono,int paginas) {
		this("0",anioPublicacion,cantAutores,autores,ejemplares,nombre,editor,telefono,paginas);
		}
	public boolean prestar() {
		boolean retorno=false;
		if (this.ejemplares>1) {
			ejemplares-=1;
			ejemplaresPrestados+=1;
			retorno=true;
		}
		return retorno;
	}
	public String getAutor() {
		String ss="";
		for(int i = 0; i < autores.size(); i++)    //si tengo mas de uno estan separados por ; los voy agregando c/u 
	    {
			ss=ss+";"+(autores.get(i).getNombre()+","+autores.get(i).getApellido());
	    }
		return ss;
				
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

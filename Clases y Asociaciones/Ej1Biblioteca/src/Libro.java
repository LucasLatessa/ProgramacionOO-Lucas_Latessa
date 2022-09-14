
public class Libro {
	private String titulo;
	private String autor;
	private String isbn;
	private int paginas;
	private int ejemplares;
	private int ejemplares_prestados;
	public Libro(String titulo,String autor,String isbn, int paginas, int ejemplares) {
		this.titulo=titulo;
		this.autor=autor;
		this.isbn=isbn;
		this.paginas=paginas;
		this.ejemplares=ejemplares;
		this.ejemplares_prestados=0;
	}
	public Libro(String titulo,String autor, int paginas, int ejemplares) {
		//this.Libro(titulo,autor,"0",paginas,ejemplares,ejemplares_prestados);/da error
		this.titulo=titulo;
		this.autor=autor;
		this.isbn="0";
		this.paginas=paginas;
		this.ejemplares=ejemplares;
		this.ejemplares_prestados=0;
		}
	public void prestar() {
		ejemplares-=1;
		ejemplares_prestados+=1;
	}
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
	}
}

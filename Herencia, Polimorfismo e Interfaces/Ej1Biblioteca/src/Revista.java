
public class Revista extends Publicacion {
	private String issn;
	private int numero;
	private int anioPublicacion;
	private int ejemplares;
	private int ejemplaresPrestados;
	private int paginas;
	public Revista( String issn, int numero, int anioPublicacion, int ejemplares,String nombre,String editor,String telefono,int paginas) {
		super( nombre, editor, telefono);
		this.paginas=paginas;
		this.anioPublicacion=anioPublicacion;
		this.ejemplares=ejemplares;
		this.ejemplaresPrestados=0;
		this.numero=numero;
	}
	public Revista( int numero,int anioPublicacion, String autores,int ejemplares,String nombre,String editor,String telefono,int paginas) {
		this("0",numero,anioPublicacion,ejemplares,nombre,editor,telefono,paginas);
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
}

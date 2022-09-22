
public class Revista extends Publicacion {
	private String issn;
	private int numero;
	private int anioPublicacion;
	private int ejemplares;
	private int ejemplaresPrestados;
	public Revista( String issn, int numero, int anioPublicacion, int ejemplares,String nombre,String editor,String telefono,int paginas) {
		super( nombre, editor, telefono, paginas);
		this.anioPublicacion=anioPublicacion;
		this.ejemplares=ejemplares;
		this.numero=numero;
	}
	public Revista( int numero,int anioPublicacion, String autores,int ejemplares,String nombre,String editor,String telefono,int paginas) {
		this("0",numero,anioPublicacion,ejemplares,nombre,editor,telefono,paginas);
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
}

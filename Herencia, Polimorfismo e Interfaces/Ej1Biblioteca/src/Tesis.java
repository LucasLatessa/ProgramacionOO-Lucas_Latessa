
public class Tesis extends Publicacion{
	private String autor;
	private int anioPublicacion;
	private int mesPublicacion;
	public Tesis(String autor, int anioPublicacion, int mesPublicacion,String nombre,String editor,String telefono,int paginas) {
		super( nombre, editor, telefono, paginas);
		this.autor=autor;
		this.anioPublicacion=anioPublicacion;
		this.mesPublicacion=mesPublicacion;
		
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAnioPublicacion() {
		return anioPublicacion;
	}
	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}
	public int getMesPublicacion() {
		return mesPublicacion;
	}
	public void setMesPublicacion(int mesPublicacion) {
		this.mesPublicacion = mesPublicacion;
	}

}

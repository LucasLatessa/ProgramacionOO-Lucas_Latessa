
public class Tesis extends Publicacion{
	private Autor autor;
	private int anioPublicacion;
	private int mesPublicacion;
	public Tesis(String autor, int anioPublicacion, int mesPublicacion,String nombre,String editor,String telefono) {
		super( nombre, editor, telefono);
		Autor aut=new Autor(autor);
		this.autor=aut;
		this.anioPublicacion=anioPublicacion;
		this.mesPublicacion=mesPublicacion;
		
	}
	public String getAutor() {
		return (autor.getNombre()+","+autor.getApellido());
	}
	public int getAnioPublicacion() {
		return anioPublicacion;
	}
	public int getMesPublicacion() {
		return mesPublicacion;
	}
	public boolean prestar() {
		return true;
	}

}

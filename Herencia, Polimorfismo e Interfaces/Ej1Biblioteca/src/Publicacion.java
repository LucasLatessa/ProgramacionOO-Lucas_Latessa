
public abstract class Publicacion {
	private String nombre;
	private String editor;
	private String contactoProv;
	
	public Publicacion(String nombre,String editor,String telefono) {
		this.nombre=nombre;
		this.editor=editor;
		this.contactoProv=telefono;
	}
	public abstract boolean prestar();
	public boolean buscar(String nombre,String editor) {
		return (((this.nombre).equals(nombre)) && ((this.editor).equals(editor)));
	}
	public String getNombre() {
		return nombre;
	}
	public String getEditor() {
		return editor;
	}
}

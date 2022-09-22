
public class Publicacion {
	private String nombre;
	private String editor;
	private String telefono;
	private int paginas;
	public Publicacion(String nombre,String editor,String telefono,int paginas) {
		this.nombre=nombre;
		this.editor=editor;
		this.telefono=telefono;
		this.paginas=paginas;
	}
	public boolean coincide(String nombre,String editor) {
		return (nombre.equals(this.nombre) && editor.equals(this.editor));
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}

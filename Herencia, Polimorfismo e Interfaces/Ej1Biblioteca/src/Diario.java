import java.time.LocalDate;

public class Diario extends Publicacion{
	private Fecha fechaPublicacion;
	public Diario( String fechaPublicacion,String nombre,String editor,String telefono) throws Exception {
		super( nombre, editor, telefono);
		this.fechaPublicacion=new Fecha(fechaPublicacion);
	}
	public Fecha getFechaPublicacion() {
		return fechaPublicacion;
	}
	public boolean prestar() {
		return true;
	}
	
}

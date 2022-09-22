import java.time.LocalDate;

public class Diario extends Publicacion{
	private Fecha fechaPublicacion;
	public Diario( String fechaPublicacion,String nombre,String editor,String telefono,int paginas) throws Exception {
		super( nombre, editor, telefono, paginas);
		this.fechaPublicacion=new Fecha(fechaPublicacion);
	}
	public Fecha getFechaPublicacion() {
		return fechaPublicacion;
	}

}

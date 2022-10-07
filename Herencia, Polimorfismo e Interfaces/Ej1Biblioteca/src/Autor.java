
public class Autor {
		private String nombre;
		private String apellido;
	public Autor(String autor) {
		String[] partes = autor.split(",");
		String nomb = partes[0]; 
		String ape = partes[1]; 
		this.apellido=ape;
		this.nombre=nomb;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
}

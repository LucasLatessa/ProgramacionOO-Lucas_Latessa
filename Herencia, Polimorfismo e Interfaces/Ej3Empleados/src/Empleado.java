
public abstract class Empleado implements IEmpleados {
		private String nombre;
		private String apellido;
		private String telefono;
		private String cuil;
		private Fecha cumpleaños;
	
	public Empleado(String nombre,String apellido,String telefono,String cuil,String cumpleaños ) throws Exception {
		setNombre(nombre);
		setApellido(apellido);
		setTelefono(telefono);
		setCuil(cuil);
		Fecha fecha=new Fecha(cumpleaños);
		this.cumpleaños=fecha;
	}
	public Empleado(String nombre,String apellido,String telefono,String cuil ) {
		setNombre(nombre);
		setApellido(apellido);
		setTelefono(telefono);
		setCuil(cuil);
	}
	public double calcularSueldo() {
		return 2000;
	}
	public boolean ifCumpleaños() {
		return cumpleaños.fechaMismoMesHoy();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

}

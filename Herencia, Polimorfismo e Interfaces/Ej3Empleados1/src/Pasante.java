
public class Pasante extends Empleado{
		private double salario=0;
	public Pasante(String nombre,String apellido,String telefono,String cuil) {
		super( nombre, apellido, telefono, cuil);
	}
	public double calcularSueldo() {
		return salario;
	}

}

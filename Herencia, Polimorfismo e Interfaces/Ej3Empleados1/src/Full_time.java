
public class Full_time extends Empleado{
		private double salario; 
	public Full_time(double salario,String nombre,String apellido,String telefono,String cuil,String cumpleaños) throws Exception {
		super( nombre, apellido, telefono, cuil, cumpleaños);
		this.salario=salario;
	}
	public double calcularSueldo() {
		if (super.ifCumpleaños()) {
		return salario+super.calcularSueldo()+1000;
		}else {
			return salario;
		}
	}

}


public class PorComisionSalarioBase extends PorComision{
		private double montoFijo;
	public PorComisionSalarioBase(double salario,int porcPorVentas,double ventas,String nombre,String apellido,String telefono,String cuil, String cumpleaños) throws Exception {
		super( porcPorVentas, ventas, nombre, apellido, telefono, cuil,cumpleaños);
		this.montoFijo=salario;
	}
	public double calcularSueldo() {
		if (super.ifCumpleaños()){
			return super.calcularSueldo()+montoFijo+1000;
		}
		return super.calcularSueldo()+montoFijo;
	}
}

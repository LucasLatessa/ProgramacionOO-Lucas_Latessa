
public class PorComision extends Empleado{
		private int porcPorVentas;
		private double ventas;
		
	public PorComision(int porcPorVentas,double ventas,String nombre,String apellido,String telefono,String cuil,String cumpleaños) throws Exception {
		super( nombre, apellido, telefono, cuil, cumpleaños);
		setPorcPorVentas(porcPorVentas);
		setVentas(ventas);
	}
	public int getPorcPorVentas() {
		return porcPorVentas;
	}
	public void setPorcPorVentas(int porcPorVentas) {
		this.porcPorVentas = porcPorVentas;
	}
	public double getVentas() {
		return ventas;
	}
	public void setVentas(double ventas) {
		this.ventas = ventas;
	}
	public double calcularSueldo() {
		if (super.ifCumpleaños()) {
			return ventas*(Float.valueOf(porcPorVentas)/100)+super.calcularSueldo()+ventas*(0.5/100);
		}else
			return ventas*(Float.valueOf(porcPorVentas)/100);
	}

}

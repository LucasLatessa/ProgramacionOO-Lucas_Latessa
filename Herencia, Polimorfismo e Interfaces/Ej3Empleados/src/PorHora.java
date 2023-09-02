
public class PorHora extends Empleado{
		private double montoPorHora;
		private int horas;
		private double porcExtra=20;
	public PorHora(double montoPorHora,int horas,String nombre,String apellido,String telefono,String cuil,String cumpleaños) throws Exception {
		super( nombre, apellido, telefono, cuil,cumpleaños);
		setmontoPorHora(montoPorHora);
		setHoras(horas);
	}
	public double getmontoPorHora() {
		return montoPorHora;
	}
	public void setmontoPorHora(double montoFijo) {
		this.montoPorHora = montoFijo;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public double calcularSueldo() {
		double suma=0;
		if (super.ifCumpleaños()){
			 suma=super.calcularSueldo();
		}
		if (horas>40){
			return (montoPorHora*horas+((montoPorHora*horas)*(porcExtra/100)))+suma;
		}else {
		return montoPorHora*horas+suma;
		}
	}

}

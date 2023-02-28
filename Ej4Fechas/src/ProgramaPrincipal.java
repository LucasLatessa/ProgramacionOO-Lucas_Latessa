
public class ProgramaPrincipal {

	public static void main(String[] args) {
		Fecha fecha1=new Fecha("12-10-2022",FormatosdeFecha.DD_MM_YYYY);
		Fecha fecha2=new Fecha("12-10-2021",FormatosdeFecha.DD_MM_YYYY);
		Fecha fecha3=new Fecha("12-10-2023",FormatosdeFecha.DD_MM_YYYY);
		System.out.println("12-10-2022 es mayor a 12-10-2021? "+fecha1.fechaMayorAOtra(fecha2));
		System.out.println("12-10-2022 esta entre 12-10-2021 y 12-10-2023? "+fecha1.fechaEntreDosFechas(fecha2, fecha3));
	}

}

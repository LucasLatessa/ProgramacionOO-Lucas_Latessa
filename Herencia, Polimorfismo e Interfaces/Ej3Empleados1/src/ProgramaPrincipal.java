
public class ProgramaPrincipal {

		public static void main(String[] args) {
		
		IEmpleados empleadoFT = null;
		try {
			empleadoFT = new Full_time(20000,"Lucas","Latessa","2346123456","20-44610058-1","10-10-2000");
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		IEmpleados empleadoPC = null;
		try {
			empleadoPC = new PorComision(50,50000,"comision","2","2346123456","20-44610058-2","01-10-2022");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		IEmpleados empleadoPCSB = null;
		try {
			empleadoPCSB = new PorComisionSalarioBase(10000,50,50000,"comisionconsalario","3","2346123456","20-44610058-3","10-02-1990");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IEmpleados empleadoPCSB2 = null;
		try {
			empleadoPCSB2 = new PorComisionSalarioBase(10000,50,50000,"comisionconsalario","3","2346123456","20-44610058-3","10-10-1990");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IEmpleados empleadoPH = null;
		try {
			empleadoPH = new PorHora(300,100,"hora","4","2346123456","20-44610058-4","31-10-2002");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IEmpleados empleadoPas = new Pasante("pasante","4","2346123456","20-44610058-5");
		System.out.println("Sueldo empleado full time(sueldo $20.000;cumple años este mes): "+empleadoFT.calcularSueldo());	
		System.out.println("Sueldo empleado por comision(porcentaje por venta 50% ; ventas $50.000; cumple años este mes): "+empleadoPC.calcularSueldo());	
		System.out.println("Sueldo empleado por comision con salario base(sueldo $10.000 ; porcentaje por venta 50%; ventas $50.000; NO cumple años este mes): "
														+empleadoPCSB.calcularSueldo());	
		System.out.println("Sueldo empleado por comision con salario base(sueldo $10.000 ; porcentaje por venta 50%; ventas $50.000; cumple años este mes): "
				+empleadoPCSB2.calcularSueldo());	
		System.out.println("Sueldo empleado por hora (sueldo por hora $300; horas: 100; cumple años este mes): "+empleadoPH.calcularSueldo());	
		System.out.println("Sueldo empleado por pasante: "+empleadoPas.calcularSueldo());
		}
		}

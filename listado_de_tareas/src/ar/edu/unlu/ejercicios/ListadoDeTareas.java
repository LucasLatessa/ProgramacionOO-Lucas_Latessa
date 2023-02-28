package ar.edu.unlu.ejercicios;
import java.util.Scanner;
import java.lang.System;
public class ListadoDeTareas {
	//tareas:listarray

	public static void main(String[] args) {
		Tarea tarea1 = new Tarea();
		tarea1.setDesc("Ir al supermercado mañana");
		tarea1.setCompleta("N");// S/N
		tarea1.setFecha(2022,8,20);
		Tarea tarea2 = new Tarea();
		tarea2.setDesc("Consultar repuesto del auto");
		tarea2.setCompleta("S");// S/N
		tarea2.setFecha(2022,8,17);
		Tarea tarea3 = new Tarea();
		tarea3.setDesc("Ir al cine a ver la nueva película de Marvel");
		tarea3.setCompleta("N");// S/N
		tarea3.setFecha(2022,8,17);
		
		//DE MAS (PRUEBAS)
		String s;
		do { 
		System.out.println("Ingrese una opcion: \n-1:Ir al supermercado mañana \n-2:Consultar repuesto del auto \n-3:Ir al cine a ver la nueva película de Marvel \n-4:Salir\n");
		Scanner nomTarea=new Scanner(System.in);
		 s=nomTarea.nextLine();
		if (Integer.valueOf(s)==4){
				java.lang.System.exit(0);}
		System.out.println("ingrese una opcion:\n-1:Modificar descripcion \n-2:Cambiar la prioridad \n-3:Avisar que esta terminada "
				+ "\n-4:Mostrar la tarea \n-5:La tarea esta vencida? \n-6:Consultar si está completa o no\n");
		Scanner opcion2=new Scanner(System.in);
		String ss =opcion2.nextLine();
		switch(Integer.valueOf(ss)) {  		
		case 1:
			System.out.println("Ingrese una descripcion:");
			Scanner newDesc=new Scanner(System.in);
			switch(Integer.valueOf(s)) {
				case 1: tarea1.setDesc(newDesc.nextLine());
				break;
				case 2: tarea2.setDesc(newDesc.nextLine());
				break;
				case 3: tarea3.setDesc(newDesc.nextLine());
			}
			break;
		case 2:
			System.out.println("Ingrese prioridad:");
			Scanner newPrio=new Scanner(System.in);
			switch(Integer.valueOf(s)) {
				case 1: tarea1.setPrio(newPrio.nextLine());
				break;
				case 2: tarea2.setPrio(newPrio.nextLine());
				break;
				case 3: tarea3.setPrio(newPrio.nextLine());
			}
			break;
		case 3:
			switch(Integer.valueOf(s)) {
				case 1: tarea1.setVencida();
				break;
				case 2: tarea2.setVencida();
				break;
				case 3: tarea3.setVencida();
			}
			System.out.println("Tarea "+s+" ahora esta terminada");
			break;
		case 4:
			switch(Integer.valueOf(s)) {
			case 1: System.out.println(tarea1.getTarea());
			break;
			case 2: System.out.println(tarea2.getTarea());
			break;
			case 3: System.out.println(tarea3.getTarea());
		}
			break;
		case 5:
			switch(Integer.valueOf(s)) {
			case 1: System.out.println(tarea1.getVencida());
			break;
			case 2: System.out.println(tarea2.getVencida());
			break;
			case 3: System.out.println(tarea3.getVencida());
		}
			break;
		case 6:
			switch(Integer.valueOf(s)) {
			case 1: System.out.println(tarea1.getCompleta());
			break;
			case 2: System.out.println(tarea2.getCompleta());
			break;
			case 3: System.out.println(tarea3.getCompleta());
		}
		}
		}while (Integer.valueOf(s)!=4 );
	}
}

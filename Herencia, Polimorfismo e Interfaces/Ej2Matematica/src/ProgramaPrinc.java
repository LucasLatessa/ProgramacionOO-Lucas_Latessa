import java.util.ArrayList;
import java.util.Scanner;
public class ProgramaPrinc {
	 	private ArrayList<IFigura3D> figuras3d;
	 	private ArrayList<IFiguraGeometrica> figuras2d;
	public static void main(String[] args) {
		String ss="";
		while (!(ss.equals("0"))) {
			System.out.println("MENU(ingrese 0 para salir)");
			System.out.println("ANDAN CIRCULO, TRIANGULO, ESFERA, CUBO");
			System.out.println("1-círculo");
			System.out.println("2-rectángulo");
			System.out.println("3-cuadrado");
			System.out.println("4-triángulo");
			System.out.println("5-esfera");
			System.out.println("6-paralelepipedo");
			System.out.println("7-cubo");
			System.out.println("8-tetraedro (regular)");
			Scanner opcion=new Scanner(System.in);
			 ss =opcion.nextLine();
			switch(Integer.valueOf(ss)) {  		
			case 1:
				System.out.println("Ingrese longitud de radio:");
				Scanner radio=new Scanner(System.in);
				IFiguraGeometrica figuC=new Circulo(Integer.valueOf(radio.nextLine()));
				System.out.println("Area:"+figuC.getArea());
				break;
			case 2:
				System.out.println("Ingrese longitud de base:");
				Scanner base=new Scanner(System.in);
				String sBas =base.nextLine();
				System.out.println("Ingrese longitud de altura:");
				Scanner altura=new Scanner(System.in);
				IFiguraGeometrica figuR=new Rectangulo(Integer.valueOf(sBas),Integer.valueOf(altura.nextLine()));
				System.out.println("Area:"+figuR.getArea());
				break;
			case 3:
				System.out.println("Ingrese longitud de lado:");
				Scanner lado=new Scanner(System.in);
				IFiguraGeometrica figuCU=new Cuadrado(Integer.valueOf(lado.nextLine()));
				System.out.println("Area:"+figuCU.getArea());
				break;
			case 4:
				System.out.println("Ingrese longitud de base:");
				Scanner base1=new Scanner(System.in);
				String sBas1 =base1.nextLine();
				System.out.println("Ingrese longitud de altura:");
				Scanner altura1=new Scanner(System.in);
				IFiguraGeometrica figuT=new Triangulo(Integer.valueOf(sBas1),Integer.valueOf(altura1.nextLine()));
				System.out.println("Area:"+figuT.getArea());
				break;
			case 5:
				System.out.println("Ingrese longitud de radio:");
				Scanner radio1=new Scanner(System.in);
				IFigura3D figuE=new Esfera(Integer.valueOf(radio1.nextLine()));
				System.out.println("Area:"+figuE.getArea());
				System.out.println("Volumen:"+figuE.getVolumen());
				break;
			case 6:
				System.out.println("Ingrese longitud de arista1:");
				Scanner arista1=new Scanner(System.in);
				String sAris1 =arista1.nextLine();
				System.out.println("Ingrese longitud de arista2:");
				Scanner arista2=new Scanner(System.in);
				String sAris2 =arista2.nextLine();
				System.out.println("Ingrese longitud de arista3:");
				Scanner arista3=new Scanner(System.in);
				IFigura3D figuP=new Paralelepipedo(Integer.valueOf(sAris1),Integer.valueOf(sAris2),Integer.valueOf(arista3.nextLine()));
				System.out.println("Area:"+figuP.getArea());
				System.out.println("Volumen:"+figuP.getVolumen());
				break;
			case 7:
				System.out.println("Ingrese longitud de arista:");
				Scanner arista=new Scanner(System.in);
				IFigura3D figu2=new Cubo(Integer.valueOf(arista.nextLine()));
				System.out.println("Area:"+figu2.getArea());
				System.out.println("Volumen:"+figu2.getVolumen());
				break;
			case 8:
				System.out.println("Ingrese longitud de arista:");
				Scanner arista5=new Scanner(System.in);
				IFigura3D figuTE=new Tetraedro_regular(Integer.valueOf(arista5.nextLine()));
				System.out.println("Area:"+figuTE.getArea());
				System.out.println("Volumen:"+figuTE.getVolumen());
	}
			System.out.println("Presione enter");
			Scanner enter=new Scanner(System.in);
			String senter =enter.nextLine();
		}
}
	}

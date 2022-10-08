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
				IFiguraGeometrica figu=new Circulo(Integer.valueOf(radio.nextLine()));
				System.out.println("Area:"+figu.getArea());
				break;
			case 4:
				System.out.println("Ingrese longitud de base:");
				Scanner base=new Scanner(System.in);
				String sBas =base.nextLine();
				System.out.println("Ingrese longitud de altura:");
				Scanner altura=new Scanner(System.in);
				IFiguraGeometrica figu3=new Triangulo(Integer.valueOf(sBas),Integer.valueOf(altura.nextLine()));
				System.out.println("Area:"+figu3.getArea());
				break;
			case 5:
				System.out.println("Ingrese longitud de radio:");
				Scanner radio1=new Scanner(System.in);
				IFigura3D figu1=new Esfera(Integer.valueOf(radio1.nextLine()));
				System.out.println("Area:"+figu1.getArea());
				System.out.println("Volumen:"+figu1.getVolumen());
				break;
			case 7:
				System.out.println("Ingrese longitud de arista:");
				Scanner arista=new Scanner(System.in);
				IFigura3D figu2=new Cubo(Integer.valueOf(arista.nextLine()));
				System.out.println("Area:"+figu2.getArea());
				System.out.println("Volumen:"+figu2.getVolumen());
	}
		}
}
	}

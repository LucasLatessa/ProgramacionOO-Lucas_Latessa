import java.util.Scanner;

public class Programa_Princ {
	static Adm_Biblioteca biblioteca;
	public static void main(String[] args) {
		biblioteca=new Adm_Biblioteca();
		//CREO ALGUNOS LIBROS
		crearLibro("El Principito","Antoine de Saint-Exupéry"," 9789876848039",120,10);
		crearLibro("harry potter","Joanne Rowling"," 9789878000107",200,3);
		crearLibro("hola","lucas"," 9789878000107",200,1);
		String ss="";
		while (!(ss.equals("0"))) {
		System.out.println("MENU(ingrese 0 para salir)");
		System.out.println("1-Agregar nuevo libro");
		System.out.println("2-Pedir libro");
		Scanner opcion=new Scanner(System.in);
		 ss =opcion.nextLine();
		switch(Integer.valueOf(ss)) {  		
		case 1:
			System.out.println("Ingrese titulo:");
			Scanner titulo=new Scanner(System.in);
			String sTit =titulo.nextLine();
			System.out.println("Ingrese autor:");
			Scanner autor=new Scanner(System.in);
			String sAut =autor.nextLine();
			System.out.println("Ingrese ISBN (0 si no se tiene el dato):");
			Scanner iSBN=new Scanner(System.in);
			String sisbn =iSBN.nextLine();
			System.out.println("Ingrese numero de paginas:");
			Scanner pag=new Scanner(System.in);
			String sPag =pag.nextLine();
			System.out.println("Ingrese numero ejemplares:");
			Scanner ejem=new Scanner(System.in);
			String sEjem =ejem.nextLine();
			crearLibro(sTit,sAut,sisbn,Integer.valueOf(sPag),Integer.valueOf(sEjem));
		case 2: 
			System.out.println("Ingrese Titulo:");
			Scanner titulo2=new Scanner(System.in);
			String sTit1 =titulo2.nextLine();
			System.out.println("Ingrese Autor:");
			Scanner autor2=new Scanner(System.in);
			String sAut1 =autor2.nextLine();
			System.out.println(pedirLibro(sTit1,sAut1));
	}}}
	public static  String pedirLibro(String titulo,String autor){
		Libro libro=biblioteca.buscarUnLibro(titulo,autor);
		if (biblioteca.verificarSiPuedeLlevar(libro)){
			return "El libro "+libro.getTitulo()+" creado por el autor " +libro.getAutor()+ " tiene "+libro.getPaginas()+" páginas, quedan "+libro.getEjemplares()+" disponibles "
					+ "y se prestaron "+libro.getEjemplaresPrestados();
		}
		else {
			return "(LIBRO NO PUEDE SER PRESTADO)El libro "+libro.getTitulo()+" creado por el autor " +libro.getAutor()+ " tiene "+libro.getPaginas()+" páginas, quedan "+libro.getEjemplares()+" disponibles "
					+"y se prestaron "+libro.getEjemplaresPrestados();
		}
	}
	public static void crearLibro(String titulo,String autor,String isbn, int paginas, int ejemplares){
		biblioteca.addLibro(titulo,autor,isbn,paginas,ejemplares);
	}
}

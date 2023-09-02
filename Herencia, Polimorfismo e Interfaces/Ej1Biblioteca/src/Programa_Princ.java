import java.util.Scanner;

public class Programa_Princ {
	static Adm_Biblioteca biblioteca;
	public static void main(String[] args) {
		biblioteca=new Adm_Biblioteca();
		//CREO ALGUNAS Publicaciones
		biblioteca.addLibro("123456789", 2002, 2,"Julio Florencio, Cortázar;Jorge Luis, Borges",5,"Nuevo Libro","Santillana","2346123456",200);
		biblioteca.addRevista("123456789", 10, 2010, 5,"anteojito","Santillana","2346123456",20);
		try {
			biblioteca.addDiario( "15-10-2009","La Razon","alguien","2346123456");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		biblioteca.addTesis("Lucas,Latessa", 2022, 12,"La Tecnologia","Nose","2346123456");
		String ss="";
		while (!(ss.equals("0"))) {
		System.out.println("MENU(ingrese 0 para salir)");
		System.out.println("1-Agregar nuevo libro");
		System.out.println("2-Agregar nueva tesis");
		System.out.println("3-Agregar nuevo diario");
		System.out.println("4-Agregar nueva revista");
		System.out.println("5-Pedir publicacion");
		Scanner opcion=new Scanner(System.in);
		 ss =opcion.nextLine();
		switch(Integer.valueOf(ss)) {  		
		case 1:
			System.out.println("Ingrese titulo:");
			Scanner titulo=new Scanner(System.in);
			String sTit =titulo.nextLine();
			System.out.println("Ingrese cantidad de autor/es");
			Scanner cautor=new Scanner(System.in);
			String sCAut =cautor.nextLine();
			System.out.println("Ingrese autor/es(separar nombre de apellido con ','y autores con ';'(ejemplo:Julio Florencio, Cortázar):");
			Scanner autor=new Scanner(System.in);
			String sAut =autor.nextLine();
			System.out.println("Ingrese ISBN (0 si no se tiene el dato):");
			Scanner iSBN=new Scanner(System.in);
			String sisbn =iSBN.nextLine();
			System.out.println("Ingrese editor:");
			Scanner edit=new Scanner(System.in);
			String sEdit =edit.nextLine();
			System.out.println("Ingrese numero de paginas:");
			Scanner pag=new Scanner(System.in);
			String sPag =pag.nextLine();
			System.out.println("Ingrese numero ejemplares:");
			Scanner ejem=new Scanner(System.in);
			String sEjem =ejem.nextLine();
			System.out.println("Ingrese año de publicacion:");
			Scanner anio=new Scanner(System.in);
			String sAnio =anio.nextLine();
			System.out.println("Ingrese telefono de contacto con proveedor:");
			Scanner telf=new Scanner(System.in);
			String sTel =telf.nextLine();
			biblioteca.addLibro(sisbn,  Integer.valueOf(sAnio), Integer.valueOf(sCAut),sAut, Integer.valueOf(sEjem), sTit, sEdit, sTel, Integer.valueOf(sPag));
		case 5: 
			System.out.println("Ingrese Nombre:");
			Scanner titulo1=new Scanner(System.in);
			String sNom =titulo1.nextLine();
			System.out.println("Ingrese Editor:");
			Scanner edit1=new Scanner(System.in);
			String sEdit1 =edit1.nextLine();
			System.out.println(pedirPubli(sNom,sEdit1));
	}}}
	public static  String pedirPubli(String nombre,String editor){
		Publicacion publi=biblioteca.buscarPubli(nombre,editor);
		if (biblioteca.prestarPubli(publi)){
			return "Publicacion "+publi.getNombre()+" creado por el editor " +publi.getEditor()+" prestada con exito";
		}
		else {
			return "(LIBRO/REVISTA NO PUEDE SER PRESTADO)La publicacion "+publi.getNombre()+", editor " +publi.getEditor()+
					"no se puede prestar la publicacion porque tiene que quedar disponible para consultar dentro de la biblioteca";
		}
	}
}

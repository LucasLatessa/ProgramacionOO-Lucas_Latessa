
public class ProgramaPrinc {

	public static void main(String[] args) {
		Contraseña cont=new Contraseña(7);
		System.out.println(cont.getContrasenia()+" - "+cont.esFuerte());
		System.out.println(cont.hacerFuerte());
		System.out.println(cont.getContrasenia()+" - "+cont.esFuerte());
		
	}

}

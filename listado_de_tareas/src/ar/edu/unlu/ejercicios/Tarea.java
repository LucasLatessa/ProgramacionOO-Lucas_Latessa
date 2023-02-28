package ar.edu.unlu.ejercicios;
import java.time.LocalDate;

public class Tarea {
	private boolean completa=false;
	private boolean vencida=false;
	private LocalDate fecha = LocalDate.now();
	private String descripcion;
	private String prioridad;
	//enumeradoEstado:Completa,incompleta, vencida
	//enumeradoprioridades:BAJA, MEDIA, ALTA
	public void Tarea(desc,fecha,prioridad,estado) {
		
	}
	public void Tarea(desc,fecha) {
		this.Tarea(desc,fecha,'')
	}
	public void Tarea(desc) {
		
	}
	public void setVencida() {
		vencida=true;
	}
	public void setCompleta(String ss) { 
		completa=(ss=="S");//Si parametro es S marco true, distinto marco como false
	}
	public void setDesc(String ss) { 
		descripcion=ss;
	}
	public void setPrio(String ss) { 
		prioridad=ss;
	}
	public void setFecha(int a,int m,int d) { 
		fecha=LocalDate.of(a,m,d);
	}
	
	public String getCompleta() { 
		if (completa) {
			return ("La tarea esta completa");
		} else {
			return ("La tarea NO esta completa");
		}
	}
	public String getVencida() { // TERMINADA=VENCIDA
		if (vencida) {
			return ("La tarea esta vencida");
		} else {
			return ("La tarea NO esta vencida");
		}
	}
	public String getTarea() {
		String retorno="";
		if (vencida) {
			retorno ="(Vencida)";
		}
		retorno=retorno+descripcion;
		return (retorno);
	}
}

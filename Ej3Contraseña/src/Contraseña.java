
public class Contraseña {
	private int longitud=8;
	private String cadena;
	public Contraseña() {
	        String letrasYNums;
	        StringBuilder crea;
	        letrasYNums = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                                    + "0123456789"; 
	        crea = new StringBuilder(longitud); 
	        for (int m = 0; m < longitud; m++) { 
	            int i= (int)(letrasYNums.length()* Math.random());
	            crea.append(letrasYNums.charAt(i)); 
	        } 
	        cadena= crea.toString(); 
	}
	public Contraseña(int longi) {
		String letrasYNums;
        StringBuilder crea;
        longitud=longi;
        letrasYNums = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"abcdefghijklmnopqrstuvwxyz"
                                    + "0123456789"; 
        crea = new StringBuilder(longitud); 
        for (int m = 0; m < longitud; m++) { 
            int i= (int)(letrasYNums.length()* Math.random());
            crea.append(letrasYNums.charAt(i)); 
        } 
        cadena= crea.toString(); 
	}
	public String getContrasenia() {
		return this.cadena;
	}
	public String esFuerte(){
		int mayus=0;
		int minus=0;
		int nums=0;
        char[] chars = cadena.toCharArray();
        for (char ch : chars) {
            if (64<ch && ch<91) {
            	mayus++;
            } else if (96<ch && ch<123) {
            	minus++;
            }else {
            	nums++;
            }
	}
        if  (mayus>2 && minus>1 && nums>1) {
        	return "Fuerte";
        }else {
        	return "Debil";
        }
        		}
	public String hacerFuerte(){
		String letrasMay;
		String letrasMin;
		String letrasYNums;
		String nums;
        StringBuilder crea;
        if (longitud>6){
        letrasYNums = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"abcdefghijklmnopqrstuvwxyz"
                + "0123456789"; 
        letrasMay= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        letrasMin="abcdefghijklmnopqrstuvwxyz";
        nums="0123456789";
        crea = new StringBuilder(longitud); 
        crea.append(letrasMin.charAt((int)(letrasMin.length()* Math.random())));//dos minusculas
        crea.append(letrasMin.charAt((int)(letrasMin.length()* Math.random())));
        
        for(int i = 1; i < 4; i++) {
        crea.append(letrasMay.charAt((int)(letrasMay.length()* Math.random())));}//tres mayusculas
        
        crea.append(nums.charAt((int)(nums.length()* Math.random())));//dos numeros
        crea.append(nums.charAt((int)(nums.length()* Math.random())));
        for (int m = 0; m < longitud-7; m++) { 
            int i= (int)(letrasYNums.length()* Math.random());
            crea.append(letrasYNums.charAt(i)); 
        } 
        cadena= crea.toString(); 
        return "La contraseña ahora es fuerte";
	}else {
		return "La contraseña no se puede hacer fuerte ya que tiene menos de 7 caracteres";
	}
        }
}

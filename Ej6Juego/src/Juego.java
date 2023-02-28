/*Debemos resolver una pequeña parte de un juego donde cada jugador puede formar palabras,
 y cada palabra tendrá un  puntaje. Por el momento, el puntaje de una palabra va a estar dado por
  (a) la cantidad de letras de la palabra y (b) las letras k,z,x,y,w,q suman un punto más.
  El puntaje de cada jugador se determina en base a las palabras que pudo “formar”, pero para que
   esa palabra sea válida tiene que existir en un diccionario, el cual las valida. Se requiere poder
    agregar nuevas palabras a cada jugador, siempre y cuando éstas sean válidas. Finalmente, debo poder 
    obtener el puntaje total de cada jugador y poder determinar cual es el jugador con el puntaje más alto.

Objetivos:
Encontrar los objetos que participan del problema.
Definir asociaciones entre los objetos y comportamiento de cada uno.
Desarrollar una clase que cree 2 jugadores. Luego asignarles palabras a cada uno y finalmente determinar cuál es el ganador.*/
import java.util.ArrayList; 
public class Juego {
	private ArrayList<String> Jugadores = new ArrayList<String>();
	public String getGanador() {
		return "algo";
	}
}

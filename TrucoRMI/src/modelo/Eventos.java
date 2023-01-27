package modelo;

import java.io.Serializable;

public enum Eventos implements Serializable{
	JUEGO_COMENZADO,
	JUEGO_TERMINADO,
	SEGUIR_JUEGO,
	RONDA_TERMINADA,
	ESPERANDO_JUGADORES,
	MANO_TERMINADA,
	ENVIDO_JUGADO,
	PARDA;
	
}

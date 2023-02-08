package TDD;

import org.junit.Assert;
import org.junit.Test;

import modelo.Carta;
import modelo.Jugador;
import modelo.Palo;
import modelo.Ronda;

public class RondaTest {
	Jugador j1=new Jugador("lucas1");
	Jugador j2=new Jugador("lucas2");
	Ronda ronda=new Ronda();
	@Test
    public void testUnoEspadaYUnoCopaCualEsMayorEsJugador1()
    {	
		
		Carta cartaj1=new Carta(1,Palo.ESPADA);
		Carta cartaj2=new Carta(1,Palo.COPA);
		ronda.jugar(j1,cartaj1);
		ronda.jugar(j2,cartaj2);
        Assert.assertEquals(j1,
        		ronda.getGanador());
    }
	@Test
	public void testUnoCopaYTresCopaCualEsMayorEsJugador2()
    {	
		Carta cartaj1=new Carta(1,Palo.COPA);
		Carta cartaj2=new Carta(3,Palo.COPA);
		ronda.jugar(j1,cartaj1);
		ronda.jugar(j2,cartaj2);
        Assert.assertEquals(j2,
        		ronda.getGanador());
    }
	@Test
    public void testTresEspadaYTresCopaCualEsMayorEsNulo()
    {	
		Carta cartaj1=new Carta(3,Palo.ESPADA);
		Carta cartaj2=new Carta(3,Palo.COPA);
		ronda.jugar(j1,cartaj1);
		ronda.jugar(j2,cartaj2);
        Assert.assertEquals(null,
        		ronda.getGanador());
    }
	
}

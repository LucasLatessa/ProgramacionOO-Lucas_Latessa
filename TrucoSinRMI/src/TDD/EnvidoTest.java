package TDD;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import modelo.Carta;
import modelo.Envido;
import modelo.EstadoEnvido;
import modelo.Palo;
public class EnvidoTest {

	    @Test
	    public void testUnosDeDistintoPalo()
	    {
	        Assert.assertEquals(1,
	        		Envido.calcularTantos(
	                        new Carta(1, Palo.ESPADA),
	                        new Carta(1, Palo.BASTO),
	                        new Carta(1, Palo.COPA)));
	    }

	    @Test
	    public void testTresCartasDeDistintoPaloValenComoLaMasAlta()
	    {
	        Assert.assertEquals(7,
	        		Envido.calcularTantos(
	                        new Carta(7, Palo.ESPADA),
	                        new Carta(1, Palo.BASTO),
	                        new Carta(1, Palo.COPA)));
	    }

	    @Test
	    public void testFigurasValenCero()
	    {
	        Assert.assertEquals(0,
	        		Envido.calcularTantos(
	        				new Carta(10, Palo.ESPADA),
	                        new Carta(11, Palo.BASTO),
	                        new Carta(12, Palo.COPA)));;
	    }

	    @Test
	    public void testCalculoEntreDosCartasValenCero()
	    {
	        Assert.assertEquals(0,
	        		Envido.calcularEntreDos(
	                        new Carta(10, Palo.ESPADA),
	                        new Carta(11, Palo.BASTO)));
	    }

	    @Test
	    public void testCalculoEntreDosCartasDeDistintoPaloValenComoLaMasAlta()
	    {
	        Assert.assertEquals(6,
	        		Envido.calcularEntreDos(
	                        new Carta(6, Palo.ESPADA),
	                        new Carta(1, Palo.COPA)));
	    }

	    @Test
	    public void testCalculoEntreDosCartasDelMismoPaloSumanVeinte()
	    {
	        Assert.assertEquals(20,
	        		Envido.calcularEntreDos(
	                        new Carta(10, Palo.BASTO),
	                        new Carta(11, Palo.BASTO)));
	    }

	    @Test
	    public void testDosCartasDelMismoPaloSumanVeinte()
	    {
	        Assert.assertEquals(20,
	        		Envido.calcularTantos(
	                        new Carta(10, Palo.ESPADA),
	                        new Carta(11, Palo.ESPADA),
	                        new Carta(7, Palo.COPA)));
	    }
	    @Test
	    public void testEnvidoEnvidoRealEnvido() 
	    {Envido envido=new Envido();
	    	envido.addQuerido(EstadoEnvido.ENVIDO);
	    	envido.addQuerido(EstadoEnvido.ENVIDO);
	    	envido.addQuerido(EstadoEnvido.REALENVIDO);
	        Assert.assertEquals(7,
	        		envido.getPuntos());
	    }
	    @Test
	    public void testEnvidoEnvido() 
	    {Envido envido=new Envido();
	    	envido.addQuerido(EstadoEnvido.ENVIDO);
	    	envido.addQuerido(EstadoEnvido.ENVIDO);
	        Assert.assertEquals(4,
	        		envido.getPuntos());
	    }
	    @Test
	    public void testEnvidoEnvidoRealEnvidoFaltaEnvidoNQ() 
	    {Envido envido=new Envido();
		    envido.addQuerido(EstadoEnvido.ENVIDO);
	    	envido.addQuerido(EstadoEnvido.ENVIDO);
	    	envido.addQuerido(EstadoEnvido.FALTAENVIDO);
	        Assert.assertEquals(0,
	        		envido.getPuntos());
	    }
	
}

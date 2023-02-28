import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Executable;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class UtilidadesDeFechaTest {
	
	private Fecha utils;
	private Fecha utils1;
	
	@BeforeEach
	void before() {
		//this.utils = new UtilidadesDeFecha();
	}
	

	@Test
	void testDadoUnStringConFechaEnFormatoddMMyyyyDeberiaObtenerUnaInstanciaDeLocalDate() throws Exception{
		LocalDate fecha = Fecha.convertirAFecha(
				"05-02-2001", 
				FormatosdeFecha.DD_MM_YYYY);
		assertEquals(2001, fecha.getYear());
		assertEquals(Month.FEBRUARY, fecha.getMonth());
		assertEquals(5, fecha.getDayOfMonth());
	}
	
	@Test
	void testDadoUnStringConFechaEnFormatoMMddyyyyDeberiaObtenerUnaInstanciaDeLocalDate() throws Exception{		
		LocalDate fecha = Fecha.convertirAFecha(
				"03-10-1999", 
				FormatosdeFecha.MM_DD_YYYY);
		assertEquals(1999, fecha.getYear());
		assertEquals(Month.MARCH, fecha.getMonth());
		assertEquals(10, fecha.getDayOfMonth());
	}
	
	@Test
	void testDadoUnStringConUnaFechaNoValidaAlConvertirDeberiaGenerarUnaExcepcion(){
		assertThrows(Exception.class, () -> {
			Fecha.convertirAFecha(
					"03-10-19999", 
					FormatosdeFecha.MM_DD_YYYY);			
		});
	}
	@Test
	void testDadasDosFechasUnoEsMayorADos() throws Exception{
		Fecha.convertirAFecha("03-10-2002", FormatosdeFecha.MM_DD_YYYY);
		Fecha2.convertirAFecha("03-10-1999", FormatosdeFecha.MM_DD_YYYY);
		assertEquals(true, fecha.fechaMayorAOtra(fecha2));		
		
	}

}

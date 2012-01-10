package kontobuchungen;


import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestKontoBuchungen 
{
	private Konto konto;
	
	@Before
	public void setUp() throws Exception
	{
		konto = new Konto(12345);
		konto.einzahlen(1234.56, "Testbuchung 1");
		konto.auszahlen(456, "Testbuchung 2");
		konto.auszahlen(12.34, "Testbuchung 3");
		konto.einzahlen(14.34, "Testbuchung 4");
		konto.auszahlen(2, "Testbuchung 5");
		
	}
	
	@Test
	public void testBuchung()
	{
		Buchung b = new Buchung(100, "Test");
		assertEquals(100, b.getBetrag(), 1e-10);
		assertEquals("Test", b.getText());
		b = new Buchung(10, "");
		assertEquals("unbekannt", b.getText());
	}
	
	@Test
	public void testKonstruktor()
	{
		assertEquals(12345, konto.getNummer());
		Konto k = new Konto(-12345);
		assertEquals(0, k.getNummer());
	}
	
	@Test
	public void testEinzahlen()
	{
		assertEquals(778.56, konto.saldo(), 1e-10);
		konto.einzahlen(333.12, "Testbuchung 6");
		assertEquals(1111.68, konto.saldo(), 1e-10);
	}
	
	@Test
	public void testAuszahlen()
	{
		assertEquals(778.56, konto.saldo(), 1e-10);
		konto.auszahlen(0.51, "Testbuchung 6");
		assertEquals(778.05, konto.saldo(), 1e-10);
		konto.auszahlen(1000, "Testbuchung 7");
		assertEquals(778.05, konto.saldo(), 1e-10);
	}
	
	@Test
	public void testAuszug()
	{
		konto.auszug();
	}
	
	@Test
	public void testSummeEin()
	{
		assertEquals(1248.90, konto.summeEin(), 1e-10);
	}
	
	@Test
	public void testMaxAus()
	{
		Buchung b = konto.maxAus();
		assertEquals("Testbuchung 2", b.getText());
		assertEquals(-456, b.getBetrag(), 1e-10);
	}
	
	@Test
	public void testStornieren()
	{
		konto.stornieren(2);
		assertEquals(1234.56, konto.saldo(), 1e-10);
	}

	@Test
	public void testAnzahl()
	{
		assertEquals(5, konto.anzahl());
	}
}

package playlist;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayListTest
{
	private PlayList list;

	@Before
	public void setUp() throws Exception
	{
		list = new PlayList("my songs");
		Song s = new Song("Song 1");
		s.setDauer(1000);
		s.setGroesse(150);
		list.einfuegen(s);
		s = new Song("Song 2");
		s.setDauer(200);
		s.setGroesse(50);
		list.einfuegen(s);
		s = new Song("Song 3");
		s.setDauer(3000);
		s.setGroesse(450);
		list.einfuegen(s);
	}
	
	@Test
	public void testMp3()
	{
		Song s = new Song("My Song");
		assertEquals("My Song", s.getTitel());
		assertEquals(600, s.getDauer());
		assertEquals(100, s.getGroesse());
		s = new Song("");
		assertEquals("unbekannt", s.getTitel());
		s.setDauer(100);
		assertEquals(100, s.getDauer());
		s.setDauer(-100);
		assertEquals(100, s.getDauer());
		s.setGroesse(100);
		assertEquals(100, s.getGroesse());
		s.setGroesse(-100);
		assertEquals(100, s.getGroesse());
	}
	
	@Test
	public void testKonstruktor()
	{
		PlayList l = new PlayList("songs");
		assertEquals("songs", l.getBezeichnung());
		l = new PlayList("");
		assertEquals("unbekannt", l.getBezeichnung());
	}
	
	@Test
	public void testEinfuegen()
	{
		assertEquals(4200, list.gesamtDauer());
		Song s = new Song("Song 4");
		s.setDauer(100);
		s.setGroesse(50);
		list.einfuegen(s);
		assertEquals(4300, list.gesamtDauer());
		s = new Song("Song 4");
		s.setGroesse(1);
		s.setGroesse(1);
		list.einfuegen(s);
		assertEquals(4300, list.gesamtDauer());
		s = new Song("Song 5");
		s.setGroesse(1000);
		s.setGroesse(1000);
		list.einfuegen(s);
		assertEquals(4300, list.gesamtDauer());
		
	}
	
	@Test
	public void testLoeschen()
	{
		assertEquals(4200, list.gesamtDauer());
		list.loeschen(-1);
		list.loeschen(5);
		list.loeschen(1);
		assertEquals(4000, list.gesamtDauer());		
	}
	
	@Test
	public void testListe()
	{
		list.liste();
	}
	
	@Test
	public void testSuchen()
	{
		Song s = list.suchen("Song 2");
		assertEquals("Song 2", s.getTitel());
		assertEquals(50, s.getGroesse());
		assertEquals(200, s.getDauer());
		s = list.suchen("nicht vorhanden");
		assertNull(s);
	}
	
	@Test
	public void testLaenger()
	{
		assertEquals(2, list.laengerAls(500));
	}
	
}

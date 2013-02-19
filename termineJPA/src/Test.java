import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import data.Kalender;
import data.Termin;


public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		EntityManager em = Persistence.createEntityManagerFactory("termineJPA").createEntityManager();
		
		em.getTransaction().begin();
		
		Kalender k = new Kalender();
		k.setKName("Huber");
		em.persist(k);
		
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		
		Termin t = new Termin();
		t.setTVon(new Timestamp(new Date().getTime()));
		t.setTBis(new Timestamp(new Date().getTime()));
		t.setTText("Termin1");
		k.getTermine().add(t);
		
		
		em.getTransaction().commit();
		
		int id = k.getKId();
		
		
		Kalender k1 = em.find(Kalender.class, id);
		
		System.out.println(k1.getTermine().size());
		
		
		Query q = em.createQuery("SELECT k FROM Kalender k");
		
		List<Kalender> liste = q.getResultList();
		
		for (Kalender kx : liste)
		{
			System.out.println("Name=" + kx.getKName() + " Termine: " + kx.getTermine().size());
			
		}
		
		
		
		

	}

}

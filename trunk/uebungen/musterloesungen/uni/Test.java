package uni;


/**
 * Bei so einer Aufgabenstellung zahlt es sich auf jeden Fall aus, 
 * eine Testklasse zu erstellen
 * 
 * @author Rudolf Radlbauer
 *
 */
public class Test
{
    public void test()
    {
        Student s = new Student("Max");
        s.inskribieren("Mathe");
        s.inskribieren("Deutsch");
        s.inskribieren("Englisch");
        s.inskribieren("Französisch");
        
        Pruefung p;
        
        p = new Pruefung("Mathe");
        p.setNote(3);
        s.add(p);
        
        p = new Pruefung("Mathe");
        p.setNote(4);
        s.add(p);
        
        p = new Pruefung("Mathe");
        p.setNote(4);
        s.add(p);
        
        p = new Pruefung("Englisch");
        p.setNote(1);
        s.add(p);
        
        p = new Pruefung("Deutsch");
        p.setNote(1);
        s.add(p);
        
        p = new Pruefung("Deutsch");
        p.setNote(2);
        s.add(p);
        
        p = new Pruefung("Deutsch");
        p.setNote(3);
        s.add(p);
        
        p = new Pruefung("Deutsch");
        p.setNote(3);
        s.add(p);
        
        s.notenListe();
        System.out.println("Durchschnitt: " + s.berechneDurchschnitt());
        System.out.println("bestanden: " + s.bestanden());
        
        

    }

}

package millionenshow;
/**
 * zum Testen .
 * 
 * @author (Rudolf Radlbauer) 
 */

public class Test
{
    public Quiz test()
    {
        Frage f1 = new Frage("Welcher Tag ist heute");
        f1.addAntwort("Montag");
        f1.addAntwort("Dienstag");
        f1.addAntwort("Mittwoch");
        f1.addAntwort("Donnerstag");
        f1.setRichtig(3);
  
        Frage f2 = new Frage("Welchen Test haben wir heute?");
        f2.addAntwort("Programmieren");
        f2.addAntwort("GDV");
        f2.addAntwort("Englisch");
        f2.addAntwort("Deutsch");
        f2.setRichtig(2);
  
        Frage f3 = new Frage("Wer ist Klassensprecher/in?");
        f3.addAntwort("Chuck Norris");
        f3.addAntwort("Arnold Schwarzenegger");
        f3.addAntwort("Natalie Jandrasits");
        f3.addAntwort("Mac Guyver");
        f3.setRichtig(3);
  
        Frage f4 = new Frage("In welcher Schule befinden wir uns?");
        f4.addAntwort("Baumschule");
        f4.addAntwort("Volksschule");
        f4.addAntwort("Uni");
        f4.addAntwort("HTL");
        f4.setRichtig(4);
        
        Quiz q = new Quiz();
        q.add(f1);
        q.add(f2);
        q.add(f3);
        q.add(f4);
  
        q.interaktiv();
        
        return q;
        
       
    }
  
 
}

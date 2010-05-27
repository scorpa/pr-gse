/*
 * Created on 10.03.2009
 *
 */
package rechenquiz;

public class Test
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        RechenQuiz quiz = new RechenQuiz();
        quiz.add(new Addition());
        quiz.add(new Subtraktion());
        quiz.add(new Multiplikation());
        
        Rechnung r = quiz.naechste();
        while (r != null)
        {
            r.tippen(Input.readInt(r.toString()));
            r = quiz.naechste();
        }
        
        System.out.println(quiz);
        System.out.println("Gesamtpunkte: " + quiz.gesamtPunkte());

    }

}

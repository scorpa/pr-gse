package web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import quiz.Frage;
import quiz.Quiz;

/**
 * TagHandler fuer die Ausgabe des Fragen-Textes oder der Antwortmoeglichkeiten
 *
 * Sowohl Quiz-Instanz als auch die aktuelle Frage-Instanz sind in der Session abgelegt.
 *
 * @author Rudolf Radlbauer
 */
public class FrageAusgabe extends TagSupport
{
    private String feld;    // frage oder antwort
    private int index;      // index der Antwort

    public String getFeld()
    {
        return feld;
    }

    public void setFeld(String feld)
    {
        this.feld = feld;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }



    @Override
    public int doStartTag() throws JspException
    {
        HttpSession session = pageContext.getSession();
        try
        {
            
            Quiz quiz = (Quiz) session.getAttribute("quiz");
            if (quiz == null)
            {
                // Falls noch keine Quiz-Instanz an der Session hängt,
                // wird eine erzeugt und angehängt.
                quiz = new Quiz();
                session.setAttribute("quiz", quiz);
                // erste Frage
                session.setAttribute("frage", quiz.next());
            }
            
            // rufe die aktuelle Frage ab
            Frage f = (Frage) session.getAttribute("frage");
            if ("text".equals(feld))
            {
                // Fragen-Text
                pageContext.getOut().print(f.getText());
            }
            else if ("antwort".equals(feld))
            {
                // Antwortmöglichkeit
                pageContext.getOut().print(f.getAntwort(index));
            }
            return SKIP_BODY;
        } catch (Exception ex)
        {
            Logger.getLogger(FrageAusgabe.class.getName()).log(Level.SEVERE, null, ex);
            throw new JspException(ex);
        }
    }




}

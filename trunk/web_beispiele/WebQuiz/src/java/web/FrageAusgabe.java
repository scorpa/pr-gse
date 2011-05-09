package web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import quiz.Frage;
import quiz.Quiz;

public class FrageAusgabe extends TagSupport
{
    private String feld;
    private int index;

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
                quiz = new Quiz();
                session.setAttribute("quiz", quiz);
                session.setAttribute("frage", quiz.next());
            }
            

            Frage f = (Frage) session.getAttribute("frage");
            if ("text".equals(feld))
            {
                pageContext.getOut().print(f.getText());
            }
            else if ("antwort".equals(feld))
            {
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

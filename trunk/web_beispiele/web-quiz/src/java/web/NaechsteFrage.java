package web;

import fachlogik.Frage;
import fachlogik.QuizData;
import fachlogik.QuizException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import persistenz.DBQuizData;

/**
 *
 * @author Rudolf Radlbauer
 */
public class NaechsteFrage extends TagSupport
{
    private QuizData db;

    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            if (db == null)
                db = new DBQuizData();
            
            Iterator<Frage> iterator = (Iterator<Frage>) pageContext.getSession().getAttribute("iterator");
            if (iterator == null)
                iterator = db.fragen().iterator();
            pageContext.getSession().setAttribute("iterator", iterator);
            if (iterator.hasNext())
                pageContext.getSession().setAttribute("frage", iterator.next());
            else
                pageContext.getSession().setAttribute("frage", null);

            return SKIP_BODY;
        } catch (QuizException ex)
        {
            ex.printStackTrace();
            throw new JspException(ex);
        }
    }



}

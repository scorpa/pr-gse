package web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import persistence.Abstimmung;
import persistence.AbstimmungException;
import persistence.Statistik;

public class StatistikTag extends TagSupport
{
    private Abstimmung abstimmung;
    private String typ;

    public StatistikTag()
    {
        try
        {
            abstimmung = new Abstimmung();
        } catch (AbstimmungException ex)
        {
            Logger.getLogger(StatistikTag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            Statistik statistik = abstimmung.statistik();
            if ("prozent".equals(typ))
                pageContext.getOut().print(statistik.zustimmungProzent());
            if ("ja".equals(typ))
                pageContext.getOut().print(statistik.getJa());
            if ("nein".equals(typ))
                pageContext.getOut().print(statistik.getNein());
            return SKIP_BODY;
        } catch (Exception ex)
        {
            ex.printStackTrace();
            throw new JspException(ex);
        }
    }

    public void setTyp(String typ)
    {
        this.typ = typ;
    }



}

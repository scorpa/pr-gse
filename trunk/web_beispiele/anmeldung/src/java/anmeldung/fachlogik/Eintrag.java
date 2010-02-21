
package anmeldung.fachlogik;

import java.util.Date;

/**
 *
 * @author Rudolf Radlbauer
 */
public class Eintrag
{
    private String email;
    private Date zeitpunkt;
    private boolean zusage;

    public Eintrag(String email, boolean zusage)
    {
        this.email = email;
        this.zusage = zusage;
        zeitpunkt = new Date();
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Date getZeitpunkt()
    {
        return zeitpunkt;
    }

    public void setZeitpunkt(Date zeitpunkt)
    {
        this.zeitpunkt = zeitpunkt;
    }

    public boolean isZusage()
    {
        return zusage;
    }

    public void setZusage(boolean zusage)
    {
        this.zusage = zusage;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder(super.toString());
        str.append(" email=").append(email);
        str.append(" zusage=").append(zusage);
        str.append(" zeitpunkt=").append(zeitpunkt);
        return str.toString();
    }

    

}

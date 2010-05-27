package bibliothekUI;

/*
 * Created on 16.11.2008
 *
 */
 

/**
 * 
 * @author Rudolf Radlbauer
 *
 */
public class Buch
{
    private String isbn;
    private String autor;
    private String titel;
    private String verlag;
    private int seiten;
    private String kunde;
    
    public Buch(String isbn)
    {
        if (isbn != null && isbn.length() > 0)
            this.isbn = isbn;
        else
        {
            System.out.println("ungültige ISBN-Nummer");
            isbn = "12345";
        }
    }

    public String getAutor()
    {
        return autor;
    }

    public void setAutor(String autor)
    {
        if (autor != null && autor.length() > 0)
            this.autor = autor;
        else
            System.out.println("ungültiger Autor");
    }

    public int getSeiten()
    {
        return seiten;
    }

    public void setSeiten(int seiten)
    {
        if (seiten > 0)
            this.seiten = seiten;
        else
            System.out.println("ungültige Seitenanzahl");
    }

    public String getTitel()
    {
        return titel;
    }

    public void setTitel(String titel)
    {
        if (titel != null && titel.length() > 0)
            this.titel = titel;
        else
            System.out.println("ungültiger Titel");
    }

    public String getVerlag()
    {
        return verlag;
    }

    public void setVerlag(String verlag)
    {
        if (verlag != null && verlag.length() > 0)
            this.verlag = verlag;
        else
            System.out.println("ungültiger Verlag");

    }

    public String getIsbn()
    {
        return isbn;
    }

    public String getKunde()
    {
        return kunde;
    }
    
    public boolean entlehnen(String kunde)
    {
        if (this.kunde != null)
        {
            System.out.println("Buch ist bereits entlehnt");
            return false;
        }
        if (kunde != null && kunde.length() > 0)
        {
            this.kunde = kunde;
            return true;
        }
        else
        {
            System.out.println("ungültiger kunde");
            return false;
        }
    }
    
    
    public void retour()
    {
        this.kunde = null;
    }
    

}

package textanalyzer1;

/**
 * Diese Klasse beinhaltet nur einen Teil der Aufgabenstellung!
 * 
 * @author Rudolf Radlbauer
 *
 */
public class TextAnalyzer
{
    private String text;
    
    public TextAnalyzer(String text)
    {
        this.text = text;
    }
    
    public boolean isNumber()
    {
        Character helper = new Character(' ');
        if (text.length() == 0)
            return false;
        char beginn = text.charAt(0);
        if ((beginn != '+') && (beginn != '-') 
            && (!helper.isDigit(beginn)))
                return false;
                
        int index = 1;
        int anzahlPunkte = 0;
        while (index < text.length())
        {
            char zeichen = text.charAt(index);
            if (!istZiffer(zeichen) && zeichen != '.')
                return false;
            if (zeichen == '.')
                anzahlPunkte++;    
            if (anzahlPunkte > 1)
                return false;

            index++;
        }
                
                
                
        return true;
    }
    
    private boolean istZiffer(char zeichen)
    {
        return (zeichen >= '0' && zeichen <= '9');
    }
    
}

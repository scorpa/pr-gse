package reversi;

public class ReversiTestImpl implements Reversi
{
    private char[][] feld = new char[8][8];
    private char next = 'r';
    
    public ReversiTestImpl()
    {
        for (int i = 0; i < feld.length; i++)
            for (int j = 0; j < feld[0].length; j++)
                feld[i][j] = ' ';
    }
    
    
    public char get(int x, int y)
    {
        return feld[x][y];
    }

    public void next(char farbe)
    {
        next = farbe;        
    }

    public char next()
    {
        return next;
    }

    public boolean set(int x, int y)
    {
        System.out.println("x=" + x + " y=" + y + " farbe=" + next );
        if (feld[x][y] != ' ')
            return false;
        feld[x][y] = next;
        if (next == 'r')
            next = 'g';
        else
            next = 'r';
        return true;
    }

    public void set(int x, int y, char farbe)
    {
        feld[x][y] = farbe;        
    }



}

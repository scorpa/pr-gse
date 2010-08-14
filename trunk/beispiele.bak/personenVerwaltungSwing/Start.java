package personenVerwaltungSwing;

import javax.swing.JFrame;

public class Start
{
    public static void main(String[] args)
    {
        PersonenVerwaltungsFenster fenster =
                new PersonenVerwaltungsFenster();

        fenster.setSize(600, 400);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setVisible(true);
    }

}

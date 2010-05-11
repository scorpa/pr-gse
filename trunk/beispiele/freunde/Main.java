package freunde;

import javax.swing.JFrame;

/**
 *
 * @author Rudi
 */
public class Main {

    public static void main(String[] args) {
        HauptFenster fenster = new HauptFenster();
        fenster.pack();
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setVisible(true);
    }

}

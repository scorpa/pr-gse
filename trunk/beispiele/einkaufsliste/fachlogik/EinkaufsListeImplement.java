
package einkaufsliste.fachlogik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Rudolf Radlbauer
 */
public class EinkaufsListeImplement implements EinkaufsListe
{
    private List<Position> positionen;

    public EinkaufsListeImplement()
    {
        positionen = new ArrayList<Position>();
    }

    public void aufnehmen(Produkt p, int anzahl) throws EinkaufsListeException
    {
        Position position = null;
        for (Position pos : positionen)
            if (pos.getProdukt() == p)
                position = pos;
        if (position == null)
        {
            position = new Position(p, anzahl);
            positionen.add(position);
        }
        else
        	position.setAnzahl(position.getAnzahl() + anzahl);

    }

    public void entfernen(Produkt p) throws EinkaufsListeException
    {
        Position position = null;
        for (Position pos : positionen)
        {
            if (pos.getProdukt() == p)
            {
                position = pos;
                break;
            }
        }
        if (position != null)
            positionen.remove(position);
        else
            throw new EinkaufsListeException("dieses Produkt ist nicht vorhanden");
    }

    public List<Produkt> liste()
    {
        List<Produkt> liste = new ArrayList<Produkt>();
        for (Position pos : positionen)
            liste.add(pos.getProdukt());
        return liste;
    }

    public int getAnzahl(Produkt p)
    {
        for (Position pos : positionen)
            if (pos.getProdukt() == p)
                return pos.getAnzahl();
        return 0;
    }

    public void sortieren(KRITERIUM k)
    {
        Collections.sort(positionen, new PositionsComparator(k));
    }

    public float gesamtPreis()
    {
        float summe = 0;
        for (Position pos : positionen)
            summe += pos.berechnePreis();
        return summe;
    }

    public float co2()
    {
        throw new UnsupportedOperationException("Berechnung der CO2-Belastung noch nicht definiert");
    }

    public int anzahlBio()
    {
        int summe = 0;
        for (Position pos : positionen)
            if (pos.getProdukt().isBio())
                summe += pos.getAnzahl();
        return summe;
    }

    public int anzahlProdukte()
    {
        int summe = 0;
        for (Position pos : positionen)
            summe += pos.getAnzahl();
        return summe;
    }

    public void setAnzahl(Produkt p, int anzahl) throws EinkaufsListeException
    {
        for (Position pos : positionen)
            if (pos.getProdukt() == p)
                pos.setAnzahl(anzahl);
    }

    /**
     * innere Klasse, mit der jeweils 1 Produkt mit der Anzahl zu einer Position
     * zusammengefasst wird
     */
    private class Position
    {
        private Produkt produkt;
        private int anzahl;

        public Position(Produkt produkt, int anzahl) throws EinkaufsListeException
        {
            this.produkt = produkt;
            setAnzahl(anzahl);
        }

        public float berechnePreis()
        {
            return anzahl * produkt.getPreis();
        }

        public int getAnzahl()
        {
            return anzahl;
        }

        public void setAnzahl(int anzahl) throws EinkaufsListeException
        {
            if (anzahl > 0)
                this.anzahl = anzahl;
            else
                throw new EinkaufsListeException("nur positive Anzahl erlaubt");
        }

        public Produkt getProdukt()
        {
            return produkt;
        }
    }

    /**
     * innere Klasse, um Positionen zu sortieren
     */
    private class PositionsComparator implements Comparator<Position>
    {
        private KRITERIUM kriterium;

        public PositionsComparator(KRITERIUM kriterium)
        {
            this.kriterium = kriterium;
        }



        public int compare(Position p1, Position p2)
        {
            switch(kriterium)
            {
                case BEZEICHNUNG:
                    return p1.getProdukt().getBezeichnung().compareToIgnoreCase(p2.getProdukt().getBezeichnung());

                case HERKUNFT:
                    return p1.getProdukt().getHerkunft().toString().compareToIgnoreCase(p2.getProdukt().getHerkunft().toString());

                case PREIS:
                    return (int)((p1.getProdukt().getPreis() - p2.getProdukt().getPreis())*100);

                case BIO:
                    if (p1.getProdukt().isBio() == p2.getProdukt().isBio())
                        return 0;
                    if (p1.getProdukt().isBio())
                        return 1;
                    return -1;

                case ANZAHL:
                    return p1.getAnzahl() - p2.getAnzahl();
            }
            return 0;
        }

    }

}

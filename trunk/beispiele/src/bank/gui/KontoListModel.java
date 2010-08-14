/*
 * Created on 17.03.2006
 *
 */
package bank.gui;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import bank.fachlogik.Konto;
import bank.fachlogik.KontoVerwaltung;
import bank.fachlogik.KontoVerwaltungException;

/**
 * Decorator-Klasse ist gleichzeitig ein ListModel und eine KontoVerwaltung
 * (Stattet eine KontoVerwaltung mit den zusätzlichen Eigenschaften eines
 * ListModels aus.)
 * 
 * @author Rudolf Radlbauer
 */
public class KontoListModel implements ListModel, KontoVerwaltung
{
    private DefaultListModel model; // Referenz auf verwendetes ListModel
    private KontoVerwaltung verwaltung; // Referenz auf darunterliegende KontoVerwaltung
    private String filter;  // filter für Auswahl der Konten (Beginn des Besitzer-Namens)
    						// null -> kein Konto, "" -> alle Konten

    // KontoVerwaltung

    /**
     * Konstruktor befüllt das DefaultListModel mit den Daten aus der
     * KontoVerwaltung
     * 
     * @param verwaltung
     *            Referenz auf zu verwendende KontoVerwaltung-Instanz
     * @throws KontoVerwaltungException
     *             kann beim Aulesen der Daten aus der KontoVerwaltung auftreten
     * @throws IllegalArgumentException
     *             falls Parameter null ist
     */
    public KontoListModel(KontoVerwaltung verwaltung)
            throws KontoVerwaltungException, IllegalArgumentException
    {
        if (verwaltung == null)
            throw new IllegalArgumentException(
                    "Kontoverwaltung nicht gültig: null");
        this.verwaltung = verwaltung;
        model = new DefaultListModel();
        filter = null;
        befuellen(filter);
    }
    
    
    /**
     * Befüllt das Model mit Konten
     * @param filter Dient zur Auswahl der Konten (führt zum Aufruf der entsprechenden get-Methode<br/>
     * 					in der Verwaltung: filter steht für den Beginn des Namens des Besitzers.<br/>
     * 					null -> kein Konto ausgewählt, "" -> alle Konten ausgewählt
     * @throws KontoVerwaltungException
     */
    public void befuellen(String filter) throws KontoVerwaltungException
    {
        this.filter = filter;
        model.clear();
        if (filter != null)
        {
            if (filter.length() == 0)
                for (Konto k : verwaltung.getListe())
                    model.addElement(k);
            else
                for (Konto k : verwaltung.get(filter))
                    model.addElement(k);
        }
    }


    /* (non-Javadoc)
     * @see javax.swing.ListModel#getSize()
     */
    public int getSize()
    {
        return model.getSize();
    }

    
    /* (non-Javadoc)
     * @see javax.swing.ListModel#getElementAt(int)
     */
    public Object getElementAt(int index)
    {
        return model.getElementAt(index);
    }

    /* (non-Javadoc)
     * @see javax.swing.ListModel#addListDataListener(javax.swing.event.ListDataListener)
     */
    public void addListDataListener(ListDataListener l)
    {
        model.addListDataListener(l);
    }

    /* (non-Javadoc)
     * @see javax.swing.ListModel#removeListDataListener(javax.swing.event.ListDataListener)
     */
    public void removeListDataListener(ListDataListener l)
    {
        model.removeListDataListener(l);
    }

    /* (non-Javadoc)
     * @see fachlogik.KontoVerwaltung#speichern(fachlogik.Konto)
     */
    public void speichern(Konto k) throws KontoVerwaltungException,
            IllegalStateException, IllegalArgumentException
    {
        verwaltung.speichern(k);
        if (filter != null && k.getBesitzer().toLowerCase().startsWith(filter.toLowerCase()))
        {
            if (!model.contains(k))
                model.addElement(k);
        }
    }

    /* (non-Javadoc)
     * @see fachlogik.KontoVerwaltung#entfernen(fachlogik.Konto)
     */
    public void entfernen(Konto k) throws KontoVerwaltungException,
            IllegalArgumentException
    {
        verwaltung.entfernen(k);
        model.removeElement(k);
    }

    /* (non-Javadoc)
     * @see fachlogik.KontoVerwaltung#getListe()
     */
    public List<Konto> getListe() throws KontoVerwaltungException
    {
        return verwaltung.getListe();
    }

    /* (non-Javadoc)
     * @see fachlogik.KontoVerwaltung#get(java.lang.String)
     */
    public List<Konto> get(String besitzerAnfang) throws KontoVerwaltungException
    {
        return verwaltung.get(besitzerAnfang); 
    }

    /* (non-Javadoc)
     * @see fachlogik.KontoVerwaltung#get(int)
     */
    public Konto get(int nummer) throws KontoVerwaltungException,
            IllegalArgumentException
    {
        return verwaltung.get(nummer);
    }

    /* (non-Javadoc)
     * @see fachlogik.KontoVerwaltung#erzeugeNummer()
     */
    public int erzeugeNummer() throws KontoVerwaltungException
    {
        return verwaltung.erzeugeNummer();
    }


    /* (non-Javadoc)
     * @see fachlogik.KontoVerwaltung#close()
     */
    public void close() throws KontoVerwaltungException
    {
        verwaltung.close();

    }

    /* (non-Javadoc)
     * @see fachlogik.KontoVerwaltung#beginTransaktion()
     */
    public void beginTransaktion() throws KontoVerwaltungException
    {
        verwaltung.beginTransaktion();
    }

    /* (non-Javadoc)
     * @see fachlogik.KontoVerwaltung#endTransaktion()
     */
    public void endTransaktion() throws KontoVerwaltungException
    {
        verwaltung.endTransaktion();
    }

    /* (non-Javadoc)
     * @see fachlogik.KontoVerwaltung#cancelTransaktion()
     */
    public void cancelTransaktion() throws KontoVerwaltungException
    {
        verwaltung.cancelTransaktion();
    }

}

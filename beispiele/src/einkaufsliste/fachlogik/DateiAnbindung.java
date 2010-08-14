package einkaufsliste.fachlogik;

import java.io.File;



/**
 *
 * @author Rudolf Radlbauer
 */
public interface DateiAnbindung
{
    public void speichern(ProduktVerwaltung produkte, File datei) throws EinkaufsListeException;
    public void speichern(EinkaufsListe liste, File datei) throws EinkaufsListeException;
    public ProduktVerwaltung ladeProdukte(File datei) throws EinkaufsListeException;
    public EinkaufsListe ladeEinkaufsliste(File datei) throws EinkaufsListeException;
}

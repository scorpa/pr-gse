# Tabelle mit Buchungen #

Im Folgenden ist ein System zum Abspeichern von Buchungen in einer Datenbank dargestellt.

Objekte der Klasse [Buchung](http://code.google.com/p/pr-gse/source/browse/trunk/uebungen/musterloesungen/src/buchungen/Buchung.java) repräsentieren Datensätze in der Datenbanktabelle BUCHUNGEN. (Diese Datenbanktabelle wird mit dem Script [buchungen.sql](http://code.google.com/p/pr-gse/source/browse/trunk/uebungen/musterloesungen/src/buchungen/buchungen.sql) angelegt.)

Das Interface [`BuchungDAO`](http://code.google.com/p/pr-gse/source/browse/trunk/uebungen/musterloesungen/src/buchungen/BuchungDAO.java) definiert einige Zugriffsmethoden auf die Datenbanktabelle BUCHUNGEN. Diese sollen in der Klasse `BuchungDAOImpl` implementiert werden. Erstellen Sie diese Klasse!

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/buchungen.jpg' />
</p>

Der Konstruktor der Klasse `BuchungDAOImpl` öffnet die Verbindung zur Datenbank, die Methode `close()` schließt sie wieder.

Die Methode `load()` liefert in einer Liste alle Buchungen aus der Datenbanktabelle.

Die Methode `update(…)` bekommt als Parameter eine Liste von `Buchung`-Instanzen. Für jede dieser Buchungen wird auf den entsprechenden Datensatz in der Datenbanktabelle ein UPDATE durchgeführt.

Als Rückgabewert wird eine Liste aller jener `Buchung`-Instanzen geliefert, für welche das UPDATE erfolgreich (der entsprechende Datensatz in der Tabelle vorhanden) war.

Jede Methode löst eine [DBException](http://code.google.com/p/pr-gse/source/browse/trunk/uebungen/musterloesungen/src/buchungen/DBException.java) aus, wenn bei einem Datenbankzugriff ein Fehler auftritt.


---


Die Klasse [Test](http://code.google.com/p/pr-gse/source/browse/trunk/uebungen/musterloesungen/src/buchungen/Test.java) enthält eine main(…)-Methode, welche bei richtig implementierter Klasse BuchungDAOImpl etwa folgende Ausgabe produziert:

```
Verbindung zur Datenbank hergestellt
Orginale Buchungen: 
buchungen.Buchung@e24e2a id=1 datum=01.02.09 00:00 text=Bareinzahlung betrag=120.0
buchungen.Buchung@d1e604 id=2 datum=02.02.09 00:00 text=Abhebung betrag=-10.5
buchungen.Buchung@54172f id=3 datum=03.02.09 00:00 text=Zinsen betrag=1.22
buchungen.Buchung@be2358 id=4 datum=01.02.09 00:00 text=Abbuchung betrag=-22.22
buchungen.Buchung@1027b4d id=5 datum=01.02.09 00:00 text=Überweisung betrag=1000.0
aktualisierte Buchungen:
buchungen.Buchung@e24e2a id=1 datum=01.02.09 00:00 text=Bareinzahlung betrag=120.0
buchungen.Buchung@d1e604 id=2 datum=02.02.09 00:00 text=Abhebung betrag=-10.5
buchungen.Buchung@54172f id=3 datum=03.02.09 00:00 text=Text2 betrag=1.22
buchungen.Buchung@be2358 id=4 datum=01.02.09 00:00 text=Text3 betrag=-22.22
buchungen.Buchung@1027b4d id=5 datum=01.02.09 00:00 text=Text4 betrag=1000.0
Verbindung geschlossen
```
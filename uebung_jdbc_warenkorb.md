# Warenkorb #

Eine Applikation für das Zusammenstellen von Warenkörben verwendet die folgende Datenbank-Tabelle:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/warenkorb_modell.png' />
</p>

Die Tabelle kann mit dem Script [warenkorb.sql](http://code.google.com/p/pr-gse/source/browse/trunk/uebungen/musterloesungen/src/warenkorb/warenkorb.sql) erzeugt werden (funktioniert mit MySQL).

Darauf aufbauend sind die beiden Klassen `Artikel` und `Warenkorb` entsprechend dem folgenden UML-Klassendiagramm zu implementieren:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/warenkorb_uml.jpg' />
</p>



Die Klasse `Artikel` ist eine einfache Datenhaltungsklasse (DTO) mit Attributen entsprechend den Spalten der Datenbanktabelle und zugehörigen `get`- und `set`-Methoden.

Die Klasse `Warenkorb` dient zum Zusammenstellen einer Liste von Artikeln.

  * Der Konstruktor bekommt als Parameter eine Referenz auf eine Datenbankverbindung (`java.sql.Connection`) und die Warenkorb-ID.

  * Die Methode `laden()` holt alle Datensätze mit der entsprechenden Warenkorb-ID aus der Datenbank, erstellt damit `Artikel`-Instanzen und fügt diese in die Liste ein.

  * Die Methode `speichern()` speichert alle in der Liste vorhandenen `Artikel` in der Datenbanktabelle. Achtung – `Artikel` können auch schon in der Datenbank als Datensatz vorhanden sein!

  * Die Methode `einfuegen(…)` fügt die übergebene `Artikel`-Instanz in die Liste ein (noch nicht in die Datenbanktabelle – das erfolgt beim `speichern()`).

  * Die Methode `loeschen(…)` löscht den übergebenen `Artikel` aus der Liste und auch aus der Datenbanktabelle.

  * Die Methode `getListe()` liefert eine Referenz auf die Liste (einfache `get`-Methode).

  * Die Methode `gesamtPreis()` liefert die Summe der Preise (multipliziert mit der Anzahl) aller in der Liste enthaltenen `Artikel`.

Erstellen Sie zusätzlich zu den beschriebenen Klassen eine weitere Klasse mit `main(…)`-Methode zum Testen aller Methoden der Klasse `Warenkorb`!
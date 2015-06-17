# Anrufstatistik #

Von einer Telefongesellschaft wird die Liste aller Anrufe für einen Anschluss in einer CSV-Datei (comma separated values) mit folgendem Aufbau ausgeliefert:

In jeder Zeile stehen die Daten für einen Anruf. Eine Zeile besteht aus mehreren Feldern, welche jeweils mit einem Strichpunkt (;) getrennt sind.

Die Zeilen sind folgendermaßen aufgebaut:

  * gerufene Telefonnummer (String)
  * Datum/Uhrzeit des Anrufes mit folgendem Format: TT.MM.JJJJ/hh:mm:ss
  * Dauer des Anrufes in Sekunden

Beispieldaten befinden sich [hier](http://pr-gse.googlecode.com/svn/wiki/uebungen/data/anrufe.csv).

Es soll ein Programm erstellt, welches eine solche Datei einliest und eine Anrufstatistik erstellt. Die Fachlogik besteht aus den folgenden Klassen `Anruf` und `AnrufStatistik`:

![http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/anrufstatistik_streams.jpg](http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/anrufstatistik_streams.jpg)

### Klasse Anruf ###

In einer Instanz der Klasse `Anruf` werden die Daten für einen Anruf verwaltet:
  * `nr`: angerufene Telefonnummer (nicht leer)
  * `dauer`: Anrufdauer in Sekunden (>0)
  * `zeit`: Datum und Uhrzeit des Anrufes
Der Konstruktor setzt Standardwerte für die Attribute (`nr`="", `dauer`=0, `zeit`=jetzt).
Zusätzlich gibt es noch folgende Methoden:

`getNetz()` liefert im Rückgabewert den Namen des Netzes (ermittelt aus dem Beginn der Nummer). Folgende Netze sind bekannt:
  * 0664... - "A1"
  * 0676... - "T-Mobile"
  * 0699... - "Orange"
  * 0650... - "Telering"
  * 0660... - "3"
Der Einfachheit halber werden alle anderen Nummern als Festnetznummern ("Festznetz") angenommen.

`getTarif()` liefert 'f' für Freizeit, falls der Anruf vor 08:00 oder nach 18:00 begonnen hat (Feiertage werden nicht berücksichtigt), ansonsten liefert die Methode 'g' für Geschäftszeit.

`berechneKosten()` liefert die Kosten des Anrufes, welche sich folgendermaßen berechnen:
| Geschäftszeit/Festnetz | € 0.09 pro angefangene Minute |
|:------------------------|:--------------------------------|
| Geschäftszeit/Mobiles Netz | € 0.12 pro angefangene Minute |
| Freizeit/Festnetz       | € 0.04 pro angefangene Minute |
| Freizeit/Mobiles Netz   | € 0.08 pro angefangene Minute |


### Klasse AnrufStatistik ###

In einer Instanz der Klasse `AnrufStatistik` werden `Anruf`-Instanzen verwaltet.

Der Konstruktor instanziiert die Liste.

Mit der Methode `add(...)` kann eine `Anruf`-Instanz hinzugefügt werden.

Die Methode `clear()` entfernt alle `Anruf`-Instanzen.

Die Methode `einlesen(...)` liest eine CSV-Datei wie oben beschrieben ein und fügt für jede eingelesene Zeile eine `Anruf`-Instanz in die Liste ein.

Die Methode `berechneGesamtKosten()` berechnet die Summe der Kosten aller Anrufe und liefert diese als Rückgabewert.

Die Methode `berechneKosten(...)` berechnet die Gesamtkosten für alle Anrufe zu einer bestimmten Nummer (Parameter) und liefert diese als Rückgabewert.

Die Methode `nummernListe()` liefert in einer Liste alle angerufenen Nummern, wobei jede Nummer nur einmal aufgelistet wird, unabhängig davon, wie oft sie angerufen wurde.

Die Methode `statistik(...)` liefert in einer Liste alle Anrufe zu der im Parameter übergebenen Nummer.

### GUI ###

Die grafische Oberfläche des Programms besitzt ein Hauptfenster, in welchem eine `JList` alle angerufenen Nummern auflistet (jede Nummer nur einmal, unabhängig davon wie oft sie angerufen wurde).

In einem `JLabel` werden die Gesamtkosten aller Anrufe ausgewiesen.

In einer `JTextArea` wird für die jeweils in der `JList` ausgewählte Nummer eine Statistik angezeigt: Es werden alle Anrufe zu dieser Nummer mit Datum/Uhrzeit und Dauer aufgelistet. Danach werden noch die Gesamtkosten aller Anrufe zu dieser Nummer ausgewiesen. Die `JTextArea` soll nicht editierbar sein.

Mit dem Menü "Datei - einlesen" wird ein `JFileChooser` angezeigt, mit welchem eine CSV-Datei wie oben beschrieben ausgewählt werden kann. Diese Datei wird dann eingelesen, und die Anrufstatistik wird aktualisiert.

Beim Beenden des Programms wird die Anrufstatistik serialisiert in eine Datei gespeichert. Beim nächsten Programmstart wird diese Datei deserialisiert und der Zustand wie beim Beenden des Programms wieder hergestellt.
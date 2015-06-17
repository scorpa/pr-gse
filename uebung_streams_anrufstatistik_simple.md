# Anrufstatistik #

Eine CSV-Datei, in welcher die Anrufe von einem Telefonanschluss aufgelistet sind, soll folgenden Aufbau haben:

Pro Anruf enthält die Datei eine Zeile.

Jede Zeile enthält zuerst die angerufene Telefonnummer, dann Datum/Uhrzeit des Anrufs im Format „TT.MM.JJJJ/SS:MM:SS“, dann die Dauer des Anrufes in Sekunden. Die einzelnen Felder sind durch das Zeichen „|“ getrennt:

```
233445566|12.05.2010/13:21:23|35
0680334455|12.05.2010/18:17:12|543
+497712345|13.05.2010/08:08:08|111
0664123456|13.05.2010/17:43:07|430
```

Für das Einlesen und Anzeigen der Anrufdaten werden die folgenden Java-Klassen verwendet:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/anrufe.jpg' />
</p>

Die Klasse `Anruf` enthält die Daten für einen Anruf und bietet `get`- und `set`-Methoden für den Zugriff darauf.

Im Interface `DateiAnbindung` sind die Methoden zum Lesen und Schreiben der Anrufe aus der / in die CSV-Datei definiert.

_(Diese Klassen sowie eine CSV-Datei nehmen Sie als Vorgabe aus der [Musterlösung](http://pr-gse.googlecode.com/svn/trunk/uebungen/musterloesungen/src/anrufe).)_


## Aufgabenstellung ##

### Aufgabe 1 ###

Implementieren Sie das Interface `DateiAnbindung` mit einer eigenen Klasse, so dass die vorgegebene CSV-Datei eingelesen und auch wieder geschrieben werden kann.

Die mit der Methode `schreiben(…)` erzeugte Datei muss wieder mit `lesen(…)` einzulesen sein.

Die Methode `lesen(…)` liefert als Rückgabewert eine Liste mit `Anruf`-Instanzen (`List<Anruf>`).

### Aufgabe 2 ###

Erstellen Sie die Fenster-Klasse `AnrufAnzeige`, welche im Konstruktor eine Liste von `Anruf`-Instanzen (`List<Anruf>`) übergeben bekommt und diese Anrufe dann folgendermaßen anzeigt:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/anrufanzeige.jpg' />
</p>

Bei Betätigen der Schaltfläche „-->“ werden die Daten des nächsten Anrufs aus der Liste angezeigt, bei Betätigen der Schaltfläche „<--“ werden die Daten des vorherigen Anrufs angezeigt.
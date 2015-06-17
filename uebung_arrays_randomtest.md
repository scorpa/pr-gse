# Test für Zufallszahlen-Generator #

Erstellen Sie eine Klasse `RandomTest`, mit der der Zufallszahlengenerator `Random` getestet werden kann:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/randomTester.jpg' />
</p>

  * Das Attribut `random` enthält eine Referenz auf eine Instanz von `Random`.
  * Das Attribut `zahlen` ist eine Referenz auf ein `int`-Array, in welchem gespeichert wird, wie oft welche Zahl in einer Serie von Zufallszahlen vorkommt.
  * Der Konstruktor bekommt im Parameter den Wertebereich übergeben: Es werden Zufallszahlen von 0 bis `groesse-1` getestet.
  * Bei Aufruf der Methode `test(...)` werden `anzahl` Zufallszahlen aus dem definierten Wertebereich erzeugt, und es wird im Array erfasst, welche Zahl wie oft erzeugt wurde.
  * Die Methode `clear` setzt alle Felder des Arrays auf `0` zurück.
  * Die Methode `strichListe()` gibt eine Strichliste auf der Konsole aus. Neben jeder Zahl werden so viele Striche ausgegeben wie oft diese Zahl generiert wurde. Beispiel:
```
  0: |||
  1: |
  2: |||||
  3: ||
  4: |||
  ...
```
  * Die Methode `mittelwert()` berechnet den Mittelwert aus der Verteilung wie oft die einzelnen Zahlen generiert wurden
  * Die Methode `stdAbweichung()` berechnet die [Standardabweichung](http://de.wikipedia.org/wiki/Standardabweichung) der Häufigkeitsverteilung.
  * Die Methode `maximum()` liefert die größte Häufigkeit zurück.
  * Die Methode `minimum()` liefert die kleinste Häufigkeit zurück.
  * Die Methode `haeufigsteZahl()` liefert die Zahl zurück, welche am häufigsten generiert wurde.
  * Die Methode `seltensteZahl()` liefert die Zahl zurück, welche am seltensten generiert wurde.
  * Die Methode `enthaelt(...)` liefert `true` zurück, wenn die übergebene Häufigkeit im Array enthalten ist.
  * Die Methode `histogramm()` liefert ein Array zurück, in welchem ein [Histogramm](http://de.wikipedia.org/wiki/Histogramm) (wie oft kommt welche Häufigkeit vor) enthalten ist.
  * Die Methode `histogrammAusgabe()` gibt das Histogramm in Form einer Strichliste (siehe oben) auf der Konsole aus.
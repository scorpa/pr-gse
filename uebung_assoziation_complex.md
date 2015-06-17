# Complex #

Erstellen Sie die folgende Klasse `Complex`:

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/complex.jpg' />
</p>



Eine Instanz der Klasse `Complex` repräsentiert eine komplexe Zahl. Der Realteil ist im Attribut `real`, der Imaginärteil im Attribut `imaginaer` gespeichert.

**Methoden**

Der Standardkonstruktor erzeugt die komplexe Zahl (0, 0). Der zweite Konstruktor übernimmt in den Parametern Real- und Imaginärteil.

Für Real- und Imaginärteil gibt es jeweils eine get-Methode.

`addieren(...)` erhält als Parameter eine andere Instanz von `Complex` (eine zweite komplexe Zahl). Diese wird zur aktuellen komplexen Zahl addiert, und das Ergebnis wird als Rückgabewert geliefert.

`subtrahieren(...)` erhält als Parameter eine andere Instanz von `Complex` (eine zweite komplexe Zahl). Diese wird von der aktuellen komplexen Zahl subtrahiert, und das Ergebnis wird als Rückgabewert geliefert.

`multiplizieren(...)` erhält als Parameter eine andere Instanz von `Complex` (eine zweite komplexe Zahl). Diese wird mit der aktuellen komplexen Zahl multipliziert, und das Ergebnis wird als Rückgabewert geliefert.

`dividieren(...)` erhält als Parameter eine andere Instanz von `Complex` (eine zweite komplexe Zahl). Die aktuelle komplexen Zahl wird durch die im Parameter übergebene dividiert, und das Ergebnis wird als Rückgabewert geliefert.

`absolut()` liefert im Rückgabewert den Absolutbetrag der komplexen Zahl.

_Eine Anleitung zum Rechnen mit komplexen Zahlen gibt es [hier](http://de.wikipedia.org/wiki/Komplexe_Zahlen#Rechnen_in_der_algebraischen_Form)._


---


_**Bemerkung:** Die Klasse ist so aufgebaut, dass eine Instanz von `Complex` unveränderlich ist; d.h. einmal erzeugt, können Real- und Imaginärteil nicht mehr verändert werden (vgl. Klasse String)_
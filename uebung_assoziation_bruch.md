# Bruchrechnen #

Erstellen Sie die folgende Klasse `Bruch`:

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/bruch.jpg' />
</p>

Eine Instanz der Klasse `Bruch` repräsentiert eine Bruchzahl. Der Zähler ist im Attribut `zaehler`, der Nenner im Attribut `nenner` gespeichert.

**Methoden**

Der Standardkonstruktor erzeugt den Bruch 1/1 (`zaehler` und `nenner` haben beide den Wert 1). Der zweite Konstruktor übernimmt in den Parametern Zähler und Nenner.

Für die Attribute `zaehler` und `nenner` gibt es jeweils eine `get`-Methode.

`addieren(...)` erhält als Parameter eine andere Instanz von `Bruch` (eine zweite Bruchzahl). Diese wird zur aktuellen Bruchzahl addiert, und das Ergebnis wird als Rückgabewert geliefert.

`subtrahieren(...)` erhält als Parameter eine andere Instanz von `Bruch` (eine zweite Bruchzahl). Diese wird von der aktuellen Bruchzahl  subtrahiert, und das Ergebnis wird als Rückgabewert geliefert.

`multiplizieren(...)` erhält als Parameter eine andere Instanz von `Bruch` (eine zweite Bruchzahl). Diese wird mit der aktuellen Bruchzahl multipliziert, und das Ergebnis wird als Rückgabewert geliefert.

`dividieren(...)` erhält als Parameter eine andere Instanz von `Bruch` (eine zweite Bruchzahl). Die aktuelle Bruchzahl wird durch die im Parameter übergebene dividiert, und das Ergebnis wird als Rückgabewert geliefert.

`dezimal()` liefert im Rückgabewert die Bruchzahl in Dezimalform.



---


_**Bemerkung:** Die Klasse ist so aufgebaut, dass eine Instanz von `Bruch` unveränderlich ist; d.h. einmal erzeugt, können die Attribute `zaehler` und `nenner` nicht mehr verändert werden (vgl. Klasse `String`)_
# Sensor #


Die folgende Klasse `Sensor` soll einen Sensor (z.B. für Temperatur-Messwerte) simulieren:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/Sensor.jpg' />
</p>

Der `Sensor` speichert die Messwerte in einem Array (Attribut `werte`). Maximal können 100 Messwerte gespeichert werden (zum Testen empfiehlt es sich, diese Zahl zuerst kleiner zu wählen).

Die Messwerte werden beginnend beim Index 0 ohne Zwischenräume im Array `werte` abgelegt.

Das Attribut `anzahl` gibt die Anzahl der gültigen Werte im Array an.

Die Attribute `minWert` und `maxWert` definieren den Wertebereich der Messwerte. Diese werden dem Konstruktor als Parameter übergeben. Es ist zu verifizieren, dass `minWert` kleiner als `maxWert` ist. Falls nicht, werden die beiden vertauscht.

Das Attribut `rnd` enthält eine Referenz auf ein Random-Objekt (für Methode `zufallsWerte()`).

### Methoden ###

Bei allen Methoden, welche neue Werte einfügen muss verifiziert werden, dass diese im definierten Wertebereich liegen. Bei allen Methoden, welche einen Index als Parameter bekommen muss überprüft werden ob der Index gültig ist. Andernfalls erfolgt eine Fehlermeldung.

  * `ausgeben()`: gibt alle Messwerte auf die Konsole aus.
  * `ausgebenGroesser(…)`: gibt alle Messwerte auf die Konsole aus, welche größer als der übergebene Parameter sind.
  * `neuerWert(…)`: fügt einen neuen Messwert hinten dazu. Falls das nicht mehr möglich ist, erfolgt eine Fehlermeldung.
  * `einfuegen(…)`: fügt einen neuen Messwert beim angegebenen Index ein. Falls das nicht mehr möglich ist, erfolgt eine Fehlermeldung.
  * `loeschen(int index)`: löscht den Messwert beim übergebenen Index (die dahinter liegenden Werte müssen dabei nach vorne rutschen).
  * `anzahlLoeschen(int n)`: löscht die ersten `n` Messwerte.
  * `vertauschen(…)`: vertauscht die Messwerte bei den übergebenen Indices.
  * `zufallsWerte(int anzahl)`: fügt `anzahl` Zufallswerte hinten an. Diese Zufallswerte müssen aus dem ganzen Wertebereich stammen.
  * `berechneDurchschnitt()`: liefert den Durchschnitt aller Messwerte als Rückgabewert.
  * `maximum()`: liefert den größten Messwert als Rückgabewert.
  * `maximumIndex()`: liefert den Index des größten Messwertes (erstes Vorkommen) als Rückgabewert.
  * `umdrehen()`: dreht die Reihenfolge aller Messwerte um.
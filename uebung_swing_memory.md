# Memory #

Es ist ein [Memory-Spiel](http://de.wikipedia.org/wiki/Memory_(Spiel)) zu implementieren.

Die Oberfläche soll ein Feld mit N x M Schaltflächen (Buttons) aufweisen. Diese sehen nach dem Start alle gleich aus. Klickt der Benutzer auf eine Schaltfläche, dann erscheint darauf ein Bild. Klickt er dann auf eine andere Schaltfläche, dann erscheint darauf ebenfalls ein Bild. Sind die Bilder gleich, dann bleiben diese sichtbar, falls nicht, dann verschwinden die Bilder beim nächsten Klick wieder.

Um eine schöne Schichtentrennung zwischen grafischer Oberfläche (GUI) und Logik zu erreichen, wird vorerst das Interfache `Memory` definiert:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/memory.jpg' />
</p>

Eine Instanz einer Klasse, welche das Interface `Memory` implementiert, muss folgende Methoden aufweisen:

  * `public int getZeilen()` liefert die Anzahl der Zeilen im Button-Feld zurück.

  * `public int getSpalten()` liefert die Anzahl der Spalten im Button-Feld zurück.

  * `public boolean tipp(int zeile, int spalte)` - diese Methode wird aufgerufen, wenn der Benutzer auf die Schaltfläche in der angegebenen Zeile und Spalte klickt. Die Methode liefert `true` zurück, wenn der Benutzer auf eine gültige Schaltfläche geklickt hat, ansonsten `false`.

  * `public int getStatus(int zeile, int spalte)` - diese Methode liefert den Status eines Feldes zurück:
```
    0: Feld ist noch verdeckt
    1: Feld ist aufgedeckt aber noch nicht erraten
    2: Feld wurde bereits erraten
```
  * `public ImageIcon getBild(int zeile, int spalte) - diese Methode liefert das Bild zurück, welches beim Feld in der gegebenen Zeile und Spalte angezeigt werden soll (Referenz auf ein `javax.swing.ImageIcon`-Objekt)

  * `public boolean fertig()` - liefert `true` zurück, wenn bereits alle Paare erraten wurden.

  * `public int tipps()` - liefert die Anzahl der Tipps zurück, welche seit Spielbeginn abgegeben wurden.


Das Interface `Memory` ist von einer konkreten Klasse zu implementieren.

Eine Instanz von `Memory` wird von der Klasse `MemoryGUI` verwendet, welche die Oberfläche des Spieles implementiert.


<u>Hinweis:</u>

[Hier](http://java.sun.com/docs/books/tutorial/uiswing/components/icon.html) ist beschrieben, wie man in Java mit Icons arbeitet.
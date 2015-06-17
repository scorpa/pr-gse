# Village (ein Dorf aus mehreren Häusern) #

Diese Übung baut wieder auf das Projekt _shapes_ auf, das bereits aus dem Thema [Objekte und Klassen](thema_objekte_und_klassen.md) bekannt ist.


_(Die Beispielprojekte können [hier](http://www.bluej.org/objects-first/resources/projects.zip) heruntergeladen werden.)_

Es sollen stufenweise aus den _shapes_ kompliziertere Gebilde aufgebaut werden, bis ein Dorf entsteht (oder auch mehrere Dörfer). Dazu sind die Klassen aus dem folgenden UML-Klassendiagramm zu erstellen:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/village.jpg' />
</p>

### House ###
Eine Instanz der Klasse `House` verwendet (wie schon im Beispielprojekt _picture_ ein `Square` namens `wall`, ein `Square` namens `window` und ein `Triangle` namens `roof`, um das Haus zusammenzusetzen.

Der Standardkonstruktor baut das Haus mit gelber Wand, rotem Dach und schwarzem Fenster auf.

Ein zweiter Konstruktor übernimmt eine Farbe (als String) als Parameter und baut das Haus mit rotem Dach, schwarzem Fenster und der Wand entsprechend der übergebenen Farbe auf.

Dem dritten Konstruktor kann man zusätzlich zur Farbe noch eine x-Position und eine y-Position übergeben. Hier muss man sich ein Koordinatensystem vorstellen, an dessen Ursprung die Häuser stehen, welche mit dem Standardkonstruktor erzeugt wurden. x- und y-Position sind dann die Abstände in x- bzw. y-Richtung von diesen Standardhäusern (Einheit: Bildpunkte).

Die Methoden `moveHorizontal(...)` und `moveVertical(...)` verschieben ein Haus in die entsprechende Richtung um die übergebene Anzahl von Punkten.

_(Erzeugt man also ein Haus mit dem Standardkonstruktor und bewegt es dann z.B. um 100 Punkte nach unten und um 300 Punkte nach rechts - `moveVertical(100)` und `moveHorizontal(300)` - , dann ist das Ergebnis das gleiche wie wenn man dem Haus im Konstruktor die x-Position 300 und die y-Position 100 übergibt)_

Die Methode `makeVisible()` macht das Haus sichtbar, die Methode `makeInvisible()` macht es unsichtbar.

Die Methode `night()` macht das Haus dunkel; d.h. die Mauer und das Dach werden schwarz und das Fenster wird gelb (drinnen brennt ein Licht).



### Village ###

Ein `Village` besteht aus bis zu 3 Häusern (`house1`, `house2`, `house3`). Es gibt 2 Möglichkeiten, ein Dorf zu erstellen:

Der Standardkonstruktor erstellt ein Dorf ohne Häuser. Diese müssen dann erst mit der Methode `add()` eingefügt werden.

Der zweite Konstruktor bekommt im Parameter die Anzahl der Häuser übergeben, die er gleich instanziieren soll (kann 0, 1, 2 oder 3 sein). Überlegen Sie sich selbst eine sinnvolle Anordnung und Farbkombination für diese Häuser.

Mit der Methode `add(...)` kann ein Haus in das Dorf eingefügt werden. Die Attribute `house1`, `house2`, `house3` werden in dieser Reihenfolge besetzt.

Die Methoden `makeVisible()`, `makeInvisible()`, `moveHorizontal(...)` und `moveVertical(...)` funktionieren analog wie in der Klasse `House`.

Die Methode `night()` macht das Dorf dunkel, d.h. alle Häuser des Dorfes werden dunkel.
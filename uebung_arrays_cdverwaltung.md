# CD-Verwaltung #

Erstellen Sie die folgenden Klassen für eine CD-Verwaltungs-Software:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/cdverwaltung.jpg' />
</p>

In einem Objekt der Klasse `Track`  werden die Dauer (in Sekunden) und der Titel gespeichert.

Der Standardkonstruktor setzt folgende Standardwerte: `titel` = "unbekannt", `dauer` = 100.

Dem zweiten Konstruktor werden Titel und Dauer als Parameter übergeben. Für beide Attribute gibt es eine `get`-Methode.

<br />

Eine `CD` hat einen Interpreten, einen Titel und eine fixe Anzahl von Tracks.

Die Anzahl der Tracks wird dem Konstruktor als Parameter übergeben. Dieser setzt folgende Standardwerte für die Attribute: `interpret` = "unbekannt", `titel` = "unbekannt". Das Array `tracks` wird in der Größe `anzahlTracks` angelegt und mit `Track`-Instanzen befüllt.

Die Methode `setTrack(…)` bekommt einen Index und eine `Track`-Referenz als Parameter. Nach der Überprüfung, ob der Index gültig ist, wird die `Track`-Referenz an der entsprechenden Stelle im Array gespeichert.

Die Methode `getTrack()` liefert die `Track`-Referenz beim übergebenen Index, falls dieser gültig ist, ansonsten liefert sie `null`.

Die Methode `print()` gibt den Interpreten und den Titel der `CD` auf die Konsole aus. Danach werden alle Tracks aufgelistet (jeweils Titel und Dauer).

Die Methode `gesamtDauer()` liefert die Summe der Dauer aller Tracks in Minuten (abgerundet).

Für Interpret und Titel gibt es jeweils eine `get`- und eine `set`-Methode.

<br />

Ein Objekt der Klasse `CDVerwaltung` speichert im Array `cds` Referenzen auf die verwalteten CDs lückenlos beginnend beim Index 0. Im Attribut `anzahl` ist die aktuelle Anzahl der verwalteten CDs gespeichert.

Der Konstruktor bekommt als Parameter die maximale Anzahl von CDs übergeben.

Mit der Methode `add(…)` wird eine `CD` in die Verwaltung aufgenommen, allerdings nur, wenn noch Platz ist und noch keine CD mit gleichem Titel und gleichem Interpreten vorhanden ist.

Die Methode `finden(…)` liefert eine Referenz auf die `CD` mit dem übergebenen Interpreten und Titel, falls diese vorhanden ist. Ansonsten wird `null` geliefert.

Die Methode `liste()` gibt alle CDs auf die Konsole aus: jeweils Interpret, Titel und Dauer in Minuten.

Die Methode `laengste()` liefert eine Referenz auf die `CD` mit der längsten Spieldauer.
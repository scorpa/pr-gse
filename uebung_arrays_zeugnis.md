# Zeugnis #

Erstellen Sie die folgenden Klassen `Zeugnis` und `Fach`:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/zeugnis.jpg' />
</p>




---


### Attribute ###
Jedes `Zeugnis` hat einen Namen (Schüler, für den das Zeugnis ausgestellt wurde) und ein Array von Fächern.

Jedes Fach hat ein Kürzel (z.B. "M" Für "Mathematik") und eine Note. Der Standardwert der Note ist 1.


---


### Methoden ###
Der Konstruktor der Klasse Fach übernimmt das Kürzel als Parameter. (Der Standardwert der Note wird auf 1 gesetzt.)

Die Klasse Fach hat `get`-Methoden für beide Attribute und eine `set`-Methode für die Note. Es muss sichergestellt werden, dass die Note nur Werte von 1 bis 5 annehmen kann.

Die Methode `ausgeben()` der Klasse `Fach` gibt das Kürzel und die Note auf die Konsole aus.


---


Der Konstruktor der Klasse `Zeugnis` übernimmt den Namen als Parameter. Im Array `faecher` werden die Fächer mit folgenden Kürzeln angelegt:
```
    M, E, D, GWK, BIO, BSP
```

Die Methode `zufall()` dient zum Generieren von Testdaten. Für jedes Fach im Array `faecher` wird eine zufällige Note von 1 bis 5 gesetzt.
_(Hierfür können Sie die Klasse `Random` aus dem Package `java.util` verwenden.)_

Mit der Methode `note(...)` kann man die Note für das Fach setzen, welches im Parameter `kuerzel` übergeben wird. Falls ein Kürzel übergeben wird, welches in der Fächerliste nicht vorkommt, wird eine Fehlermeldung ausgegeben.

Die Methode `ausgeben()` gibt das Zeugnis in folgender Form auf die Konsole aus:
```
======== Max Mustermann =========
M	4
E	2
D	4
GWK	4
BIO	3
BSP	3
```

Die Methode `notenSchnitt()` errechnet den Durchschnittswert aller Noten und liefert diesen als Rückgabewert.

Die Methode `bestesFach()` liefert eine Referenz auf das `Fach` mit der besten Note als Rückgabewert. _(Wenn mehrere Fächer gleich gut sind, wird das erste gefundene geliefert.)_

Die Methode `bestanden()` liefert `true`, falls keine Note den Wert 5 hat, ansonsten `false`.
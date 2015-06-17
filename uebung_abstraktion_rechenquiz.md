# Rechenquiz #

Bei einem Rechenquiz für Kinder sollen verschiedene Rechnungen der Grundrechnungsarten abgefragt und eine Punkteauswertung durchgeführt werden. Die dafür vorgesehene Software besteht im Wesentlichen aus folgenden Klassen:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/rechenquiz.jpg' />
</p>

### Klasse Rechnung ###

Die abstrakte Klasse `Rechnung` speichert die beiden Operanden einer Rechnung, definiert jedoch noch nicht, was damit gemacht werden soll. Das wird erst in den abgeleiteten Klassen implementiert; z.B. `Addition` --> die Operanden werden addiert. Die Operanden werden im Konstruktor mit Zufallszahlen zwischen 0 und 100 initialisiert. Im Konstruktor wird auch der Wert für das Attribut `punkte` als Parameter übernommen.

Der Benutzer kann einen Tipp abgeben (Methode `tippen(…)`). Der Tipp wird gespeichert und ist später für die Berechnung der Punkte wichtig (Methode `berechnePunkte(…)`). Für einen richtigen Tipp (stimmt mit dem Ergebnis der Rechnung überein) bekommt der Benutzer die im Attribut `punkte` angegebene Punktezahl (für einen falschen Tipp bekommt er 0 Punkte). Das Attribut `punkte` wird im Konstruktor der jeweiligen abgeleiteten Klasse initialisiert (an den Konstruktor der Basisklasse übergeben):  `Addition` --> 1 Punkt, `Subtraktion` --> 2 Punkte, `Multiplikation` --> 3 Punkte.

In jeder Abgeleiteten Klasse liefert die Methode `toString()` die jeweilige Rechnung als String (z.B. Addition: „13 + 25 =“).

Die Methode `getErgebnis()` liefert das richtige Ergebnis der Rechnung zurück. Sie ist in der Basisklasse abstrakt und wird erst in den abgeleiteten Klassen implementiert.

### Klasse RechenQuiz ###

Eine Instanz der Klasse `RechenQuiz` verwaltet die Rechnungen.

Mit der Methode `add(…)` wird eine neue Rechnung eingefügt.

Mit der Methode `naechste()` wird eine Referenz auf die nächste Rechnung geliefert oder `null`, falls keine nächste Rechnung exisitert (das Attribut `next` dient dazu, sich den Index der nächsten Rechnung zu merken).

Die Methode `gesamtPunkte()` berechnet die Summe aller Punkte aus allen Rechnungen.

Die Methode `toString()` liefert einen mehrzeiligen String, der eine Übersicht über alle Rechnungen enthält:
```
Rechnung		Ergebnis	Tipp		Punkte
===============================================================
20+23=			43		43		1
2*12=			24		24		3
17-5=			12		9		0
…
===============================================================
```


### Erweiterung ###

Erweitern Sie die oben beschriebenen Klassen wo es notwendig ist und erstellen Sie eine zeilenorientierte Benutzeroberfläche, die folgendermaßen funktioniert:

Nach dem Start des Programms kann der Benutzer eingeben, wie viele Rechnungen er haben will. Die entsprechende Anzahl von Rechnungen wird generiert, und zwar in zufälliger Reihenfolge Additionen, Subtraktionen und Multiplikationen.

Der Benutzer bekommt dann die Rechnungen nacheinander präsentiert und kann jeweils seinen Tipp eingeben.

Am Ende werden alle Rechnungen noch einmal in der oben dargestellten Form aufgelistet, und zum Schluss wird die Anzahl der Gesamtpunkte ausgegeben.

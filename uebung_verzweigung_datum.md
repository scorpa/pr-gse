# Datum #

Erstellen Sie die folgende Klasse `Datum`:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/Datum.jpg' />
</p>

In den Attributen wird der Tag, das Monat und das Jahr eines Datums gespeichert.

Es gibt einen Konstruktor, welcher das Standarddatum 1.1.1970 setzt.
Der andere Konstruktor übernimmt Tag, Monat und Jahr als Parameter.

Es gibt `get-` und `set-`Methoden für Tag, Monat und Jahr.

Die `print()`-Methode gibt das Datum aus.

Die Methode `morgen()` schaltet das Datum um 1 Tag weiter.

Die Methode `gestern()` schaltet das Datum um 1 Tag zurück.


Die Klasse soll so funktionieren, wie man es sich von einem richtigen Kalender erwartet.
Der Konstruktor und alle `set-`Methoden sollen in den Parametern nur gültige Werte übernehmen. Falls ungültige Werte übergeben werden, soll der Konstruktor das Standarddatum 1.1.1970 setzen, die `set-`Methoden sollen den vorherigen Wert unverändert lassen. Es soll jeweils eine entsprechende Fehlermeldung ausgegeben werden.



### Hinweise: ###

Falls Ihnen die Aufgabenstellung zu schwierig erscheint, beginnen Sie vorerst mit einer vereinfachten Version, welche für jeden Monat 30 Tagen annimmt. Sie können später die Klasse nach und nach verbessern.

### Schaltjahrberechnung: ###
Alle Jahre, die durch 4 teilbar sind stellen Schaltjahre dar. Ausgenommen von der Schaltjahresregelung sind volle Jahrhunderte, die durch 100, aber nicht durch 400 geteilt werden können.

Die Teilbarkeit einer Zahl a durch die Zahl b berechnet man mit der Modulo- (Rest-) Division:
> `if (a % b == 0)` testet, ob a durch b teilbar ist.
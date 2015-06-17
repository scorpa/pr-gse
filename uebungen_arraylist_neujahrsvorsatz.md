# Neujahrsvorsatz #

Wie so viele andere haben Sie sich als Neujahrsvorsatz genommen gesünder zu leben. Sie haben sich vorgenommen sich bewusster zu ernähren und mehr Sport zu betreiben. Um konsequent mehr Sport zu betreiben haben Sie sich vorgenommen beim Wien Marathon teilzunehmen und so oft als möglich dafür zu trainieren. Für spätere statistische Auswertungen wollen Sie die täglich zu sich genommenen Kalorienanzahl und die täglich gelaufenen Kilometer speichern.

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/neujahrsvorsatz.jpg' />
</p>

Eine Instanz der Klasse `Tagesaufzeichnung` dient dazu um für einen Tag die Kalorienanzahl und die gelaufenen Kilometer zu speichern. Das Datum, bestehend auf dem `tag` und dem `monat`, und den beiden `double` Werten `kalorienanzahl` und `gelaufeneKilometer` (werden im Konstruktor übergeben). Für jedes Attribut soll es eine `get`-Methode geben.

Instanzen der Klasse `Statistik` werden `Tagesaufzeichung`-Objekte zugewiesen, die in einer `java.util.ArrayList` gespeichert werden sollen. Aus den zuwiesenen Objekten können dann eventuell aufschlussreiche Kennzahlen ermittelt werden. Die Klasse `Statistik` soll folgende Methoden enthalten:

Die Methode `eintragHinzufuegen(…)` bekommt ein Datum, die Kalorienanzahl und die gelaufenen Kilometer übergeben, erzeugt darauf ein `Tagesaufzeichung`-Objekt und fügt es der `ArrayList` hinzu. Es soll geprüft werden ob in der `ArrayList` bereits ein Eintrag mit diesem Datum vorhanden ist. Falls dem so ist soll zunächst der bestehende Eintrag gelöscht werden.

Die Methode `existiertEintrag(…)` prüft ob für ein bestimmtes Datum bereits ein Eintrag in der `ArrayList` vorhanden ist.

Die Methode `eintragLoeschen(…)` löscht den `ArrayList`-Eintrag eines bestimmten Datums. Falls für diesen Datum kein Eintrag existiert soll die Meldung "Dieser Eintrag ist nicht vorhanden." ausgegeben werden.

Die Methode `eintraegeAusgeben(…)` gibt alle Einträge der `ArrayList` übersichtlich aus.

Die Methode `getKalorienDurchschnitt(…)` berechnet den Durchschnitt der erfassten Kalorienwerte. Falls bisher keine Werte erfasst wurden, soll 0 zurückgegeben werden.

Die Methode `getKalorienMinimum(…)` gibt das `Tagesaufzeichnung`-Objekt mit dem niedrigsten Kalorienwert zurück. Falls bisher keine Werte erfasst wurden, soll `null` zurückgegeben werden.

Die Methode `getKalorienMaximum(…)` gibt das `Tagesaufzeichnung`-Objekt mit dem höchsten Kalorienwert zurück. Falls bisher keine Werte erfasst wurden, soll `null` zurückgegeben werden.

Die Methode `anzahlTageOhneTraining()` gibt die Anzahl der Tage zurück an denen nicht trainiert wurde. Das sind einerseits jene Tag für die keine Eintragung erfolgt ist und andererseits jene für die eine Eintragung erfolgt ist und gelaufeneKilometer gleich 0 ist. Betrachtet wird dabei jener Zeitraum zwischen dem niedrigsten eingetragenem Datum und dem höchstem eingetragenem Datum.

Die Methode `anzahlTageMitTraining()` gibt die Anzahl der Tage zurück an denen trainiert wurde.

Die Methode `tagesaufzeichnungMitFruehestemDatum()` gibt das `Tagesaufzeichnung`-Objekt der `ArrayList` mit dem niedrigstem Datum zurück.

Die Methode `tagesaufzeichnungMitSpaetestemDatum()` gibt das `Tagesaufzeichnung`-Objekt der ArrayList mit dem höchstem Datum zurück.

Die Methode `istFrueher(…)` gibt für zwei Datümer `true` zürck falls das erste vor dem zweiten liegt, sonst `false`.

Die Methode `tageDifferenz(…)` gibt für zwei Datümer die Differenz in Tagen zurück. Es kann davon ausgegangen werden, dass das erste übergebene Datum vor dem zweiten liegt.
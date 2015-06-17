# Mitarbeiter-Klasse für die Lohnverrechnung #

Für die Lohnverrechnung eines Betriebes wird eine Java-Applikation erstellt, welche die relevanten Mitarbeiterdaten in Objektinstanzen der folgenden Klasse `Mitarbeiter` speichert:

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/mitarbeiter.jpg' />
</p>


In jeder `Mitarbeiter`-Instanz werden der Name, die Personalnummer, das Eintrittsjahr, und die Gehaltsstufe, gespeichert sowie auch die Information, ob sich der/die Mitarbeiter/in gerade in Karenz befindet. Die Datentypen dieser Attribute sind im UML-Klassendiagramm zu erkennen.

Der Konstruktor der Klasse Mitarbeiter hat einen Parameter `persNr`, mit dem die Personalnummer einer neuen `Mitarbeiter`-Instanz initialisiert wird. Weiters muss im Konstruktor dafür gesorgt werden, dass jede/r neue Mitarbeiter/in bei der Gehaltsstufe 1 beginnt und das aktuelle Jahr (2010 hart codiert) als Eintrittsjahr angenommen wird. Der Name wird mit dem Text „N.N.“ vorbelegt. Ein/e neuer Mitarbeiter/in befindet sich nicht in Karenz.

Für alle Attribute ist jeweils eine `get`- und eine `set`-Methode erforderlich.
Die `set`-Methode für das Eintrittsjahr muss überprüfen, ob das übergebene Jahr in der Zukunft liegt (größer als 2010 ist). Sollte dies der Fall sein, wird auf der Konsole eine Fehlermeldung angezeigt und das Eintrittsjahr nicht verändert. Ansonsten wird das im Parameter übergebene Jahr übernommen.

Im Gehaltsschema des Betriebes gibt es die Gehaltsstufen 1 bis 5. Die `set`-Methode für die Gehaltsstufe muss überprüfen, ob im Parameter eine dieser Zahlen übergeben wird. Andernfalls wird eine Fehlermeldung angezeigt und die Gehaltsstufe nicht verändert.

Die Methode `gehaltsErhoehung()` bewirkt ein Vorrücken in die nächsthöhere Gehaltsstufe. Wenn die/der Mitarbeiter/in bereits in der 5. Gehaltsstufe steht, bewirkt die Methode keine Änderung mehr, es wird jedoch eine Fehlermeldung ausgegeben.

Die Methode `berechneDienstAlter()` berechnet das Dienstalter des/r Mitarbeiter/in in Jahren (2010 – Eintrittsjahr) und liefert das Ergebnis als Rückgabewert.

Die Methode `berechneGehalt()` berechnet das Gehalt eines/r Mitarbeiter/in in € entsprechend dem nachfolgenden Gehaltsschema und gibt das Ergebnis als Gleitkommazahl (`double`) zurück.

> Das Grundgehalt jeder/s Mitarbeiter/in in der 1. Gehaltsstufe beträgt €1200.

> Mit jedem Aufstieg in die nächste Gehaltsstufe kommen €100 dazu.

> Der resultierende Betrag wird pro Dienstjahr um 2% erhöht.

> Ein/e Mitarbeiter/in, welche/r in Karenz ist, bekommt kein Gehalt.
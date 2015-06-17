# Fertigteilhaus #

Eine Fertigteilfirma benötigt eine Software für die Konstruktion der Häuser und für die Preisberechnung. Die erste einfache Version soll so aussehen:


<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/fertigteilhaus.jpg' />
</p>

**Aufgabe 1: Klasse Wand**

Ein Fertigteilhaus wird aus ganzen Wänden zusammengesetzt. Jede Wand wird durch eine Instanz der Klasse `Wand` beschrieben:

a)	Die Eigenschaften einer Wand sind ihre Höhe, ihre Breite, die Anzahl der Fenster und die Anzahl der Türen (Höhe und Breite werden in Zentimetern angegeben). Produktionsbedingt muss die Breite einer Wand zwischen 200 und 1500 cm liegen, die Höhe zwischen 300 und 800 cm. Die Summe aus Fenster- und Türenanzahl darf pro Wand 8 nicht übersteigen. In den `set`-Methoden (e) und im Konstruktor (d) ist darauf zu achten, dass diese Einschränkungen eingehalten werden.

b)	Mit dem Standardkonstruktor werden die Attribute auf Standardwerte gesetzt (eine Standardwand wird erzeugt): Breite: 800cm, Höhe: 600cm, 4 Fenster, keine Tür.

c)	Beim zweiten Konstruktor werden Breite und Höhe als Parameter übergeben. Die übergebenen Werte sind entsprechend der Einschränkungen laut Punkt a) zu überprüfen. Im Falle ungültiger Werte sind die Standardwerte anzuwenden, und es ist eine Fehlermeldung auszugeben. Die Anzahl der Fenster wird auf 4 gesetzt, die Anzahl der Türen auf 0.

d)	Für jedes der Attribute ist eine `get`- und eine `set`-Methode zu schreiben. In den `set`-Methoden sind Überprüfungen entsprechend der im Punkt a) beschriebenen Einschränkungen einzubauen. Wird ein ungültiger Werte übergeben, dann ist eine Fehlermeldung auszugeben.

e)	Die Methode `berechneFlaeche()` liefert als Rückgabewert die Wandfläche in Quadratmetern (auf ganze Quadratmeter abgerundet).

f)	Die Methode `berechnePreis()` liefert den Preis der Wand, der sich nach folgendem Schema ergibt:

> Eine Wand kostet 500€ pro m2; <br />
> zusätzlich kostet jedes Fenster 3000€,  <br />
> eine Tür kostet 5000€.


**Aufgabe 2: Klasse Haus**

a)	Eine Instanz der Klasse `Haus` hat 4 Attribute mit dem Datentyp `Wand`: `vorne`, `hinten`, `links` und `rechts` (die 4 Wände des Hauses).

b)	Der Konstruktor instanziiert zuerst für alle 4 Attribute eine Standardwand; dann wird in die Vorderwand (Attribut `vorne`) eine Tür eingebaut (entsprechende `set`-Methode aufgerufen).

c)	Für jedes Attribut (jede Wand) gibt es eine `set`- und eine `get`-Methode. (In den `set`-Methoden ist nichts zu überprüfen.)

d)	Die Methode `konstruktionOK()` überprüft, ob das Haus richtig konstruiert ist: Vorder- und Rückwand sowie linke und rechte Wand müssen jeweils gleich breit sein. Konstruktion in Ordnung, dann liefert die Methode den Wert `true` zurück, ansonsten den Wert `false`.

e)	Die Methode `berechneGrundFlaeche()` berechnet die Grundfläche des Hauses in Quadratmetern (auf ganze Quadratmeter abgerundet) und liefert diesen Wert als Rückgabewert. Falls das Haus nicht richtig konstruiert ist, liefert die Methode den Wert -1 zurück.

f)	Die Methode `berechnePreis()` liefert den Preis des Hauses als Rückgabewert. Dieser berechnet sich folgendermaßen:

> Hauspreis = Preis aller Wände + 500€ pro Quadratmeter Grundfläche.  <br />
> Falls das Haus nicht richtig konstruiert ist, liefert die Methode den Wert -1 zurück.


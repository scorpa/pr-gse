# Autorennen #

Für ein Computerspiel, in welchem ein Autorennen simuliert wird, werden die folgenden Klassen benötigt:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/autorennen.jpg' />
</p>

Jedes `Auto` hat ein Kennzeichen (darf nicht leer sein) eine aktuelle Drehzahl (2000 bis 8000) und einen Gang (0 bis 5).

Im Konstruktor wird das Kennzeichen als Parameter übergeben, die Drehzahl auf den Wert 2000  und der Gang auf 0 gesetzt.

Die Geschwindigkeit (`berechneGeschwindigkeit()`) berechnet sich nach der Formel

> Geschwindigkeit = Gang x Drehzahl / 100.

Mit der Methode `beschleunigen()` wird die Drehzahl mit 1.5 multipliziert.

Mit der Methode `bremsen()` wird die Drehzahl durch 1.5 dividiert.

Mit der Methode `hinaufschalten()` wird der Gang um 1 erhöht.

Mit der Methode `hinunterschalten()` wird der Gang um 1 reduziert.

Alle diese Methoden lösen eine `AutoException` aus, falls der erlaubte Wertebereich nicht eingehalten würde. Der Konstruktor löst eine `AutoException` aus, falls das Kennzeichen ein Leerstring ist.

Die Methode `toString()` liefert einen String, welcher die Werte aller Attribute und die Geschwindigkeit enthält.

---

Die Klasse `AutoRennen` verwaltet eine Liste von Autos.

Mit der Methode `add(…)` wird ein Auto hinzugefügt.

Die Methode `toString()` liefert einen Text mit folgendem Format:

```
Kennzeichen	Gang	Drehzahl	Geschwindigkeit
============================================
W12345	1	3000		30
NK012		1	2000		20
ME456		1	2000		20
...
```

Die Autos sind nach Geschwindigkeit (absteigend) sortiert.

Die Methode `runde(…)` wählt zufällig ein Auto aus der Liste aus (Zufallsgenerator) und führt mit diesem Auto ein zufällig ausgewähltes Manöver durch (beschleunigen, bremsen, hinaufschalten oder hinunterschalten). Das wird n Mal wiederholt.

Jedesmal, wenn eine Exception auftritt, scheidet das betroffene Auto aus dem Rennen aus (wird aus der Liste entfernt). Eine entsprechende Meldung wird ausgegeben.
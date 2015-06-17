# Klassendesign #

## Literatur ##
[David J. Barnes & Michael Kölling: "Objects First with Java" - Kapitel 7](http://www.bluej.org/objects-first/chapters/objects-first-ch7.pdf)


---


Wenn ein Programm funktionier, heißt das noch lange nicht, dass der Klassenentwurf gut ist.
Ein gutes Software-Design zeichnet sich vor allem aus durch:
  * Übersichtlichkeit
  * leichte Wartbarkeit
  * Wiederverwendbarkeit von Komponenten

Um diese Kriterien zu erfüllen sollten die Kompoenten eines Programms folgende Eigenschaften haben:
  * lose Kopplung
  * hohe Kohäsion

Ein Zeichen für schlechtes Design ist ein hohes Maß an duplizierten Code-Teilen.


---


## Kopplung ##

Unter Kopplung versteht man das Ausmaß, in welchem eine Komponente von den anderen Komponenten abhängt. Lose Kopplung bedeutet, dass zwei Komponenten miteinander nur über schmale Schnittstellen kommunizieren und keinesfalls sich auf irgendwelche interne Implementierungsdetails der jeweils anderen Komponente verlassen.

Durch das Konzept der Datenkapselung wird in der objektorientierten Programmierung nahezu automatisch eine relativ lose Kopplung erreicht - wenn man sich daran hält.



---


## Kohäsion ##

Als Kohäsion bezeichnet man es, wenn sich eine Komponente oder auch nur eine Methode auf eine einzige Funktionalität beschränkt.

Wie könnte man die Kohäsion der Methode `aufladen(...)` aus der Klasse [`Container`](http://pr-gse.googlecode.com/svn/trunk/uebungen/musterloesungen/src/transport_v2/Container.java) ([transport\_v2](http://pr-gse.googlecode.com/svn/trunk/uebungen/musterloesungen/src/transport_v2)) erhöhen?

```
    public boolean aufladen(Platte platte)
    {
        double gewicht = 0;
        for (Platte p : platten)
            gewicht += p.berechneGewicht();
        if (gewicht + platte.berechneGewicht() > maximalesLadegewicht)
            return false;
        if (platte.getBreite() > this.breite || platte.getLaenge() > this.laenge)
            return false;
        return platten.add(platte);
    }
```

Die Methode `aufladen(...)` erfüllt eigentlich 2 Funktionalitäten:
  * es wird das Ladegewicht berechnent
  * es wird geprüft, ob die Platte noch aufgeladen werden darf, und sie wird gegebenenfalls in die Liste eingefügt.
(Eventuell könnte man auch das Prüfen und das eigentliche Einfügen noch aufteilen, was aber dann doch etwas übertrieben wäre, weil das Einfügen ohnehin nur aus 1 Anweisung besteht.)

Spendiert man für die Berechnung des Ladegewichts eine eigene Methode, dann kann diese möglicherweise auch wo anders verwendet werden.
Der Code sieht dann folgendermaßen aus:

```
    public double berechneLadeGewicht()
    {
        double gewicht = 0;
        for (Platte p : platten)
            gewicht += p.berechneGewicht();
        return gewicht;
    }
    
    public boolean aufladen(Platte platte)
    {
        double gewicht = berechneLadeGewicht();
        if (gewicht + platte.berechneGewicht() > maximalesLadegewicht)
            return false;
        if (platte.getBreite() > this.breite || platte.getLaenge() > this.laenge)
            return false;
        return platten.add(platte);
    }
```
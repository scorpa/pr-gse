# Erstes umfangreicheres Programm #

An diesem Beispiel soll eine mögliche Vorgangsweise für das Erstellen des ersten größeren Programms demonstriert werden.

## 1. Wozu soll das Programm dienen ##

Dieses Beispiel geht davon aus, dass sich einige Leute ein Fahrzeug teilen. Das Programm soll als Fahrtenbuch dienen, in dem jede/r Fahrer/in die Fahrten und Ausgaben einträgt. Einerseits dienen diese Aufzeichnungen dann zum Erstellen von Statistiken (Verbrauch, Kosten, etc.) andererseits soll das Programm eine Kostenaufteilung errechnen.

## 2. Funktionalitäten definieren ##

  * Erfassen, ändern und löschen von
    * Fahrten
    * Kosten
  * Statistik generieren
  * Kostenaufteilung erstellen


## 3. Oberfläche skizzieren ##

### Hauptfenster ###

Erscheint beim Programmstart. Die Daten werden aus einer Datei gelesen.


![http://pr-gse.googlecode.com/svn/wiki/images/fahrtenbuch/HauptFenster.png](http://pr-gse.googlecode.com/svn/wiki/images/fahrtenbuch/HauptFenster.png)


### Fahrt eingeben / bearbeiten ###

Erscheint bei Betätigung der Schaltfläche "NEU" oder "BEARBEITEN" neben der Fahrtenliste.

![http://pr-gse.googlecode.com/svn/wiki/images/fahrtenbuch/Fahrt.png](http://pr-gse.googlecode.com/svn/wiki/images/fahrtenbuch/Fahrt.png)


### Tankstop eingeben / bearbeiten ###

Erscheint beim Betätigung der Schaltfläche "Tankstop" bzw. wenn ein Tankstop in der Liste ausgewählt ist bei "BEARBEITEN".

![http://pr-gse.googlecode.com/svn/wiki/images/fahrtenbuch/Tankstop.png](http://pr-gse.googlecode.com/svn/wiki/images/fahrtenbuch/Tankstop.png)

### Andere Ausgaben eingeben / bearbeiten ###

Erscheint beim Betätigung der Schaltfläche "Ausgabe" bzw. wenn eine andere Ausgabe in der Liste ausgewählt ist bei "BEARBEITEN".

![http://pr-gse.googlecode.com/svn/wiki/images/fahrtenbuch/Ausgabe.png](http://pr-gse.googlecode.com/svn/wiki/images/fahrtenbuch/Ausgabe.png)

## 4. UML ##

Erster Entwurf für die Fachlogik:

![http://pr-gse.googlecode.com/svn/wiki/images/fahrtenbuch/fachlogik.jpg](http://pr-gse.googlecode.com/svn/wiki/images/fahrtenbuch/fachlogik.jpg)
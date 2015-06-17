# Lohnverrechnung #

In einem Betrieb arbeiten verschiedene Arten von Mitarbeitern:
Angestellte, Arbeiter und Vertreter.
Es soll für diesen Betrieb ein Lohnverrechnungssystem erstellt werden.

### Daten ###

Folgende Daten müssen für alle Mitarbeiter erfasst werden:
  * Name
  * Mitarbeiternummer
  * Eintrittsjahr

Zusätzlich müssen noch verschiedene Informationen für die verschiedenen Mitarbeiterarten erfasst werden:

  * für Angestellte muss die Gehaltsstufe erfasst werden (von 1 bis 5)
  * für Arbeiter müssen die im aktuellen Monat geleisteten Stunden erfasst werden.
  * für einen Vertreter muss sein Grundgehalt und der im aktuellen Jahr erwirtschaftete Umsatz erfasst werden.


### Berechnung des Gehalts ###
Das Gehalt der Mitarbeiter berechnet sich folgendermaßen:

  * Ein Angestellter der Gehaltsstufe 1 erhält 1500€. Steigt ein Angestellter in eine höhere Gehaltsstufe auf, so erhöht sich sein Gehalt um 10%. Zusätzlich wird für jedes Jahr der Firmenzugehörigkeit das Gehalt um 30€ erhöht.

  * Ein Arbeiter erhält einen Basis-Stundenlohn von 40€. Pro Jahr der Firmenzugehörigkeit erhöht sich dieser Betrag um 3%.

  * Ein Vertreter bekommt ein verhandelbares Grundgehalt plus 3% vom Umsatz.


Im Lohnverrechnungssystem werden die Daten aller Mitarbeiter verwaltet. Es soll eine zeilenorientierte Benutzerschnittstelle implementiert werden, welche in einer späteren Version durch eine grafische Benutzeroberfläche ersetzt wird. Darauf ist bereits beim Design der Applikation Rücksicht zu nehmen.

Folgende Funktionalität ist gefordert:

  * Erfassen der Mitarbeiterdaten

  * Ändern der Mitarbeiterdaten

  * Auflisten aller Mitarbeiter

  * Ausgeben der Daten eines Mitarbeiters

  * Gehaltstabelle ausgeben:
> > | Mitarbeiternummer | Name |  Gehalt |
|:------------------|:-----|:--------|

  * Gesamte Lohnkosten für aktuelles Monat berechnen


### UML-Diagramm ###
<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/lohnverrechnung.jpg' />
</p>
# Projektverwaltung #

Ein Betrieb erstellt eine Software zum Verwalten der Projektkosten. Die Daten für ein Projekt werden in Objektinstanzen der folgenden Klasse `Projekt` abgelegt:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/projektverwaltung.jpg' />
</p>

### Attribute ###
Jedes `Projekt`
  * wird durch seine `nummer` identifiziert,
  * hat eine `bezeichnung`,
  * hat eine Anzahl von Mitarbeitern (`anzahlMitarbeiter`),
  * wird in einer Kalenderwoche und in einem Jahr begonnen (`kwBeginn` und `jahrBeginn`), Es gibt die Kalenderwochen 1 bis 52,
  * wird in einer Kalenderwoche und in einem Jahr beendet (`kwEnde` und `jahrEnde`),
  * verbucht einen Betrag für den `sachAufwand` (in €),
  * ist bereits `abgeschlossen` oder nicht.

### Methoden ###
  * Der Konstruktor der Klasse `Projekt` übernimmt als Parameter die Projektnummer. Die anderen Attribute werden folgendermaßen initialisiert:
    * Die `bezeichnung` eines neuen Projekts ist `"unbekannt"`.
    * Ein Standardprojekt hat 5 Mitarbeiter.
    * `kwBeginn`, `jahrBeginn`, `kwEnde` und `jahrEnde` werden jeweils mit `0` vorbelegt.
    * Der `sachAufwand` für ein Standardprojekt ist € 10000.
    * Ein Standardprojekt ist noch nicht `abgeschlossen`.

  * Es gibt `get-`Methoden für alle Attribute; `set`-Methoden gibt es nur für die Attribute `bezeichnung`, `anzahlMitarbeiter`, `sachAufwand` und `abgeschlossen`. Es ist jeweils zu verhindern, dass sinnlose Werte übernommen werden (z.B. ein negativer `sachAufwand`).
  * Die Methode `beginn(...)` setzt den Beginn-Zeitpunkt für das Projekt (z.B. Kalenderwoche 50 im Jahr 2010).
  * Die Methode `ende(...)` setzt den End-Zeitpunkt für das Projekt. (Sowohl in der Methode `beginn(...)` als auch in der Methode `ende(...)` dürfen nur sinnvolle Werte übernommen werden. `ende(...)` darf nur aufgerufen werden, wenn schon ein Beginn gesetzt wurde, und es ist dann zu überprüfen, dass das Ende nach dem Beginn liegt.)
  * Die Methode `projektDauer()` berechnet die Dauer des Projekts in Wochen und liefert die Anzahl der Wochen als Rückgabewert. Ist das Projekt noch nicht abgeschlossen, dann liefert die Methode den Wert `-1` zurück.
  * Die Methode `berechneKosten()` berechnet die Kosten des Projekts entsprechend dem nachfolgendem Schema und liefert die Kosten in € als Rückgabewert.

> Die Kosten setzen sich zusammen aus dem Sachaufwand, dem allgemeinen Aufwand pro Woche und den Personalkosten pro Woche.
> Der Sachaufwand ist im entsprechenden Attribut abgelegt.
> Der allgemeine Aufwand beträgt € 1000 pro Woche.
> Die Personalkosten betragen € 700 pro Woche und Mitarbeiter.
> Ein noch nicht abgeschlossenes Projekt liefert den Wert `-1` zurück.
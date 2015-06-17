# Temperaturstatistik #

Für die Aufzeichnung von Temperaturwerten und die anschließende statistische Auswertung soll die folgende Klasse `TemperaturStatistik` erstellt werden.

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/temperatur_statistik.jpg' />
</p>

  * In einem Array vom Typ `double`  (`temperatur`) werden die jeweiligen Tageshöchsttemperaturen gespeichert.

  * Das Attribut `anzahl` enthält die Zahl der bereits eingegebenen Temperaturen.

  * Der Parameter `tage` beim Konstruktor gibt an, über wieviele Tage die Aufzeichnungen durchgeführt werden sollen.

  * Die Methode `aufnehmen(…)` dient dazu, den nächsten Temperaturwert in die Statistik aufzunehmen.

  * Die Methode `ausgeben()` gibt die  Temperaturen auf die Konsole aus.

  * Die Methode `getAnzahl()` gibt die Anzahl der bereits erfassten Temperaturen an.

  * Die Methode `getTemperatur(…)` liefert die Temperatur für den angegebenen Tag als Rückgabewert (die Tage werden mit 0 beginnend nummeriert: `getTemperatur(0)` liefert also den ersten erfassten Wert).

  * Die Methode `durchschnitt()` liefert die durchschnittliche Temperatur über alle Tage als Rückgabewert.

  * Die Methode `max()` liefert die höchste erfasste Temperatur als Rückgabewert().

  * Die Methode `maxTag()` liefert die Nummer des Tages, für den die höchste Temperatur eingetragen ist (Tage werden mit 0 beginnend nummeriert – siehe oben).

  * Die Methode `maxDiff()` liefert die maximale Temperaturdifferenz zwischen zwei aufeinander folgenden Tagen (Absolutwert).

  * Die Methode `uebernehmen(…)` bekommt als Parameter eine Referenz auf eine zweite `TemperaturStatistik`-Instanz. Sie übernimmt alle Werte von dieser zweiten Instanz und hängt sie bei den eigenen Temperaturen hinten an.

### Fehlerbehandlung ###

Die Methode `aufnehmen(…)` soll eine Fehlermeldung ausgeben, wenn keine weitere Temperatur mehr erfasst werden kann (Array voll).

Die Methoden `durchschnitt()`, `max()`, `maxTag()`, `maxDiff()` sollen jeweils eine Fehlermeldung ausgeben und den Wert 0 zurückliefern, falls noch keine Werte (bzw. zu wenige Werte) vorhanden sind.


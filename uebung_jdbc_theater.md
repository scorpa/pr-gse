# Theater-Reservierung #

Eine Applikation für das Reservieren von Sitzplätzen in einem Theater verwendet die folgende Datenbankstruktur, welche Sie mit dem Script  [theater.sql](http://pr-gse.googlecode.com/svn/trunk/uebungen/musterloesungen/src/theater/theater.sql)  anlegen können:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/Theater.png' />
</p>



In der Tabelle VORSTELLUNGEN werden für jede Vorstellung das Datum und der Name des Stücks abgespeichert.

In der Tabelle RESERVIERUNGEN sind zu einer Vorstellung (referenziert über die VORSTELLUNGS\_ID) die reservierten Sitzplätze mit den zugehörigen Namen gespeichert.

Die Reservierungsnummer (r\_id) ist ein auto-increment-Wert.

In dem Theater gibt es die Sitzplätze 1 bis 100.

Erstellen Sie ausgehend von den zur Verfügung gestellten Klassen [Vorstellung](http://pr-gse.googlecode.com/svn/trunk/uebungen/musterloesungen/src/theater/Vorstellung.java) und [Reservierung](http://pr-gse.googlecode.com/svn/trunk/uebungen/musterloesungen/src/theater/Reservierung.java) eine Klasse `ReservierungsToolImpl`, welche das Interface [ReservierungsTool](http://pr-gse.googlecode.com/svn/trunk/uebungen/musterloesungen/src/theater/ReservierungsTool.java) entsprechend den Kommentaren implementiert:


---

```
int freiePlaetze(Vorstellung v)		
                 throws ReservierungException
```
gibt an, wie viele Plätze für die übergebene `Vorstellung` frei sind.
(es gibt im Theatersaal die Plätze 1 bis 100)

**Parameters:**

`v` - Referenz auf die `Vorstellung`

**Returns:**

Anzahl der freien Plätze

**Throws:**

`ReservierungException` - bei Datenbankzugriffsfehlern


---

```
java.util.List<Reservierung> reservierungsListe(Vorstellung v)   (10 Punkte)
                                               throws ReservierungException
```
liefert eine Liste aller Reservierungen für eine bestimmte Vorstellung

**Parameters:**

`v` - Referenz auf die `Vorstellung`

**Returns:**

Liste der Reservierungen

**Throws:**

`ReservierungException` - bei Datenbankzugriffsfehlern




---

```
boolean speichern(Reservierung r)			
                  throws ReservierungException
```
Speichert eine `Reservierung`. Dabei muss darauf geachtet werden, dass kein Sitzplatz für die selbe Vorstellung doppelt vergeben wird. Nach erfolgreichem Speichern der `Reservierung` soll die neu erzeugte Reservierungsnummer (r\_id) mit dem Wert im Attribut `id` übereinstimmen.

**Parameters:**

`r` - Referenz auf die zu speichernde `Reservierung`

**Returns:**

`true` wenn das Speichern gut geht, `false` wenn der Sitzplatz bereits vergeben ist

**Throws:**

`ReservierungException` - bei Datenbankzugriffsfehlern



---

```
java.util.List<Vorstellung> vorstellungsListe(java.util.Date datum) 
                                              throws ReservierungException
```
liefert eine Liste der Vorstellungen an dem übergebenen Datum

**Parameters:**

`datum` - Datum der Vorstellungen

**Returns:**

Liste der Vorstellungen

**Throws:**

`ReservierungException` - bei Datenbankzugriffsfehlern
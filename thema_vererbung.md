# Vererbung #

### Literatur ###
[Java ist auch eine Insel](http://openbook.galileocomputing.de/javainsel7/javainsel_06_007.htm#mjcdc0fb3601215318f116491f7552c8a6)

## Beispiel ##
_(Dieses Beispiel ist identisch mit der ersten Übung)_

Für die Verwaltung der Schüler und Lehrer einer Schule soll ein Programm erstellt werden, mit welchem im Wesentlichen die Daten erfasst und wieder abgerufen werden können.

Für jeden Schüler werden folgende Daten erfasst:
  * Vorname
  * Nachname
  * Geburtsdatum
  * Schülernummer  (int)
  * aktuelle Klasse (5 bis 6 alphanumerische Zeichen)


Für jeden Lehrer sollen folgende Daten erfasst werden:
  * Vorname
  * Nachname
  * Geburtsdatum
  * Lehrerkürzel (2 bis 3 Buchstaben)
  * Klassen, die der Lehrer aktuell unterrichtet


Es soll auch eine (zeilenorientierte) Benutzerschnittstelle für die Ein- und Ausgabe der Daten erstellt werden. Folgende Funktionalitäten sind gefordert:
  * Anlegen eines neuen Schülers oder Lehrers mit Erfassung aller Daten
  * Auflisten aller verwalteten Personen
  * Anzeigen der Daten eines Schülers oder Lehrers

Ein erster Ansatz für die Realisierung der Fachlogik könnte folgendermaßen aussehen:
<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/schulverwaltung.jpg' />
</p>
Ein Nachteil dieser Lösung ist einfach zu erkennen: Die allgemeinen Personendaten sind sowohl in der Klasse `Schueler` als auch in der Klasse `Lehrer` enthalten. Dies führt mit den zugehörigen `get-` und `set-`Methoden zu dupliziertem Code, was wir im Allgemeinen zu vermeiden versuchen.

Dieses Problem könnten wir eventuell auf folgende Weise lösen:
<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/schulverwaltung_personendaten.jpg' />
</p>
Sowohl `Schueler-` als auch `Lehrer-`Objekte haben in den Attributen eine Referenz auf ein weiteres Objekt vom Typ `PersonenDaten`, in welchem eben genau diese allgemeinen Personendaten enthalten sind.

Noch eleganter geht es jedoch mit dem Konzept der **Vererbung**:
<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/schulverwaltung_vererbung.jpg' />
</p>
Sowohl `Schueler` als auch `Lehrer` erben von einer gemeinsamen Basisklasse `Person`.
Diese Klasse enthält die allgemeinen Personendaten. Sowohl `Schueler` als auch `Lehrer` sind Personen mit jeweils unterschiedlichen zusätzlichen Eigenschaften.

Die Implementierung dieser Lösung befindet sich in den Übungen.

### Übungen ###
| **Aufgabe** | **Musterlösung** | **Bemerkungen** |
|:------------|:------------------|:----------------|
| [Schulverwaltung](uebung_vererbung_schulverwaltung.md) | [schulverwaltung](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/schulverwaltung) | Dieses Beispiel ist oben besprochen |
| [Lohnverrechnung](uebung_vererbung_lohnverrechnung.md) | [lohnverrechnung](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/lohnverrechnung)|                 |
| [Transport\_V3](uebung_vererbung_transport_v3.md) |                   |                 |
| [Fuhrpark](uebung_vererbung_fuhrpark.md) |                   |                 |
| [Logik](uebung_abstraktion_logik.md) |                   |                 |
| [Rechenquiz](uebung_abstraktion_rechenquiz.md) | [rechenquiz](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/rechenquiz) | Prüfungsbeispiel |
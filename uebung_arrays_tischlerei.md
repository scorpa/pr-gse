# Tischlerei #

Ein Tischlereibetrieb benötigt eine Software für die Verwaltung der Holzplatten. Erstellen Sie die Klassen `Platte` und `PlattenVerwaltung`:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/plattenverwaltung.jpg' />
</p>

Objekte der Klasse `Platte` speichern die Daten für eine einzelne Platte: die Nummer (die Platten werden nummeriert), die Länge und die Breite.

Die Nummer wird im Konstruktor übergeben. Für alle Attribute gibt es eine `get`- und eine `set`-Methode.

Die Methode `berechneUmfang()` liefert den Umfang einer `Platte` als Rückgabewert, die Methode `berechneFlaeche()` liefert die Fläche.

<br />

Objekte der Klasse `PlattenVerwaltung` verwalten mehrere Platten in einem Array. Die maximale Anzahl der Platten wird dem Konstruktor als Parameter übergeben.

Die Referenzen auf die verwalteten `Platte`-Instanzen werden im Array `platten` beginnend beim Index 0 gespeichert. Das Attribut `anzahl` gibt an, wie viele Platten in der Verwaltung vorhanden sind.

Die Methode `aufnehmen(…)` nimmt eine Platte in die Verwaltung auf. Dabei ist sicherzustellen, dass jede Plattennummer nur einmal in der Verwaltung vorkommen darf.

Die Methode `ausgeben()` gibt eine Liste aller Platten aus. Für jede Platte werden die Nummer, die Länge, die Breite, die Fläche und der Umfang ausgegeben.

Die Methode `get(…)` bekommt einen Index als Parameter. Die Methode liefert eine Referenz auf die Platte mit diesem Index, falls dieser gültig ist. Andernfalls liefert sie den Wert `null`.

Die Methode `gesamtFlaeche()` liefert als Rückgabewert die Gesamtfläche aller verwalteten Platten.

Die Methode `groesste()` liefert eine Referenz auf die Platte mit der größten Fläche.

Die Methode `sortieren()` sortiert die Platten nach Plattennummern.
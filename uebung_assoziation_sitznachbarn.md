# Sitznachbarn #

Erstellen Sie folgende Klasse `Schueler`:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/sitznachbarn/uml.gif' />
</p>

Jeder Schüler kann im Klassenraum einen linken und einen rechten Sitznachbarn haben. Diese werden mit den jeweiligen `set`-Methoden gesetzt. Wenn ein Schüler keinen linken oder rechten Sitznachbarn hat, hat die entsprechende Referenz den Wert `null`.

Im Hauptspeicher kann man also etwa folgende Struktur aufbauen:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/sitznachbarn/struktur.gif' />
</p>

Wenn man beim Schüler mit dem Namen Fritz die Methode `listeRechts()` aufruft sollen in der Konsole die Namen Fritz, Lilly, Karli und Grete ausgegeben werden.

Die Methode `anzahlRechts()` aufgerufen bei der `Schueler`-Instanz mit dem Namen Fritz liefert als Rückgabewert die Zahl 4 (4 Schüler inklusive Fritz selbst).

Ruft man bei Fritz die Methode `listeLinks()` auf, so werden auf der Konsole die Namen Fritz, Susi, Hansi ausgegeben.

`anzahlLinks()` liefert entsprechend die Zahl 3.

Bauen Sie in BlueJ händisch eine Struktur wie oben auf und schreiben Sie auch eine Testklasse, welche das gleiche macht!
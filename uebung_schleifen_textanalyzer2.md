# Textanalyzer #

Erstellen Sie die folgende Klasse `TextAnalyzer`:

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/textanalyzer2.jpg' />
</p>

Im Attribut `text` wird der zu analysierende Text gespeichert. Dieser wird entweder dem Konstruktor übergeben oder kann später mit der Methode `setText(...)` gesetzt werden.

Die Methode `charCount(...)` liefert die Anzahl der Zeichen im Text zurück. Der Parameter `countWS` gibt an, ob dabei "Whitespace-Zeichen" (Leerzeichen, Tabulator, Zeilenumbruch) mitgezählt werden oder nicht.

Die Methode `wordCount()` zählt die Wörter im Text und gibt deren Anzahl zurück.

Die Methode `sentenceCount()` liefert die Anzahl der Sätze im Text zurück. Ein Satz endet mit einem Punkt '.', einem Fragezeichen '?' oder einem Rufzeichen '!'.

Die Methode `occurrenceCount(...)` zählt, wie oft das übergebene Zeichen im Text vorkommt.

Die Methode `letterStatistics(...)` gibt an, wie oft die Buchstaben a - z (im case-sensitiven Fall auch A - Z) im Text vorkommen.
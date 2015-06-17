# Buchverwaltung #

Für eine Bibliothek wird eine Software benötigt, um Bücher zu verwalten. Dafür werden die folgenden Klassen `Buch` und `BuchVerwaltung` benötigt:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/bibliothek.jpg' />
</p>

### Klasse Buch ###

In der Klasse `Buch` sind alle wesentlichen Daten für ein Buch gespeichert.

Im Konstruktor wird die ISBN-Nummer übergeben und gespeichert.

Für die Attribute `autor`, `titel`, `verlag` und `seiten` gibt es ganz normale `get-` und `set-`Methoden. In den `set-`Methoden ist jeweils zu prüfen, ob alle Strings ungleich `null` und keine Leerstrings sind und ob die Seitenanzahl größer als `0` ist.

Die Methode `entlehnen(…)` übernimmt als Parameter den Kunden, der das Buch entlehnen will. Ein Buch kann nur entlehnt werden, wenn es nicht bereits entlehnt ist, also wenn kein Kunde eingetragen ist (`kunde` ist `null`). Der Rückgabewert gibt an, ob das Entlehnen gut gegangen ist.

Mit der Methode `retour()` wird ein Buch zurückgegeben: das Attribut `kunde` wird wieder auf `null` gesetzt.

### Klasse BuchVerwaltung ###

Mit der Klasse BuchVerwaltung werden alle Bücher verwaltet.

Mit der Methode `anlegen(…)`  wird ein Buch in den Bibliotheksbestand übernommen.

Mit der Methode `ausmustern(…)` wird ein Buch aus dem Bibliotheksbestand entfernt.

Die Methode `liste()` listet alle Bücher in folgendem Format auf:

```
ISBN		Autor			Titel		        Seiten		entlehnt
12345		Grimm			Schneewittchen		25		ja
678910	        Karl Marx		Das Kapital		250		nein
……
```

Die Methode `listeEntlehnt()` listet alle entlehnten Bücher auf.

Die Methode `listeVerfuegbar()` listet alle nicht entlehnten Bücher auf.

Die Methode `anzahlEntlehnt()` gibt die Anzahl der entlehnten Bücher zurück.

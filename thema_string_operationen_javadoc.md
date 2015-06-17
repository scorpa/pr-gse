# String-Operationen und Java-Doc #




## Besonderheiten der Klasse String ##

Die Klasse String ist im Prinzip eine Klasse wie jede andere nur mit ein paar Besonderheiten:
  * Eine Instanz kann nicht nur mit `new` angelegt werden sondern auch mit der Zuweisung eines String-Literals:
> > `String name = "Max ";`
  * Zwei String-Objekte können mit `+` zusammengesetzt werden, und es entsteht daraus ein neues String-Objekt:
> > `String neuerName = name + "Müller";`

## Vergleichen von Strings ##
Man ist sehr leicht versucht, folgendermaßen zu vergleichen, ob 2 Strings gleich sind:
```
String str1 = ...;
String str2 = ...;

if (str1 == str2)
{
    ....
}
```
In Wirklichkeit vergleicht man hier jedoch bloß, ob die beiden String-Referenzen `str1` und `str2` auf das identische String-Objekt zeigen (also ob es sich um lediglich 1 Objekt handelt).
Um 2 Strings auf gleichheit zu überprüfen muss man die Methode `equals()` verwenden:
```
if (str1.equals(str2))
{
    ...
}
```

## Umwandeln von Strings ##
Will man aus einer Zahl (z.B. `int x`) einen String machen, dann gibt es den einfachen Trick:
```
String str = "" + x;
```
Etwas sauberer ist diese Lösung:
```
String str = String.valueOf(x);
```
Die Umwandlung eines Strings (z.B. `String str = "4711"`) in eine Zahl funktioniert folgendermaßen:
```
int ganzZahl = Integer.parseInt(str);
float dezimalZahl = Float.parseFloat(str);
double genaueDezimalZahl = Double.parseDouble(str);
...
```

## Wichtige String-Methoden ##
(siehe [API-Doc](http://java.sun.com/javase/6/docs/api/))

### Teilstrings ###

Um einen Teil eines Strings zu erhalten, kann man die Methode `substring(...)` verwenden. Diese gibt es in 2 Versionen:
```
    "Max und Moritz".substring(8)  // liefert "Moritz" (vom Index 8 bis zum Ende)
    "Max und Moritz".substring(4, 7)  // liefert "und" (Beginn-Index, End-Index (exklusiv))
```

### Einzelnes Zeichen extrahieren ###

Das Zeichen an einer bestimmten Stelle (Index) im String bekommt man mit der Methode `charAt(...)`. Das erste Zeichen hat den Index 0:
```
    "Max und Moritz".charAt(0)  // liefert 'M'
```

### Suche von Zeichen(folgen) im String ###

Dafür verwendet man eine der 4 Versionen der Methode `indexOf()`:
```
    "ein Hund und eine Katze".indexOf('u')  // liefert 5 (Position des 'u' in "Hund")
    "ein Hund und eine Katze".indexOf('u', 6)  // liefert 9 (Position des 'u' in "und" - die Suche wird erst ab Index 6 begonnen)
    "ein Hund und eine Katze".indexOf('s')  // liefert -1 ('s' kommt nicht vor)

    "ein Hund und eine Katze".indexOf("und")  // liefert 5 (Startposition von "und" in "Hund")
    "ein Hund und eine Katze".indexOf("und", 6)  // liefert 9 (Startosition von "und" - die Suche wird erst ab Index 6 begonnen)

```

Soll die Suche von hinten begonnen werden, dann verwendet man die Methode `lastIndexOf()` in ihren verschiedenen Varianten:
```
    "ein Hund und eine Katze".lastIndexOf("und")  // liefert 9 (Startosition von "und")
```


# Übungen #
| **Aufgabe** | **Musterlösung (Projekt)** | **Kommentare** |
|:------------|:----------------------------|:---------------|
<a href='Hidden comment: 
|| [uebung_string_operationen_javadoc_mitglied Mitglied] ||   [http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/mitglied mitglied] ||  ||
'></a>
| [Mitglied](uebung_string_operationen_javadoc_mitglied.md) |                             |                |
| [Text-analyzer](uebung_string_operationen_javadoc_textanalyzer.md) | [textanalyzer1](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/textanalyzer1) | Musterlösung nur für einen Teil der Aufgabenstellung |
| [Verschlüsselung](uebung_string_operationen_javadoc_textcoder.md) | [textcoder](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/textcoder) | Prüfungsbeispiel (hier braucht man auch Schleifen) |
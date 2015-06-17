# Number-analyzer #

Erstellen Sie die folgende Klasse `NumberAnalyzer`:

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/numberanalyzer.jpg' />
</p>

Das Attribut `number` enthält eine Ganzzahl, die entweder im Konstruktor oder später mit der Methode `setNumber(...) gesetzt wird.

Die Methode `isPrime()` überprüft, ob es sich bei der Zahl um eine Primzahl handelt.

Die Methode `findFactorial()` überprüft, ob eine ganze Zahl `n` existiert, so dass sich die Zahl im Attribut `number` durch folgende Multiplikation ergibt:
```
zahl = n * (n-1) * (n-2) * .... * 3 * 2 * 1
```
Falls ja, wird diese Zahl `n` zurückgeliefert, ansonsten der Wert 0.

Die Methode `printFactors()` gibt alle Zahlen aus, durch welche die Zahl im Attribut `number` teilbar ist.

Die Methode `leastCommonMultiple(...)` liefert als Rückgabewert das kleinste gemeinsame Vielfache der Zahl im Attribut `number` und der im Parameter übergebenen Zahl.
(siehe [Wikipedia](http://de.wikipedia.org/wiki/Kleinstes_gemeinsames_Vielfaches))

Die Methode `greatestCommonFactor(...)` liefert als Rückgabewert den größten gemeinsamen Teiler der Zahl im Attribut `number` und der im Parameter übergebenen Zahl.
(siehe [Wikipedia](http://de.wikipedia.org/wiki/Gr%C3%B6%C3%9Fter_gemeinsamer_Teiler))
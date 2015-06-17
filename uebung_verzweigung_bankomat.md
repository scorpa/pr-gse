# Bankomat #

Erstellen Sie die folgende Klasse `Bankomat`:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/bankomat.jpg' />
</p>

Das Besondere an diesem Bankomat ist, dass man weder Karte noch Code benötigt, um abzuheben ;-)

In den Attributen (`scheine500`, `scheine200`, ...) ist jeweils die Anzahl der 500er-Scheine, 200er-Scheine, ... gespeichert.

Ein neuer Bankomat ist leer, d.h. alle `scheineXXX`-Atribute haben den Wert `0`.

Daher muss der Bankomat befüllt werden. Die Methode `befuellen(...)` hat 2 Parameter:
> `schein`: gibt an, welche scheine nachgelegt werden (z.B. 50 - es werden 50er-Scheine nachgelegt).

> `anzahl`: gibt an, wieviele Scheine nachgelegt werden.

Mit der Methode `auszahlen(...)` kann man den Bankomat veranlassen, einen bestimmten Betrag auszuzahlen. Der Automat muss nun berechnen, ob und mit welchen Scheinen er den Betrag auszahlen kann. Dabei gilt die Regel, dass er immer mit den größtmöglichen Scheinen auszahlt. Die Anzahl der jeweiligen Scheine wird auf der Konsole ausgegeben.

Beispiel: Der Betrag 790 soll ausgezahlt werden - Ausgabe auf der Konsole:

```
500-Scheine:    1
200-Scheine:    1
50-Scheine:     1
20-Scheine:     2
```

Natürlich muss dabei überprüft werden, ob die benötigten Scheine überhaupt verfügbar sind. Falls nicht, wird eine Fehlermeldung ausgegeben: `Betrag nicht verfügbar`.

Bei einer Auszahlung müssen auch die Werte der entsprechenden `scheineXXX`-Attribute reduziert werden.
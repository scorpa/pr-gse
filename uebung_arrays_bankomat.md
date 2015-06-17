# Bankomat mit Array #

Realisieren Sie die Bankomatklasse aus [dieser Übung](uebung_verzweigung_bankomat.md) mit einem Array, in welchem der jeweilige Wert der Scheine gespeichert ist und einem zweiten Array, in welchem die jeweilige Anzahl gespeichert ist:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/bankomat_array.jpg' />
</p>

`wert[0]` = `500`,<br />
`wert[1]` = `200`,<br />
`wert[2]` = `100`,<br />
...

`anzahl[0]` = Anzahl der 500er-Scheine<br />
`anzahl[1]` = Anzahl der 200er-Scheine<br />
`anzahl[2]` = Anzahl der 100er-Scheine<br />
...

Im Konstruktor muss das Array `wert` mit den richtigen Werten befüllt werden.

Die Methoden `befuellen(...)` und `auszahlen(...)` funktionieren genau so wie in der [Übung ohne Array](uebung_verzweigung_bankomat.md), es soll aber intern jeweils eine Schleife verwendet werden und so programmiert sein, dass man ohne großen Aufwand daraus einen Bankomat machen könnte, der beispielsweise auch 5er, 2er und 1er auszahlt.
# Aussagenlogik #

Zur Darstellung von Objekten der Aussagenlogik sind die folgenden Klassen zu erstellen:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/logik.jpg' />
</p>

`Aussage` ist ein Interface, welches die Methode `istWahr()` definiert: Ist die Aussage wahr? Dieses Interface wird von den Klassen `Und`, `Oder`, `Nicht` und `Praemisse` implementiert.
  * Eine `Praemisse` ist ein einfacher Satz. Dieser ist im Attribut `satz` gespeichert. Die Methode `toString()` liefert eben diesen Satz. Die Methode `istWahr()` liefert den Wahrheitswert des Satzes.

  * Eine Instanz der Klasse `Und` hat 2 Referenzen auf andere `Aussage`-Objekte. Die Methode `istWahr()` liefert genau dann `true`, wenn **beide** referenzierten Objekte `true` liefern, ansonsten `false`. Die Methode `toString()` liefert die beiden Aussagen mit dem Wort "und" verknüpft.

  * Eine Instanz der Klasse `Oder` hat 2 Referenzen auf andere `Aussage`-Objekte. Die Methode `istWahr()` liefert genau dann `true`, wenn **eines** der referenzierten Objekte `true` liefert, ansonsten `false`. Die Methode `toString()` liefert die beiden Aussagen mit dem Wort "oder" verknüpft.

  * Eine Instanz der Klasse `Nicht` hat 1 Referenz auf ein anderes `Aussage`-Objekt. Die Methode `istWahr()` liefert genau dann `true`, wenn das referenzierte Objekt `false` liefert und umgekehrt. Die Methode `toString()` liefert die referenzierte Aussage mit dem Wort "nicht" vorangestellt.

Mit Objekten dieser Klassen lässt sich dann beispielsweise die folgende Objektstruktur zusammenbauen. Erstellen Sie eine Klasse `Test` mit einer `main(...)`-Methode, in welcher genau diese Struktur aufgebaut wird. Dann sollen der Wahrheitswert und das Resultat der Methode `toString()` der gesamten Struktur ausgegeben werden.

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/logik2.jpg' />
</p>
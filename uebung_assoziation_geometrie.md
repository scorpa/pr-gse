# Geometrie #

Erstellen Sie die folgenden beiden Klassen `Punkt` und `Gerade`:

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/geometrie.png' />
</p>

## Attribute ##

Ein `Punkt` ist durch seine Koordinaten `x` und `y` im Koordinatensystem definiert (Abb. 1).


<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/geometrie/def_punkt.png' />
<br /><i>Abb. 1: Koordinaten eines Punktes <code>P</code></i>
</p>


Eine `Gerade` ist durch die Gleichung `y = a + k*x` definiert (Abb. 2).

(**Achtung:** mit dieser Definition ist eine senkrechte Gerade nicht darstellbar. Sollte bei irgend einer Operation das Ergebnis eine senkrechte Gerade sein, ist eine Fehlermeldung auszugeben; siehe unten.)

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/geometrie/def_gerade.png' />
<br /><i>Abb. 2: Definition einer Geraden duch Steigung (<code>k</code>) und Abstand (<code>a</code>) von der x-Achse</i>
</p>

## Methoden ##

### Punkt ###

Der Konstruktor der Klasse `Punkt` bekommt als Parameter die Werte der Koordinaten `x` und `y` übergeben.

Für die beiden Koordinaten gibt es jeweis eine `get`-Methode.

Die Methode `abstand(Punkt p)` liefert als Rückgabewert den Abstand des Punktes zu einem anderen Punkt `P`, dessen Referenz als Parameter übergeben wird.

Die Methode `abstand(Gerade g)` liefert als Rückgabewert den Abstand des Punktes zu einer Gerade (Abb. 3), deren Referenz als Parameter übergeben wird.

Die Methode `gerade(Punkt p)` liefert als Rückgabewert eine Referenz auf eine neue `Gerade` welche durch beide Punkte geht. Falls die neue Gerade senkrecht wäre, liefert die Methode den Wert `null` und produziert eine Fehlermeldung.

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/geometrie/def_abstand.png' />
<br /><i>Abb. 3: Abstand (<code>a</code>) eines Punktes <code>P</code> von einer Geraden <code>g</code></i>
</p>

### Gerade ###


Ein Konstruktor bekommt als Parameter die Werte für den Abstand `a` von der x-Achse und für die Steigung `k` übergeben (Abb. 2).

Ein zweiter Konstruktor bekommt als Parameter die Referenzen auf 2 `Punkt`-Instanzen übergeben, durch welche die `Gerade` laufen soll. Wenn die beiden Punkte identisch sind oder so liegen, dass die Gerade senkrecht wäre, wird eine Fehlermeldung ausgegeben und `a` und `k` beide auf den Wert `0` gesetzt.

Es gibt `get`-Methoden für die beiden Attribute (Abstand `a` und Steigung `k`).

Die Methode `schnittPunkt(Gerade g)` liefert als Rückgabewert eine Referenz auf den Schnittpunkt mit der als Parameter übergebenen `Gerade` (Abb. 4). Wenn die beiden Geraden parallel sind, wird eine Fehlermeldung ausgegeben und als Rückgabewert `null` geliefert.

Die Methode `parallel(Punkt p)` liefert als Rückgabewert eine Referenz auf eine neue `Gerade`, welche parallel zur betrachteten `Gerade` ist und durch den `Punkt` p läuft (Abb. 5).

Die Methode `normal(Punkt p)` liefert als Rückgabewert eine Referenz auf eine neue `Gerade`, welche normal zur betrachteten `Gerade` ist und durch den `Punkt` p läuft (Abb. 6). Wenn die neue `Gerade` genau senkrecht wäre, wird eine Fehlermeldung ausgegeben und der Rückgabewert `null` geliefert.

Die Methode `abstand(Punkt p)` liefert als Rückgabewert den Abstand der `Gerade` zum übergebenen Punkt `P` (Abb. 3).


<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/geometrie/def_schnittpunkt.png' />
<br /><i>Abb. 4: Schnittpunkt zweier Geraden <code>g1</code> und <code>g2</code></i>
</p>

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/geometrie/def_parallel.png' />
<br /><i>Abb. 5: <code>g2</code> ist die <code>Gerade</code>, welche parallel zu <code>g1</code> ist und durch den Punkt <code>p</code> läuft.</i>
</p>

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/geometrie/def_normal.png' />
<br /><i>Abb. 6: <code>g2</code> ist die <code>Gerade</code>, welche normal zu <code>g1</code> ist und durch den Punkt <code>p</code> läuft.</i>
</p>
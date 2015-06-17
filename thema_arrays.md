# Arrays in Java #



# Literatur #

[Java ist auch eine Insel](http://openbook.galileocomputing.de/javainsel7/javainsel_03_009.htm#mj84ea4c087f52181d51b2462a54c220ca)


---


## Was ist ein Array? ##

Im folgenden Code-Fragment werden 3 Variablen deklariert (es wird hier angenommen, dass es eine Klasse `Buch` gibt):

```
int i;
double d;
Buch b;
```

Es wird hierbei Speicherplatz für eine ganze Zahl (Variable `i`), für eine Gleitkommazahl (Variable `d`) und für eine Referenz (Variable `b`) angelegt, wobei die Referenz auf eine `Buch`-Instanz verweisen kann.

In jeder dieser 3 Variablen passt aber immer nur exakt 1 Zahl bzw. 1 Referenz.
Es gibt jedoch oft Situationen, in denen man z.B. 100 Zahlen bzw. 100 Referenzen abspeichern will, beispielsweise in einer Klasse, welche Messwerte bzw. Bücher verwaltet.
Für diesen Zweck gibt es Arrays.

In Java ist ein Array ein **Objekt**, in dem beispielsweise 100 Zahlen, Refernzen, etc. abgespeichert werden können. Auf dieses Objekt wird wiederum (so wie auf alle anderen Objekte auch) über eine Referenz zugegriffen:

```
int[] zahlen;
```
deklariert die Variable `zahlen`, in welche eine Referenz auf ein Array passt.

Vorerst hat die Variable `zahlen` den Wert `null`.
Um das Array dann wirklich anzulegen, muss wie bei jedem anderen Objekt auch der Operator `new` verwendet werden:

```
zahlen = new int[100];
```

Nun verweist die Referenz `zahlen` auf ein Array-Objekt, welches Platz für 100 Ganzzahlen bietet:

![http://pr-gse.googlecode.com/svn/wiki/images/Arrays/array_objekt.png](http://pr-gse.googlecode.com/svn/wiki/images/Arrays/array_objekt.png)

Ganz gleich ist der Sachverhalt bei einem Array von Referenzen:

Der Code

```
Buch[] buecher = new Buch[100];
```

erzeugt ein Array-Objekt, in dem 100 Referenzen auf `Buch`-Instanzen Platz haben:

![http://pr-gse.googlecode.com/svn/wiki/images/Arrays/referenz-array.png](http://pr-gse.googlecode.com/svn/wiki/images/Arrays/referenz-array.png)


Vorerst haben alle 100 Referenzen den Wert `null`, da nur das Array-Objekt angelegt wurde, jedoch keine einzige `Buch`-Instanz. Die `Buch`-Instanzen, auf welche die einzelnen Referenzen im Array verweisen sollen, müssen selbst erst mit `new` erzeugt werden.

Die Größe eines Arrays ist unveränderlich. Sollte ich also mit dem Platz nicht auskommen, so gibt es keine Möglichkeit, das Array zu vergrößern, sondern ich kann nur ein neues Array anlegen.


---


## Zugriff auf einzelne Elemente des Arrays ##

Die einzelnen Elemente eines Arrays verhalten sich ihrerseits wieder wie einfache Variablen des entsprechenden Datentyps. Die einzelnen Elemente werden mit dem sogenannten Index durchnummeriert. Dieser beginnt bei 0:

![http://pr-gse.googlecode.com/svn/wiki/images/Arrays/index.png](http://pr-gse.googlecode.com/svn/wiki/images/Arrays/index.png)

_(Dabei ist bei Ganzzahl-Arrays wichtig, den Index eines Elements nicht mit seinem Wert zu verwechseln.)_

Auf ein einzelnes Element eines Arrays greift man zu, indem man hinter den Namen der Referenz auf das Array eckige Klammern stellt, welche den Index des Elements beinhalten:
```
zahlen[3]
```
ist somit in unserem Beispiel das 4. Element (wir beginnen bei 0 zu nummerieren!) im dargestellten Ganzzahlen-Array. Dieses ist als ganz normale `int`-Variable zu betrachten (genauso wie die durch `int i;` deklarierte Variable `i` - ich kann deshalb mit `zahlen[3]` alles das machen, was ich auch mit `i` machen kann; z.B.:

```
zahlen[3] = 5;
zahlen[3] += 3;
i = zahlen[3];
...
```

Hier wird zuerst einmal der Wert des Elements mit dem Index 3 auf 5 gesetzt, dann wird er um 3 erhöht, dann wird der Wert des Elements mit dem Index 3 an die Variable `i` zugewiesen.

Genau das gleiche gilt auch für ein Array von Referenzen: Alles was ich mit der Variable `Buch b;` machen kann, kann ich auch mit einem beliebigen Element des oben dargestellten Arrays `buecher` machen; z.B.:
```
buecher[2] = new Buch();
buecher[2].setTitel("Schneewittchen");
...
```

Folgendermaßen könnte ich z.B. die Titel aller im Array vorhandenen Referenzen auf `Buch`-Instanzen ausgeben:
```
for (int inx = 0; inx < buecher.length; inx++)
{
    if (buecher[inx] != null)   // überprüfe, ob die Referenz auf ein Buch verweist
    {
        System.out.println(buecher[inx].getTitel();
    }
}
```

Hier wurde das Attribut `length` verwendet, welches in jedem Array-Objekt existiert. Es gibt an, aus wievielen Elementen das Array besteht.

In diesem Beispiel wird für jedes Element abgefragt, ob es auch wirklich auf eine `Buch`-Instanz verweist. Diese Möglichkeit habe ich bei Arrays von Referenzen, da bei Referenzen der spezielle (_nicht_)-Wert `null` existiert. Bei Arrays von Zahlen habe ich diese Möglichkeit normalerweise nicht, da es keinen solchen speziellen (_nicht_)-Wert gibt (die Zahl 0 ist auch eine ganz normale Zahl). Ich muss mir dann auf eine andere Art und Weise merken, welche Zahlen in meinem Array eine Bedeutung haben, und welche rein zufällig im Array sind, weil einfach in jeder `int`-Variable eine Zahl steht (und daher auch in jedem Element eines `int`-Arrays).


---


## Beispiele ##

### Eigene Implementierung von ArrayList ###

[Code vom Unterricht](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/beispiele/src/arrays/liste)

### Buchverwaltung ###

_der komplette Quellcode befindet sich im Projekt [bibliothek](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/beispiele/src/arrays/bibliothek)_

Ein typisches Beispiel für die Verwendung eines Arrays ist eine Verwaltung irgendwelcher Objekte (in diesem Beispiel `Buch`-Instanzen).
In der Praxis würde man allerdings so eine Verwaltungsklasse eher mit einer `Collection` (z.B. `ArrayList`) realisieren. Aber es ist auch durchaus möglich, ein Array dafür zu verwenden.

Als Attribute in der Verwaltungsklasse benötigt man ein Array für die verwalteten Objekte und sinnvollerweise auch eine Veriable, in der man sich merkt, wieviele Objekte gerade verwaltet werden:
```
public class BuchVerwaltung
{
    private Buch[] buecher;  // das Array mit den Büchern
    private int anzahl;      // hier wird die aktuelle Anzahl der Bücher gespeichert.
    
```

Im Konstruktor wird das Array instanziiert und das Attribut `anzahl` auf 0 gesetzt (in einer neuen Buchverwaltung befinden sich noch keine Bücher). Hier kann man leicht den entscheidenden Nachteil der Verwendung eines Arrays (gegenüber einer `Collection`) erkennen: Ich muss mich am Anfang festlegen, wie viele Bücher ich maximal verwalten kann.

```
    public BuchVerwaltung(int kapazitaet)   // wieviele Bücher kann ich maximal speichern
    {
        // Array anlegen (hier wird keine Buch-Instanz angelegt!!!)
        buecher = new Buch[kapazitaet];
        anzahl = 0;   // zu Beginn ist noch kein Buch in der Verwaltung
    }
```

Mit der folgenden Methode wird eine Buch-Referenz in die Verwaltung aufgenommen. Am Beginn muss überprüft werden, ob überhaupt noch Platz für ein weiteres Buch ist (oder ob das Array schon voll belegt ist). Wenn das Array vom Index 0 weg befüllt wird, ist der nächste freie Index immer gleich dem Wert im Attribut `anzahl`. Beispiel: wenn in meiner Verwaltung 5 Bücher sind, sind die Elemente 0 bis 4 belegt, das nächste freie Element ist jenes mit dem Index 5.

Wenn die neue Buch-Referenz aufgenommen ist, sollte man nicht darauf vergessen, die Anzahl zu erhöhen.

```
    public boolean aufnehmen(Buch b)
    {
        boolean aufgenommen = false;
        
        if (b != null)  // wir wollen keine null-Referenz aufnehmen
        {
            // ist überhaupt noch Platz für ein Buch?
            if (anzahl < buecher.length)
            {
                // beim Index anzahl ist der nächste freie Platz
                buecher[anzahl] = b;
                anzahl++;
                aufgenommen = true;
            }
        }
        return aufgenommen;
    }
```

Soll eine Buch-Referenz entfernt werden, so ist die "Lücke" zu schließen. (Die Bücher sollen lückenlos von vorn weg im Array angeordnet sein.) Im folgenden Beispiel wird die Referenz beim Index 1 ("Schneewittchen") gelöscht, die Referenzen in den folgenden Feldern müssen daher um 1 nach oben verschoben werden:



![http://pr-gse.googlecode.com/svn/wiki/images/Arrays/loeschen.png](http://pr-gse.googlecode.com/svn/wiki/images/Arrays/loeschen.png)

```
    public boolean ausmustern(int index)
    {
        boolean ausgemustert = false;
        if (index >= 0 && index < anzahl)
        {
            for (int i = index; i < anzahl - 1; i++)
                buecher[i] = buecher[i+1];
            anzahl--;
            ausgemustert = true;
        }
        
        
        return ausgemustert;
    }
    
```


---

# Übungen #

Siehe auch Übungen zum Thema [ArrayList](thema_arraylist.md).

| **Aufgabe** | **Musterlösung (Projekt)** | **Kommentare** |
|:------------|:----------------------------|:---------------|
|  [Sensor](uebung_arrays_sensor.md) | [sensor](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/sensor) |  Prüfungsaufgabe |
| [Bankomat](uebung_arrays_bankomat.md) |                             |                |
|  [Bibliothek](uebung_arrays_bibliothek.md) |                             | siehe oben beschriebenes Projekt [bibliothek](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/beispiele/src/arrays/bibliothek/) |
|  [Windkraft\_V2](uebung_arrays_windkraft_v2.md) |                             |                |
<a href='Hidden comment: 
|| [http://pr-gse.googlecode.com/svn/wiki/uebungen/Aufgabe13_Transport_v2.doc Transport_V2] ||  ||   ||
|| Millionenshow ||  || vereinfachte Simulation der Millionenshow ||
||  [http://pr-gse.googlecode.com/svn/wiki/uebungen/plue03_Uni.doc Uni] ||  ||  Prüfungsaufgabe ||
'></a>
|  [RandomTest](uebung_arrays_randomtest.md) | [randomtest](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/randomtest) |  Musterlösung ist derzeit unvollständig |
|  [BinaerZahl](uebung_arrays_binaerzahl.md) |                             |  noch keine Musterlösung |
|  [Tischlerei](uebung_arrays_tischlerei.md) | [plattenverwaltung](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/plattenverwaltung) | Prüfungsaufgabe |
|  [CD-Verwaltung](uebung_arrays_cdverwaltung.md) | [cdverwaltung](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/cdverwaltung) | Prüfungsaufgabe |
|  [TemperaturStatistik](uebung_arrays_temperatur.md) | [temp\_stat](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/temp_stat) | Prüfungsaufgabe |
| [Zeugnis](uebung_arrays_zeugnis.md) | [zeugnis](http://code.google.com/p/pr-gse/source/browse/trunk/uebungen/musterloesungen/src/zeugnis) | Prüfungsaufgabe |


Es gibt auch einige Übungen auf [diesem Server](http://www.griesmayer.com/?menu=GSE)

| 07\_Array\_Simple | Uebung\_002.pdf |
|:------------------|:----------------|
| 08\_Array\_Medium | Uebung\_002.pdf <br /> Uebung\_003.pdf |
| 09\_Array\_Hard   | Uebung\_002.pdf <br /> Uebung\_003.pdf |

[Musterlösung für 08\_Array\_Medium Uebung\_001.pdf (Lotto)](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/lotto)

Eine ganz amüsante Übung befindet sich in 10\_Gefangen.
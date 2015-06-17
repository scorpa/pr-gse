# Kaffee-Automat #

Erstellen Sie die folgende Klasse `KaffeeAutomat`:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/KaffeeAutomat.png' />
</p>

### Attribute ###

  * Der Kaffeeautomat akzeptiert folgende Münzen: 2€, 1€, 50c, 20c, 10c. Für jede dieser Münz-Arten gibt es ein Attribut, welches die Anzahl der entsprechenden Münzen in der Kasse des Automaten angibt. Ein neuer Automat hat eine leere Kasse (alle Münz-Arten auf 0).

  * Es gibt folgende Produkte: Kaffee, Kakao, Tee. Für jedes Produkt gibt es ein Attribut, welches den Preis des Produktes in Cent angibt. Standardmäßig kosten ein Kaffee und ein Kakao jeweils 1.20€, ein Tee kostet 1€.

  * Das Attribut `guthaben` gibt an, wie viel Geld (in Cent) eben eingeworfen wurden (vor Kauf des Produktes).

### Methoden ###

  * Im Konstruktor werden die oben angegebenen Standardwerte für die Attribute gesetzt.

  * Die Methode `preis(...)` dient zum Ändern des Preises für ein Produkt. Der Datentyp `PRODUKT` ist ein `enum`-Typ mit den möglichen Werten `KAFFEE`, `KAKAO` oder `TEE`.

  * Die Methode `einwurf(...)` dient zum Einwerfen der im Parameter eingegebenen Münze. Die Anzahl der entsprechenden Münzen-Art wird um 1 erhöht, und das Guthaben wird entsprechend erhöht. Der neue Wert des Guthabens wird als Rückgabewert geliefert.

  * Die Methode `kaufen(...)` schließt nun den Kauf des im Parameter angegebenen Produktes ab. Es gibt nun folgende Möglichkeiten:
    * Das Guthaben ist hoch genug, um das Produkt zu kaufen und der Automat hat die richtigen Münzen für das Retourgeld in der Kasse. Dann wird ungefähr folgendes auf die Konsole ausgegeben:
```
    Vielen Dank für Ihren Kauf!
    Sie erhalten folgende Münzen als Retourgeld:
        1 x 50c
        2 x 20c
        1 x 10c
```
> > Die Methode liefert dann als Rückgabewert die Höhe des Retourgeldes in Cent, und die Attribute für die jeweils in der Kasse vorhandenen Münzen werden entsprechend dem Retourgeld reduziert. Das Guthaben wird wieder auf 0 gesetzt.
    * Das Guthaben ist hoch genug, aber der Automat hat in der Kasse nicht die richtigen Münzen für das Retourgeld. Dann wird ungefähr folgende Meldung auf der Konsole ausgegeben:
```
    Leider kein Wechselgeld vorhanden. Bitte werfen Sie den Betrag genau ein!
    Sie erhalten folgende Münzen zurück:
        1 x 2€
```
> > Die Methode liefert dann als Rückgabewert das Guthaben in Cent, und die Attribute für die jeweils in der Kasse vorhandenen Münzen werden entsprechend reduziert. Das Guthaben wird wieder auf 0 gesetzt.
    * Das Guthaben ist nicht hoch genug. Dann wird eine Fehlermeldung ausgegeben:
```
    Bitte werfen Sie noch 20c ein!
```
> > Die Methode liefert dann als Rückgabewert 0 und das Guthaben bleibt unverändert.


  * Die Methode `entleeren()` liefert als Rückgabewert den in der Kasse enthaltenen Betrag. Es wird ungefähr folgendes auf die Konsole ausgegeben:
```
    Folgende Münzen werden entnommen:
       25 x 2€
       17 x 1€
       11 x 50c
       22 x 20c
        1 x 10c
```

> Dann werden die Attribute für die in der Kasse vorhandenen Münzen auf den Wert 0 gesetzt.
  * Die Methode `storno()` liefert als Rückgabewert das aktuelle Guthaben. Es wird ungefähr folgendes auf der Konsole ausgegeben:
```
    Sie erhalten folgende Münzen zurück:
        1 x 50c
        2 x 20c
        1 x 10c
```
> Die Attribute für die in der Kasse vorhandenen Münzen werden entsprechend reduziert, und das Guthaben wird wieder auf 0 gesetzt.
# Spannungsteiler #

Bei einem Spannungsteiler werden zwei Widerstände `R1` und `R2` in Serie geschaltet:

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/Spannungsteiler.png' />
</p>

Nach dem Ohmschen Gesetz (`U = R x I`) ergibt sich der Strom durch die zwei Widerstände:
```
  I = U / (R1 + R2)
```
Die Teilspannungen `U1` und `U2` berechnen sich dann folgendermaßen:
```
  U1 = I x R1
  U2 = I x R2
```

Erstellen Sie die Klasse `Spannungsteiler`:

Attribute:
  * `u`: Dezimalzahl - Gesamtspannung
  * `r1`: Dezimalzahl - Widerstand `R1`
  * `r2`: Dezimalzahl - Widerstand `R2`

Methoden:
  * `setU(...)`: set-Methode für das Attribut `u`
  * `setR1(...)`: set-Methode für das Attribut `r1`
  * `setR2(...)`: set-Methode für das Attribut `r2`
  * `getU()`: get-Methode für das Attribut `u`
  * `getR1()`: get-Methode für das Attribut `r1`
  * `getR2()`: get-Methode für das Attribut `r2`
  * `berechneStrom()`: berechnet den Strom `I` und liefert das Ergebnis zurück
  * `berechneU1()`: berechnet die Teilspannung `U1` und liefert das Ergebnis zurück
  * `berechneU2()`: berechnet die Teilspannung `U2` und liefert das Ergebnis zurück
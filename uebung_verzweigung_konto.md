# Konto #

Erstellen Sie die folgende Klasse Konto:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/Konto.jpg' />
</p>

In einem Konto-Objekt werden die Daten für ein Bankkonto gespeichert (Attribute):
  * Kontonummer (`nummer`): Ganzzahl, 6-stellig, >0
  * Besitzer des Kontos (`besitzer`): Text, nicht leer
  * Kontostand (`saldo`): Ganzzahl (in Cent)
  * Überziehungsrahmen (`limit`): ≤ 0, Ganzzahl (in Cent)
  * Zinssatz (`zinssatz`): Ganzzahl (%), ≥ 0 (pro Jahr)

Es gibt einen Konstruktor, welcher die Kontonummer als Parameter übernimmt und für die anderen Attribute folgende Standardwerte setzt:
```
besitzer = „unbekannt“
saldo = 0
limit = 0
zinssatz = 3
```
Die Kontonummer wird überprüft, ob sie 6-stellig ist, ansonsten wird die Standardnummer `111111` verwendet.

Es gibt die Methoden wie im UML-Klassendiagramm aufgelistet.

  * Die `get-`Methoden liefern die Werte der entsprechenden Attribute zurück.
  * Mit den `set-`Methoden ist es für den Anwender möglich, die Werte der Attribute zu verändern. Allerdings ist dafür Sorge zu tragen, dass die oben angeführten Einschränkungen eingehalten werden (`limit ≤ 0`, `besitzer` nicht leer, ...)

  * Mit der Methode `einzahlen(...)` kann der übergebene Betrag auf das Konto eingezahlt werden. Der Kontostand ändert sich entsprechend. Es ist zu überprüfen, dass nur positive Beträge eingezahlt werden (3 Punkte).
  * Mit der Methode `auszahlen(...)` kann der übergebene Betrag vom Konto abgehoben werden (auch hier sind nur positive Beträge erlaubt), jedoch nur dann, wenn dabei der Überziehungsrahmen nicht überschritten wird.
  * Die Methode `berechneZinsen(...)` berechnet die Zinsen für 1 Jahr und addiert die Zinsen zum aktuellen Saldo (Zinssatz ist für positiven und negativen Kontostand gleich).
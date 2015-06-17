# Bibliothek mit Map #

Das ist eine Überarbeitung der Übung [Buchverwaltung](uebung_arraylist_bibliothek.md).

Implementieren Sie die Buchverwaltung mit einer `Map` anstatt mit einer `ArrayList`:

Als Schlüssel dient jeweils die ISBN-Nummer.

Implementieren Sie dann noch zusätzlich folgende Methode:

```
public Buch suchen(String isbn)
```
Diese Methode liefert als Rückgabewert eine Referenz auf das `Buch` mit der übergebenen ISBN-Nummer oder `null`, falls es das Buch nicht gibt.
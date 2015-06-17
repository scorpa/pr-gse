# Konto-Dialog #

Erstellen Sie einen Anzeige- und Eingabe-Dialog für die Klasse [Konto](http://pr-gse.googlecode.com/svn/trunk/uebungen/musterloesungen/src/konto/Konto.java).

http://pr-gse.googlecode.com/svn/wiki/uebungen/images/KontoDialog.JPG

Die Dialog-Klasse soll `KontoDialog` heißen und 2 Konstruktoren besitzen:

  * Ein Konstruktor bekommt keine Parameter. Wird der Dialog mit diesem Konstruktor erzeugt, dann dient er zum Anlegen eines neuen Kontos. Der Dialog wird mit leeren Textfeldern angezeigt. Wenn der Benutzer alle Daten für das neue Konto eingegeben hat und mit "OK" bestätigt, wird eine neue `Konto`-Instanz angelegt.

  * Der zweite Konstruktor bekommt eine `Konto`-Referenz als Parameter. Er zeigt alle Daten des übergebenen Kontos an. Der Benutzer kann diese Daten nun verändern und mit "OK" bestätigen. Daraufhin werden die Änderungen in die `Konto`-Instanz übernommen.

Nach Betätigen der Schaltfläche "OK" wird der Dialog geschlossen.

Es gibt eine Methode `public Konto getKonto()`, welche eine Referenz auf die im Dialog bearbeitete `Konto`-Instanz als Rückgabewert liefert.

Das Textfeld für die Kontonummer ist nur beim Anlegen eines neuen Kontos editierbar. Wird ein bereits existierendes Konto angezeigt, dann kann die Kontonummer nicht verändert werden.

Das Textfeld für den Saldo ist generell nicht editierbar. Jedes neue Konto hat den Saldo-Wert 0, der sich lediglich durch Ein- und Auszahlungen ändern kann.

Bei Betätigen von "Ein-/Auszahlen wird folgender Dialog sichtbar:

http://pr-gse.googlecode.com/svn/wiki/uebungen/images/ZahlungsDialog.JPG

Mit diesem Dialog sind Zahlungen und Abhebungen auf das / vom Konto durchzuführen.
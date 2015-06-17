# Verschlüsselung #

Eine Applikation für das Verschlüsseln von Texten soll folgende Klassen verwenden:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/TextCoder.jpg' />
</p>


### TextShifter ###
Die Methode `encode(...)` dieser Klasse verändert den Text, indem `count` mal das erste Zeichen vorne weggenommen und hinten angehängt wird. Der so veränderte Text wird als Rückgabewert geliefert. Beispiel:

> `count` = 3

> `encode("Aufgabe")` liefert den Text   "gabeAuf"

Die Methode `decode(...)` implementiert die Umkehroperation von `encode(...)`.

### CharacterCoder ###
Eine Instanz dieser Klasse enthält als Attribute zwei Strings, welche definieren, in welches Zeichen die Methode `encode(...)` das im Parameter übergebene Zeichen verschlüsselt; Beispiel:

```
	src 	= "abcdefg";
	dest 	= "bcagfed";
```

In diesem Fall wird für ein 'a' ein 'b' geliefert, für ein 'b' wird ein 'c' geliefert, für ein 'c' wird ein 'a' geliefert, für ein 'd' wird ein 'g' geliefert, etc.

Jedes Zeichen, welches nicht in `src` vorkommt, wird unverändert zurückgeliefert.
Im Konstruktor der Klasse ist dafür zu sorgen, dass die beiden Strings folgenden Bedingungen genügen:
  * Jedes Zeichen, welches in `src` vorkommt, muss auch in `dest` vorkommen und umgekehrt.
  * In `src` bzw. `dest` darf kein Zeichen doppelt vorkommen.
Falls die übergebenen Strings diese Bedingungen nicht erfüllen, wird eine Fehlermeldung ausgegeben, und es werden als Standardwerte die Strings aus dem oben angeführten Beispiel angenommen.

Die Methode `decode(...)` implementiert die Umkehroperation von `encode(...)`.

### TextCoder ###
Eine Instanz dieser Klasse enthält als Attribute eine Referenz auf einen `TextShifter` und eine Referenz auf einen `CharacterCoder`.

Die Methode `encode(...)` erhält als Parameter einen Text und liefert diesen folgendermaßen verschlüsselt als Rückgabewert:

Wenn eine Instanz von `TextShifter` vorhanden ist, wird der Text mit dieser verschlüsselt. (`encode(...)`).

Wenn eine Instanz von `CharacterCoder` vorhanden ist, wird jedes einzelne Zeichen mit dieser verschlüsselt (`encode(...)`).
Die Methode `decode(...)` implementiert die Umkehroperation von `encode(...)`.
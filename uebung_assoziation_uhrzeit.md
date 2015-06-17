# Uhrzeit #

Erstellen Sie eine Klasse Uhrzeit:

Der Konstruktor übernimmt die Startzeit in den Parametern:
```
Uhrzeit(int stunden, int minuten, int sekunden)
```

Falls eine ungültige Uhrzeit übergeben wird, erfolgt eine Fehlermeldung, und es wird die Standard-Uhrzeit `"00:00:00"` angenommen.


Es gibt jeweils eine `get`-Methode für Stunden, Minuten und Sekunden.


Es gibt jeweils eine `set`-Methode für Stunden, Minuten und Sekunden, welche jeweils zu überprüfen hat, ob ein gültiger Wert übergeben wurde. Falls nicht, gibt die Methode nur eine Fehlermeldung aus und verändert nichts.


Es gibt eine `print()`-Methode, welche die aktuelle Uhrzeit in der Form `"hh:mm:ss"` ausgibt.


Eine Methode `tickSekunde()` schaltet die Uhrzeit um eine Sekunde weiter.

Eine Methode `tickMinute()` schaltet die Uhrzeit um eine Minute weiter.

Eine Methode `tickStunde()` schaltet die Uhrzeit um eine Stunde weiter.



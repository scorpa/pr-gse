# Flugplaner #

Eine neue Fluggesellschaft benötigt ein Programm für ihre Flug-Planung. Die Gesellschaft bedient folgende Destinationen:
  * Wien
  * Berlin
  * Rom
  * Paris
  * London
Die Software soll folgende Funktionalität aufweisen:

### Erfassen von Flügen ###
Der Anwender gibt die Daten für einen Flug ein:
  * Flugnummer
  * Die Flughäfen für Abflug und Ankunft -  werden aus (einer) Liste(n) ausgewählt.
  * Datum und Uhrzeit des Abflugs
  * Dauer des Fluges

### Auflisten aller Flüge für eine bestimmte Flugstrecke ###
Der Anwender wählt aus (einer) Liste(n) die Flughäfen für Abflug und Ankunft aus. Danach wird eine Liste aller Flüge auf dieser Strecke angezeigt. Diese enthält für jeden gefundenen Flug folgende Informationen:
  * Flugnummer
  * Datum/Uhrzeit Abflug
  * Datum/Uhrzeit Ankunft

### Speichern / Laden des Flugplans ###
Der Flugplan kann gespeichert und später wieder geladen werden.

### Hinweise ###
Die Liste der Destinationen darf hart codiert werden.

Es sind alle Fehler zu behandeln, die durch eine Fehleingabe des Benutzers verursacht werden können.

Die Applikation ist in 3-Schichten-Architektur (Fachlogik, Dateianbindung, GUI) zu implementieren.
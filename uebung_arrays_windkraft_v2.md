# Windkraft V2 (mit Array) #

Die folgenden Klassen sind für die Software zur Steuerung einer Windkraftanlage gedacht. Die Anlage besteht aus mehreren Windrädern:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/windkraft_v2_array.jpg' />
</p>

### Windrad ###

Ein `Windrad` hat eine bestimmte Leistung pro km/h Windgeschwindigkeit (Attribut `kwProKmh`). Jedes `Windrad` hat eine Referenz auf die `WindkraftAnlage`, zu der es gehört, als Attribut (`anlage`). Die Leistung pro km/h wird im Konstruktor als Parameter übergeben. mit `setAnlage(...)` wird das Attribut `anlage` gesetzt, also das `Windrad` einer `WindkraftAnlage` zugeordnet.

Die Methode `berechneLeistung()` muss von der zugeordneten `WindkraftAnlage` die aktuelle Windstärke abfragen (`getWindStaerke()`) um die aktuelle Leistung zu berechnen.

### WindkraftAnlage ###

Die Klasse `WindkraftAnlage` verwaltet Instanzen der Klasse `Windrad` in einem Array (Attribut `windraeder`). Die maximale Anzahl der `Windrad`-Instanzen wird im Konstruktor als Parameter übergeben. Im Attribut `anzahl` ist die Anzahl der aktuell verwalteten `Windrad`-Instanzen gespeichert. Mit der Methode `aufnehmen(…)` wird ein `Windrad` zur Verwaltung übernommen. Es muss beim `Windrad` die Anlage eingetragen werden (`setAnlage(...)`). Mit der Methode `entfernen(…)` wird ein `Windrad` wieder aus der Verwaltung entfernt.

Für das Attribut `windStaerke` (aktuelle Windstärke in km/h bei der Windkraftanlage) gibt es eine `set`- und eine `get`-Methode. Die Windstärke darf nicht negativ sein.

Die `WindkraftAnlage` kann die Gesamtleistung berechnen (`berechneGesamtLeistung()`), indem sie die einzelnen `Windrad`-Instanzen nach der jeweiligen Leistung fragt.
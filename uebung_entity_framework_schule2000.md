# Schule 2000 #

Erstellen Sie eine WPF-Applikation, welche mit Hilfe des Entity Frameworks auf die Datenbank Schule2000 zugreift und eine der folgenden Aufgaben ermöglicht.

Bei allen Änderungen in der Datenbank ist auf folgende Einschränkungen zu achten:
  * Es dürfen nicht mehrere Klassen in der selben Stunde im selben Raum eingeteilt sein.
  * Kein Lehrer darf in einer Stunde in mehr als einer Klasse unterrichten.
  * Kein Schüler darf mehr als einer Klasse zugeordnet sein.
  * Keine Klasse darf zu einem Zeitpunkt in mehreren Fächern gleichzeitig unterrichtet werden.


Dabei ist besonders auf Benutzerfreundlichkeit zu achten, und es sind alle möglichen Fehler (Fehleingaben, Datenbankprobleme) so zu behandeln, dass der Benutzer eine entsprechende Fehlermeldung sieht.

Die Applikation ist in 3-Schicht-Architektur zu erstellen.

### Aufgaben ###

1. Alle Schüler einer Klasse anzeigen. Die Klasse wird dabei aus einer Liste ausgewählt. Es ist dann auch möglich, einen Schüler zu löschen oder einen neuen Schüler zu erstellen und in die Klasse aufzunehmen.

2. Alle Gegenstände auflisten, welche in einer Klasse unterrichtet werden. Die Klasse wird dabei aus einer Liste ausgewählt. Zusätzlich werden auch der Klassenvorstand und der Klassensprecher und dessen Stellvertreter angezeigt. Diese können auch geändert werden.

3. Alle Lehrer anzeigen, die in einer Klasse unterrichten. Die Klasse wird dabei aus einer Liste ausgewählt. Es können dann Lehrer ausgetauscht werden, wobei sich jedoch der Stundenplan für die Klasse nicht ändern soll.

4. Alle Schüler anzeigen, die zu einer bestimmten Stunde laut Stundenplan in der Schule sein sollten. Es können dann die Daten der angezeigten Schüler geändert werden.

5. Alle Prüfungen der Schüler einer Klasse auflisten. Die Klasse wird dabei aus einer Liste ausgewählt. Es können dann zusätzliche Prüfungen erfasst und Prüfungen gelöscht werden.

6. Einen Raumplan anzeigen. Der Raum wird dabei aus einer Liste ausgewählt. Es ist dann möglich, einzelne Unterrichtsstunden in einen anderen Raum zu verlegen.

7. Alle Stunden einer Klasse anzeigen. Die Klasse wird dabei aus einer Liste ausgewählt. Es ist dann möglich, Stunden zu einem anderen Lehrer zuzuordnen oder in einen anderen Raum zu verlegen.

8. Alle Lehrer anzeigen, welche einem Vorgesetzten zugeordnet sind. Der Vorgesetzte wird dabei aus einer Liste ausgewählt. Es können dann dem Vorgesetzten andere Lehrer zugeordnet werden, und dem Vorgesetzten können Zuordnungen von Untergebenen entfernt werden.

9. Alle Prüfungen eines Lehrers anzeigen. Der Lehrer wird dabei aus einer Liste ausgewählt. Es können dann Prüfungen gelöscht und hinzugefügt werden.

10. Eine Notenliste einer Klasse für ein ausgewähltes Fach anzeigen. Die Klasse und das Fach werden dabei aus Listen ausgewählt. Die Note in einem Fach ergibt sich als Durchschnittsnote aller Prüfungen des Schülers in diesem Fach. Es wird kaufmännisch gerundet. Es können Prüfungen gelöscht oder hinzugefügt werden.

11. Alle Räume auflisten, in denen ein Lehrer unterrichtet. Der Lehrer wird dabei aus einer Liste ausgewählt. Es können Unterrichtsstunden des Lehrers in andere Räume verlegt werden.

12. Alle Prüfungen auflisten, die ein Lehrer in einem vorgegebenen Zeitintervall abgehalten hat. Es können Prüfungen gelöscht und neue Prüfungen erfasst werden.

13. Alle Klassen auflisten, in denen ein bestimmter Gegenstand unterrichtet wird. Der Gegenstand wird dabei aus einer Liste ausgewählt. Es können Dann Prüfungen für diesen Gegenstand erfasst werden.

14. Alle Räume mit den darin abgehaltenen Unterrichtsstunde anzeigen. Es können dann Unterrichtsstunden in andere Räume verlegt, neue Räume hinzugefügt und Räume gelöscht werden.

15. Alle Schüler anzeigen, die ein Lehrer unterrichtet. Der Lehrer wird dabei aus einer Liste augewählt. Es können auch die Daten des Lehrers geändert werden.
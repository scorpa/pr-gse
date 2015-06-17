# Quiz #

In der Datei [fragen.csv](http://pr-gse.googlecode.com/svn/trunk/uebungen/musterloesungen/src/quiz/fragen.csv) befinden sich die Fragen für ein Quiz.

Jede Zeile enthält die Frage und die möglichen Antworten im folgenden Format:
Die einzelnen Felder sind durch das Zeichen „|“ getrennt.

Jede Zeile enthält die folgenden Felder:

  * Die Nummer der Frage
  * Den Text der Frage
  * 4 mögliche Antworten
  * Die Nummer der richtigen Antwort (0 bis 3)

Erstellen Sie eine Java Swing Applikation mit folgender Funktionalität:

Die Fragen werden aus der CSV-Datei eingelesen.

Nach dem Start der Applikation wird die erste Frage mit den möglichen Antworten angezeigt.

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/quiz/hauptfenster.jpg' />
</p>


Der Benutzer wählt eine Antwort aus.

Danach bekommt er eine Rückmeldung, ob seine Antwort richtig ist bzw. welche Antwort richtig gewesen wäre.

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/quiz/dialog_richtig.jpg' />
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/quiz/dialog_falsch.jpg' />
</p>


Danach wiederholt sich der Vorgang mit der nächsten Frage.
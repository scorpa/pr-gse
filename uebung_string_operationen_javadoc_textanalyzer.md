# Text-analyzer #

Erstellen Sie die folgende Klasse `TextAnalyzer`:

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/textanalyzer.jpg' />
</p>

Im Attribut `text` wird der zu analysierende Text gespeichert. Dieser wird entweder dem Konstruktor übergeben oder kann später mit der Methode `setText(...)` gesetzt werden.

Die Methode `isNumber()` analysiert den Text, ob es sich um eine Zahl (Ganz- oder Dezimalzahl) handelt.

Die Methode `isEmail()` analysiert, ob es sich beim Text um eine E-Mail-Adresse handelt: enthält der Text das Zeichen '@' und davor und dahinter Zeichen, welche nicht leer sind (kein Blank, kein Tabulator, kein Zeilenumbruch)?

Die Methode `isUrl()` analysiert, ob es sich beim Text um eine URL handelt: beginnt mit "`http://`" und mindestens einen Punkt '.', jedoch keine Leerzeichen, Tabulatoren oder Zeilenumbrüche.

Die Methode `containsWord(...)` analysiert, ob der Text das übergebene Wort enhält und davor und dahinter ein Leerzeichen ist (außer der Text beginnt oder endet mit dem Wort).

Die Methode `isSingleWord()` analysiert, ob es sich bei dem Text um ein einzelnes Wort handelt.

Die Methode `isQuestion()` überprüft, ob es sich bei dem Text um eine Frage handelt (am Ende ein '?').

Die Methode `isLowerCase()` überprüft, ob in dem Text alle Buchstaben Kleinbuchstaben sind

Alle diese Methoden liefern einen boolschen Wert zurück: `true`, falls der Text die abgefragte Eigenschaft aufweist und `false` im anderen Fall.
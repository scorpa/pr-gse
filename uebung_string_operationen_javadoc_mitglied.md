# Mitglied #


1) Studieren Sie in der Java API Dokumentation (Javadoc) die Klassen String und Integer

Wie kann man einen Teilstring aus einem String herausholen?

Wie kann man nach einem bestimmten Trennzeichen suchen?

Wie kann man einen String in lauter Groß-/bzw. Kleinbuchstaben umwandeln?

Wie kann man eine Zahl in einen String umwandeln?

Wie kann man einen String in eine Zahl umwandeln?


---


2) Erstellen Sie die folgende Klasse Mitglied:

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/mitglied.jpg' />
</p>


Das Attribut `name` ist ein String mit dem Format "`<vorname> <nachname>`".

Das Attribut `eintritt` ist ein String mit dem Format "`<dd>:<mm>:<jjjj>`".

Die Methode `getVorname()` muss aus dem String im Attribut name den 1. Teil (den Vornamen) herausfiltern.

Die Methode `getNachname()` muss aus dem String im Attribut name den 2. Teil (den Nachnamen) herausfiltern.

Die Methode `vornameBeginntMit()` bekommt einen String übergeben und überprüft, ob der Vorname mit diesem Teilstring beginnt. Groß-/Kleinschreibung wird dabei ignoriert.

Die Methode `nachnameBeginntMit()` bekommt einen String übergeben und überprüft, ob der Nachname mit diesem Teilstring beginnt. Groß-/Kleinschreibung wird dabei ignoriert.

Die Methode `getDauerMitgliedschaft()` bekommt als Parameter das aktuelle Jahr übergeben und berechnet mit dem Jahr aus dem Attribut eintritt die Dauer der Mitgliedschaft.
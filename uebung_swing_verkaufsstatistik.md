#Übung: Verkaufsstatistik

# Verkaufsstatistik #

Ein Programm zur Berechnung von Verkaufsstatistiken für verschiedene Artikel verwendet die Klasse `Artikel`, um die Daten eines Artikels zu erfassen.

Für das Abspeichern oder Einlesen einer Liste von Artikeln wird die Klasse `ArtikelSpeicher` verwendet.

Die Klasse `ArtikelEingabe` dient zum Erfassen eines neuen Artikels.

<p>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/verkaufsstatistik.jpg' />
</p>

Erstellen Sie diese Klassen und halten Sie sich genau an die Namen im UML-Klassendiagramm!

### Klasse Artikel ###

Es werden die Bezeichnung, die verkaufte Anzahl, der Preis pro Artikel und das Datum des Verkaufsbeginns erfasst.

Für alle diese Attribute gibt es `get`- und `set`-Methoden entsprechend den Java-Coding-Konventionen.

Die `set`-Methoden müssen folgendes überprüfen:
  * Die Bezeichnung darf nicht leer sein.
  * Die verkaufte Anzahl darf nicht kleiner als 0 sein.
  * Der Preis muss größer als 0 sein.
  * Der Verkaufsbeginn muss in der Vergangenheit liegen.
Ist eine dieser Bedingungen nicht erfüllt, dann löst die entsprechende Methode eine `ArtikelException` aus.

### Klasse ArtikelEingabe ###

Diese Klasse ist ohne Verwendung eines GUI-Builders zu erstellen!!!
Die Klasse erbt von `JDialog` und dient zum Erfassen eines neuen Artikels.

Es können alle Attributswerte für einen Artikel eingegeben werden, und nach dem Schließen des Dialogs kann mit `getArtikel()` eine Referenz auf die neu erstellte `Artikel`-Instanz abgerufen werden.

Eingabefehler werden mit einer Message-Box gemeldet (`JOptionPane.showMessageDialog(…)`)


### Klasse ArtikelSpeicher ###

Mit dieser Klasse kann eine Liste von Artikeln in eine Datei gespeichert bzw. aus einer Datei geladen werden.

Der Konstruktor bekommt als Parameter den Namen der Datei übergeben.

Die Methode `speichern(…)` erhält als Parameter die Referenz auf eine Liste von `Artikel`-Instanzen, welche in die Datei gespeichert werden.

Die Methode `lesen()` lädt aus der Datei eine Liste von `Artikel`-Instanzen und liefert eine Referenz auf diese Liste als Rückgabewert.

Fehler werden auch in dieser Klasse in Form einer `ArtikelException` gemeldet.

### Testklasse ###

Erstellen Sie zusätzlich zu den beschriebenen Klassen eine Testklasse mit einer `main()`-Methode, in der folgendes ausgeführt wird:
  * Es wird der Dialog `ArtikelEingabe` verwendet, um 3 `Artikel`-Instanzen einzulesen und in eine Liste einzufügen.
  * Danach wird die Liste mit Hilfe der Klasse `ArtikelSpeicher` in eine Datei abgespeichert.
  * Danach wird die Liste wieder mit Hilfe der Klasse `ArtikelSpeicher` aus der Datei geladen.
  * Die Attribute der `Artikel`-Instanzen in der geladenen Liste werden auf die Konsole ausgegeben.


_Hinweis:
Macht man einen Dialog modal (`setModal(true)`), dann blockiert der Aufruf `setVisible(true)` so lange, bis der Dialog mit der Methode `dispose()` geschlossen wird._


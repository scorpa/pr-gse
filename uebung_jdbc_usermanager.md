# User-Manager #

_(Für diese Übung gehören die Dateien `User.java`, `UserManager.java`, `UserManagerException.java` und `user.sql` aus der [Muserlösung](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/usermanager) zur Angabe)._

Für eine Benutzerverwaltung steht die Datenbanktabelle USER zur Verfügung (user.sql).
Diese ist folgendermaßen aufgebaut:

| U\_NR	 | Ganzzahl, Primärschlüssel |
|:-------|:----------------------------|
| U\_NAME | Name des Benutzers (VARCHAR(64)) |
| U\_USERNAME | Kennung des Benutzers (VARCHAR(64)) |
| U\_PASSWORD | Passwort des Benutzers (VARCHAR(64)) |

Zu dieser Tabelle gibt es die Klasse `User` und das Interface `UserManager` entsprechend dem folgenden UML-Klassendiagramm:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/usermanager.jpg' />
</p>


### Aufgabe 1 ###

Die im Interface `UserManager` vorgeschriebenen Methoden sind im Source-Code genau beschrieben. Implementieren Sie das Interface mit einer Klasse, welche die entsprechenden Datenbankzugriffe durchführt.


### Aufgabe 2 ###

Erstellen Sie einen Login-Dialog, der ungefähr so aussieht:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/login-dialog.jpg' />
</p>

Bei Betätigen der Schaltfläche ANMELDEN werden Kennung und Passwort ausgelesen und in eine `User`-Instanz eingetragen.

Diese wird dann an die `login()`-Methode der `UserManager`-Implementierung übergeben. Ist das Login erfolgreich, so werden die User-Daten (Name und ID) ausgegeben, ansonsten eine entsprechende Fehlermeldung.
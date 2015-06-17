# Datenbank-Dump in CSV-Dateien #

Erstellen Sie eine Java-Applikation, welche die Inhalte der Tabellen einer Datenbank in eine CSV-Datei schreibt.

Die Applikation bekommt folgende Aufrufargumente:

  * Ordner für CSV-Dateien
  * Datenbank-Treiberklasse
  * URL für die Datenbankverbindung
  * Benutzername für Datenbankverbindung
  * Passwort für Datenbankverbindung

Bsp.:

`java  DBDump  C:\temp  com.mysql.jdbc.Driver  jdbc:mysql://localhost/kundendb  dbuser  dbpwd`

Die Applikation erstellt dann im spezifizierten Ordner für jede Tabelle der angegebenen Datenbank eine CSV-Datei, welche zuerst eine Zeile für die Namen der Spalten und danach je eine Zeile für die einzelnen Datensätze enthält. Die einzelnen Felder sind durch Tabulatoren getrennt.
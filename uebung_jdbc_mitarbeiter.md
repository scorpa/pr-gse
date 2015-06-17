# Mitarbeiterdatenbank #

Das Projekt [mitarbeiter](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/vorgabe/src/mitarbeiter) arbeitet mit Dateianbindung. Das heißt, als Implementierung des Interfaces `MitarbeiterDao` wird die Klasse `FileMitarbeiterDao` verwendet. _(DAO steht für "data access object".)_

Erstellen Sie eine weitere Implementierung des Interfaces `MitarbeiterDao`, welche eine Datenbankandindung realisiert.

Zum Erstellen der Datenbank können Sie das Script  mitarbeiter.sql verwenden (funktioniert mit HSQLDB).
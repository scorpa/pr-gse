# Buchhaltung #

Erstellen Sie eine Applikation für die Verwaltung Ihrer Rechnungen! Die Oberfläche könnte etwa so aussehen:

<p align='center'>
<a href='http://pr-gse.googlecode.com/svn/wiki/images/Buchhaltung/Rechnungen.PNG'>http://pr-gse.googlecode.com/svn/wiki/images/Buchhaltung/Rechnungen.PNG</a>
</p>

Das Programm soll folgende Funktionalität anbieten:

  * Erfassen einer Rechnung:
    * Kategorie für Steuer (Arbeitsmittel, Fachliteratur, Reisekosten, ...); die möglichen Kategorien stammen aus einer Datenbanktabelle und können gegebenenfalls durch Änderungen in dieser Tabelle verändert werden.
    * Mehrwertsteuersatz
    * Bezeichnung
    * Datum
    * Preis

  * Auflisten der Rechnungen (wahlweise alle Rechnungen oder nur die Rechnungen einer Steuer-Kategorie)

  * Auswählen und Verändern einer Rechnung

  * Löschen einer Rechnung

  * Aufstellung der Rechnungen mit Preisen und Mehrwertsteuer und Summe (wahlweise alle Rechnungen oder nur die Rechnungen einer Steuer-Kategorie)

Das Design der Datenbank und auch der Oberfläche obliegt Ihnen. Sie sollen jedoch auf folgende Punkte achten:

  * Die Applikation ist in einer 3-Schichten-Architektur (Oberfläche / Fachlogik / Persistenzlogik) so zu erstellen, dass folgendes ohne große Eingriffe in die nicht betroffenen Komponenten möglich wäre:
    * Umstellen der Persistenzlogik auf eine Datei-Anbindung
    * Realisierung der Oberfläche als WEB-Modul

  * Es ist auf Benutzerfreundlichkeit zu achten (z.B. wäre es nicht benutzerfreundlich, wenn die Steuer-Kategorie einzutippen wäre anstatt aus einer Liste auszuwählen).

  * Konzepte aus dem Unterricht sind anzuwenden, insbesondere
    * sauberes Verwalten der Datenbank-Verbindung
    * Vermeiden von Inkonsistenzen
    * Parametrierte Statements verwenden
    * keine unnötigen Datenbankzugriffe
    * Statements und ResultSets wieder schließen
    * saubere Fehlerbehandlung mit Exceptions, welche in Folge in der Oberflächenschicht mit entspechenden Fehlermeldungen für den Benutzer behandelt werden

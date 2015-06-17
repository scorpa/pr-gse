# Buchverwaltung mit Exceptions #

Noch einmal verbessern wir das [Buchverwaltungs-Programm (in der Version mit Benutzerschnittstelle)](uebung_ui_buchverwaltung.md).

In den Fachklassen (`Buch` und `BuchVerwaltung`) wird in allen möglichen Fehlerfällen eine `BibliothekException` "geworfen" (diese `Exception`-Klasse muss natürlich erstellt werden).

In der Benutzerschnittstelle wird die `BibliothekException` gefangen und eine Fehlermeldung ausgegeben.

WICHTIG: Aus den Fachklassen darf KEINE Ausgabe (`System.out.println(...)`) erfolgen!
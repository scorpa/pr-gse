# Erweiterung der Buchverwaltung #

Das ist eine Erweiterung der Übung [Buchverwaltung](uebung_arraylist_bibliothek.md).

Alle Schleifen, die in der Klasse `BuchVerwaltung` vorkommen sollen so geändert werden, dass ein Iterator verwendet wird.

Es sollen folgende zusätzliche Methoden hinzukommen:

  * `sortiereNachAutor()`: sortiert die Bücher nach Autoren (aufsteigend). Wenn mehrere Bücher vom selben Autor vorhanden sind, sollen diese dann auch noch nach Titel als 2. Sortierkriterium geordnet werden.

  * `sortiereNachSeiten()`: sortiert die Bücher nach der jeweiligen Seitenanzahl (absteigend).

  * `sortiereNachIsbn()`: sortiert die Bücher nach ISBN-Nummern (aufsteigend). Sollten 2 Exemplare des gleichen Buches vorkommen (identische ISBN-Nummer), so sollen die nicht entliehenen Exemplare zuerst kommen.
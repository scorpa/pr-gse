# Java Database Connectivity (JDBC) #

### Literatur ###
[Java ist auch eine Insel - Kapitel 23](http://openbook.galileocomputing.de/javainsel8/javainsel_23_001.htm#mj63630f244505c8e2db0858d193104898)

Hier ist ein [Tutorial](tuturial_jdbc_hsqldb.md) für den schnellen Einstieg mit [HSQLDB](http://www.hsqldb.org) (siehe auch [Thema HSQLDB](thema_jdbc_hsqldb.md)).

Hier ist ein [Tutorial](tutorial_jdbc_mysql.md) für den schnellen Einstieg mit [MySQL](http://www.mysql.de).

### Treibertypen ###

  * JDBC-ODBC-Bridge: stellt die Verbindung über den Microsoft-Standard ODBC her. Ist im SE SDK für Windows enthalten. Ist nicht besonders performant

  * Nativer plattformeigener JDBC-Treiber: Dieser Treiber übersetzt die JDBC-Aufrufe direkt in Aufrufe der Datenbank-API. Dazu enthält der Treiber Programmcode, der native Methoden aufruft.

  * Universeller JDBC-Treiber: Ist in Java geschrieben, verwendet also keine nativen Methoden. Kommuniziert über eine _Middleware_ mit der Datenbank.

  * Direkter Netzwerktreiber: Ist vollständig in Java programmiert und kommuniziert direkt mit dem Datenbank-Server


### Verbindungsinformationen für verschiedene Datenbanken ###

siehe dazu http://www.torsten-horn.de/techdocs/java-sql.htm

| **Datenbank** | **Bibliothek** | **Treiber-Klasse** | **URL** |
|:--------------|:---------------|:-------------------|:--------|
| Oracle        | http://www.oracle.com/technology/software/tech/java/sqlj_jdbc/index.html | oracle.jdbc.driver.OracleDriver | jdbc:oracle:thin:@MyDbComputerNameOrIP:1521:ORCL |
| MySQL         | http://dev.mysql.com/downloads/connector/j/5.1.html | com.mysql.jdbc.Driver | jdbc:mysql://MyDbComputerNameOrIP:3306/myDatabaseName |
| PostgreSQL    | http://jdbc.postgresql.org/download.html | org.postgresql.Driver | jdbc:postgresql://MyDbComputerNameOrIP/myDatabaseName|
| SQL Server    | http://www.microsoft.com/sqlserver/2005/en/us/java-database-connectivity.aspx#download | com.microsoft.jdbc.sqlserver.SQLServerDriver | jdbc:microsoft:sqlserver://MyDbComputerNameOrIP:1433 |





### Übungen ###
| **Aufgabe** | **Musterlösung** | **Bemerkungen** |
|:------------|:------------------|:----------------|
| [Tabelle auf JTable](uebung_jdbc_dbtable.md) | [dbtable](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/dbtable) |                 |
| [Datenbank-Dump in CSV-Dateien](uebung_jdbc_csv.md) |                   |                 |
| [Mitarbeiterdatenbank](uebung_jdbc_mitarbeiter.md) |                   |                 |
| [Buchungen](uebung_jdbc_buchungen.md) | [buchungen](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/buchungen) | Prüfungsbeispiel |
| [User-Manager](uebung_jdbc_usermanager.md) | [usermanager](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/usermanager) | Prüfungsbeispiel |
| [Warenkorb](uebung_jdbc_warenkorb.md) | [warenkorb](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/warenkorb) | Prüfungsbeispiel |
| [Theater-Reservierung](uebung_jdbc_theater.md) | [theater](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/theater) | Prüfungsbeispiel |
| [Buchhaltung](uebung_jdbc_buchhaltung.md) |                   |                 |
| [Terminkalender](uebung_jdbc_terminkalender.md) |                   |                 |
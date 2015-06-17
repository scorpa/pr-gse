# JDBC mit MySQL #

### XAMPP downloaden und installieren ###

Um sinnvoll mit MySQL arbeiten zu können empfiehlt es sich, die aktuelle Version von XAMPP  von [hier](http://www.apachefriends.org/de/xampp.html) herunterzuladen und zu installieren.

### Beispieldatenbank einrichten ###

  * Im XAMPP Control Panel MySQL und Apache starten.
> > ![http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/xampp_control_panel.png](http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/xampp_control_panel.png)

  * PhpMyAdmin aufrufen
> > http://localhost/phpmyadmin/
> > (Default-Installation: Benutzer: root, kein Passwort)

  * Datenbank mit dem Namen `tutorial` anlegen


> ![http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/datenbank_anlegen.png](http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/datenbank_anlegen.png)

  * Tabelle mit dem Namen `buecher` mit 4 Feldern anlegen

> ![http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/tabelle_anlegen.png](http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/tabelle_anlegen.png)

> Die Felder wie folgt definieren

> ![http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/buecher_tabelle.png](http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/buecher_tabelle.png)

> isbn als primary key definieren

> ![http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/primary_key.png](http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/primary_key.png)

> Nun die Schaltfläche `SPEICHERN` betätigen.

  * Beispieldaten einfügen
> > ![http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/beispieldaten.png](http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/beispieldaten.png)

### Zugriff auf die Datenbank aus Netbeans ###

Im Folgenden wird gezeigt, wie man auf die Datenbank aus Netbeans zugreifen kann, und so auch ohne PhpMyAdmin die Datenbank ansehen und manipulieren kann.

Schaltet man in Netbeans auf die Registerkarte **`Services`**, dann sieht man unter anderem den Eintrage **`Databases`**.

![http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/netbeans_services.png](http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/netbeans_services.png)

Nach Rechtsklick auf diesen Eintrag und Auswahl des Kontextmenüs **`New Connection...`** erscheint der Dialog zum Anlegen einer Datenbankverbindung:

![http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/new_database_connection.png](http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/new_database_connection.png)

Nach Auswahl des MySQL Connectors und Eintrag der Informationen für die Datenbankverbindung erhält man einen neuen Eintrag bei den Datenbankverbindungen. Hier kann man die zuvor angelegte Datenbank und auch die Tabelle sehen. Bei Rechtsklick auf die Tabelle kann man **`View Data...`** auswählen und damit ein `SELECT` auf alle Datensätze ausführen. Die Daten werden dann in Tabellenform angezeigt.

Um andere SQL-Befehle auszuführen benötigt man eine Script-Datei. Zu diesem Zweck legen wir in der Registerkarte **`Projects`** ein neues Projekt an. In diesem Projekt legen wir eine SQL-Datei an

![http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/new_sql_file.png](http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/new_sql_file.png)

Wählt man nun die richtige Datenbankverbindung aus und betätigt die Schaltfläche zum Ausführen der SQL-Anweisungen, so werden diese - falls die Syntax stimmt - ausgeführt.

![http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/statement_ausfuehren.png](http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/statement_ausfuehren.png)

### Datenbankzugriff aus einem Java-Programm ###

**WICHTIG:** um den MySQL-JDBC-Treiber in einem Projekt verwenden zu können, muss die Treiberbibliotek in den Klassenpfad eingebunden werden. In Netbeans funktioniert das über die Projekteinstellungen: Rechte Maustaste auf das Projekt - Kontextmenü **`Properties`**

Nach Auswahl **`Libraries`** wird mit der Schaltfläche **`Add Library...`** eine neue Bibliothek hinzugefügt. Hier ist der Eintrag **`MySQL JDBC DRIVER`** auszuwählen.

![http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/netbeans_add_library.png](http://pr-gse.googlecode.com/svn/wiki/images/jdbc_mysql/netbeans_add_library.png)

Für den ersten Versuch eine Datenbankverbindung aufzubauen und ein Select-Statement abzusetzen reicht es, eine Klasse mit einer main-Methode anzulegen und alles dort hinein zu schreiben.

Im ersten Schritt ist die Treiberklasse zu laden:
```
            Class.forName("com.mysql.jdbc.Driver");
```
Hier ist die Exception `ClassNotFoundException` abzufangen.

Als Nächstes wird die Verbindung geöffnet:
```
Connection con = DriverManager.getConnection("jdbc:mysql://localhost/tutorial", "root", "");
```
Hier ist die `SQLException` zu behandeln.

Die Verbindung ist am besten in einem `finally`-Block wieder zu schließen:
```
con.close();
```
Auch hier sowie bei allen weiteren Schritten kann eine `SQLException` auftreten und muss somit behandelt werden.

Um jetzt wirklich ein Query zur Datenbank zu schicken, verwendet man am besten ein `PreparedStatement`:
```
PreparedStatement pstmt = con.prepareStatement("SELECT isbn, autor, titel, seiten FROM buecher");
```

Das Query ist also vorbereitet und wird dann mit `executeQuery()` wirklich durchgeführt. Diese Methode liefert als Ergebnis ein `ResultSet`:
```
ResultSet rs = pstmt.executeQuery();
```

Das `ResultSet` ist so etwas wie ein Datenbank-Cursor und kann nun Datensatz für Datensatz abgearbeitet werden:
```
while (rs.next())
{
    System.out.print(rs.getInt("isbn") + "\t");
    System.out.print(rs.getString("autor") + "\t");
    System.out.print(rs.getString("titel") + "\t");
    System.out.println(rs.getInt("seiten"));
}
```

Danach sollte man nicht vergessen, das `ResultSet` und das `PreparedStatement` wieder freizugeben:
```
rs.close();
pstmt.close();
```
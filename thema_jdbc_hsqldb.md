# Arbeiten mit [HSQLDB](http://www.hsqldb.org) #

### Server starten ###

_(am besten eine Verknüpfung erstellen)_
```
java.exe -cp <Pfad zu hsqldb.jar> org.hsqldb.Server 
    -database.0 <dbfile> -dbname.0 <dbname> 
    [-database.1 <dbfile> -dbname.1 <dbname> ....]
```

| -cp <Pfad zu hsqldb.jar> | nimmt hsqldb.jar in Klassenpfad auf |
|:-------------------------|:------------------------------------|
| org.hsqldb.Server        | diese Klasse ist der Server         |
| -database.x              | Dateiname für die Datenbank        |
| -dbname.x                | Name, unter dem die Datenbank angesprochen wird (siehe unten) |

_(x kann die Werte 0 bis 9 annehmen, d.h. der Server kann gleichzeitig bis zu 9 Datenbank-Instanzen betreiben)_


### Database-Manager starten ###

_(am besten eine Verknüpfung erstellen)_
```
javaw.exe -cp <Pfad zu hsqldb.jar> org.hsqldb.util.DatabaseManagerSwing
```

**Verbindung aufbauen:**

In Combobox auswählen:	HSQL Database Engine Server

Driver: 			`org.hsqldb.jdbcDriver`

URL:				`jdbc:hsqldb:hsql://localhost/<dbname>`

User:				`sa`

Password:			(leer)


### Zugriff aus JAVA-Programm ###

Treiber-Klasse: `org.hsqldb.jdbcDriver`

URL: `jdbc:hsqldb:hsql://localhost/<dbname>`
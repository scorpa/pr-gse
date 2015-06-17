# DB-Tabelle auf JTable #

Erstellen Sie die folgende Klasse `DBTable`:


<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/uml/dbtable.jpg' />
</p>

`DBTable` ist eine Unterklasse der Swing-Komponente `JTable`. Eine `JTable` repräsentiert eine Tabelle, wie sie beispielsweise in MS Excel verwendet werden.

Der Konstruktor bekommt als Parameter eine Referenz auf eine Datenbankverbindung (`java.sql.Connection`) und den Namen einer Datenbanktabelle übergeben. Er liest die Datensätze der Tabelle aus und stellt sie in der `JTable` dar.

Erstellen Sie dann noch eine `main(...)`-Methode (entweder gleich in der Klasse `DBTable` oder in einer zweiten Klasse) so dass man aus einer Konsole aufrufen kann:
```
java.exe -cp <Treiberbibliothek> DBTable <Tabellenname> <DB-Treiber> <DB-URL> <user> <pwd>
```
In der `main(...)`-Methode wird dann
  * der Datenbank-Treiber geladen
  * eine Verbindung zur Datenbank aufgebaut
  * mit dieser Verbindung und dem Tabellennamen eine `DBTable`-Instanz erstellt
  * diese `DBTable`-Instanz in eine `JFrame` eingebaut (mit einer `JScrollPane`!)
  * der `JFrame` angezeigt


---


Im UML-Diagramm ist auch ein Ansatz für die Lösung dargestellt:

`DBTable` enthält intern eine Referenz auf eine `DefaultTableModel`-Instanz. In dieses `DefaultTableModel` werden die Daten aus der Datenbanktabelle eingefügt (`addRow(...)`). Das `DefaultTableModel` wird der `JTable` als ihr darzustellendes Datenmodell übergeben (`setModel(...)`).

Aus der Datenbanktabelle werden die Daten nach der üblichen Vorgangsweise geholt:

  * von der `Connection` mit `prepareStatment(...)` ein `PreparedStatement`-Objekt angefordert
  * mit `executeQuery()` der Query durchgeführt - das Ergebnis ist ein `ResultSet`
  * vom `ResultSet` kann man mit `getMetaData()` eine `ResultSetMetaData`-Instanz anfordern, mit welcher man diverse Eigenschaften der Tabelle abfragen kann:
    * `getColumnCount()` liefert die Anzahl der Tabellenspalten
    * `getColumnName(...)` liefert den Namen einer Tabellenspalte (diesen benötigt man für die Überschrift)
    * `getColumnType(...)` liefert den Datentyp einer Tabellenspalte
  * vom `ResultSet` selbst holt man sich den jeweils nächsten Datensatz (Methode `next()`)
  * dann müssen die Werte für die einzelnen Tabellenspalten abgeholt werden (`getObject(...)) liefert den jeweiligen Wert als `Object`; dieses kann man dann gut für die Methode `addRow(...)` des `DefaultTableModels` verwenden.


---


_**Jedenfalls ist es unumgänglich, ziemlich viel in der Java API-Dokumentation zu schmökern!**_
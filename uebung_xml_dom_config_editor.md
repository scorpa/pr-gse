# Configuration Editor #

Eine Applikation wird mit einer XML-Datei configuriert, welche folgenden Aufbau aufweist:

```
<?xml version="1.0" encoding="ISO-8859-1"?>

<!--

    Aufbau:
        Die Konfigurationsdatei besteht aus beliebig vielen Sektionen.
        Jede Sektion hat einen Namen und enthält beliebig viele Parameter.
        Jeder Parameter hat einen Namen und einen Wert (name/value)

-->


<config>
    <section name="Allgemein">
        <parameter name="Ansicht" value="normal" />
        <parameter name="Modus" value="standalone" />
        <parameter name="Instanzen" value="3" />
    </section>
    <section name="Verbindung">
        <parameter name="Host" value="192.168.0.12" />
        <parameter name="Port" value="4444" />
        <parameter name="Timeout" value="10000" />
    </section>
    <section name="Datenbank">
        <parameter name="Driver" value="com.mysql.jdbc.Driver" />
        <parameter name="Url" value="jdbc:mysql://localhost/App1" />
        <parameter name="User" value="root" />
        <parameter name="Pwd" value="root" />
    </section>
</config>
```

_(Die Datei ist [hier](http://pr-gse.googlecode.com/svn/wiki/uebungen/images/ConfigEditor/config.xml) herunterzuladen.)_

Zum bequemen Ändern der Parameterwerte soll folgender Dialog dienen:

<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/ConfigEditor/ConfigurationEditor.png' />
</p>

Für jede Sektion in der Konfigurationsdatei gibt es eine Karteikarte, auf welcher die Parameter dieser Sektion geändert werden können. Bei Betätigen der Schaltfläche Speichern wird das Fenster geschlossen, und die Änderungen werden in die Konfigurationsdatei zurückgeschrieben.
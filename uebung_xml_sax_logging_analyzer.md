# Logging Analyzer #

In Java wird der standardmäßig Logging-Mechanismus von [log4j](http://www.log4j.org/) verwendet. Dieser kann so konfiguriert werden, dass die Meldungen in Form einer XML-Datei abgespeichert werden. Hier ist ein Beispiel für eine solche Datei:

```
<?xml version="1.0" encoding="windows-1252" standalone="no"?>
<log>
<record>
  <date>2011-01-08T21:07:29</date>
  <millis>1294517249000</millis>
  <sequence>0</sequence>
  <logger>util.Configuration</logger>
  <level>INFO</level>
  <class>util.Configuration</class>
  <method>load</method>
  <thread>10</thread>
  <message>configuration file: D:\eclipse-workspace\fmri\rr_config.xml</message>
</record>
<record>
  <date>2011-01-08T21:07:29</date>
  <millis>1294517249078</millis>
  <sequence>3</sequence>
  <logger>util.Configuration</logger>
  <level>INFO</level>
  <class>util.Configuration</class>
  <method>buildConfigFile</method>
  <thread>10</thread>
  <message>button-right=d</message>
</record>
<record>
  <date>2011-01-08T21:07:29</date>
  <millis>1294517249078</millis>
  <sequence>4</sequence>
  <logger>util.Configuration</logger>
  <level>INFO</level>
  <class>util.Configuration</class>
  <method>buildConfigFile</method>
  <thread>10</thread>
  <message>button-yes=b</message>
</record>
...
```

Für jede Logging-Meldung wird ein `record` angelegt, welcher wiederum aus verschiedenen Komponenten wie `date`, `level`, `class`, etc. besteht.

Eine solche Logging-Datei ist [hier](http://pr-gse.googlecode.com/svn/wiki/uebungen/data/logging.xml) herunterzuladen.

### Aufgabe ###

Erstellen Sie eine Java-Applikation, welche eine solche Datei mit einem SAX-Parser liest und alle `records` mit einem bestimmten `level` auf die Konsole ausgibt. Es sollen dabei jeweils das Datum und die Meldung ausgegeben werden.

Der Name der Logging-Datei und der gewünschte `level` werden als Aufruf-Argumente an das Programm übergeben.

Beispiel:

```
java analyzer.LoggingAnalzyer logging.xml INFO
```

filtert von der oben gezeigten Datei folgendes heraus:

```
2011-01-08T21:07:29 - configuration file: D:\eclipse-workspace\fmri\rr_config.xml
2011-01-08T21:07:29 - button-right=d
2011-01-08T21:07:29 - button-yes=b
...
```
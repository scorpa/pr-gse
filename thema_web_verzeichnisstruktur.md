# Aufbau einer Java WEB-Applikation #

Hier sind die wichtigsten Punkte des Aufbaus einer Java WEB-Applikation beschrieben. Die Entwicklungsumgebungen Netbeans und Eclipse erstellen die Verzeichnisstruktur und unterstützen die Konfiguration weitgehend mit Hilfe von speziellen Editoren - aber leider nicht alles (z.B. gibt es derzeit keine gute Unterstützung bei der Erstellung eigener Tag-Bibliotheken). Außerdem ist es oft vorteilhaft, ein bisschen über die Dateistrukturen dahinter Bescheid zu wissen, spätestens dann, wenn irgend etwas nicht so funktioniert wie es soll.

## Verzeichnisstruktur ##

Die Verzeichnisstruktur einer Java WEB-Applikation sieht folgendermaßen aus:

```
application-root/ 
   |
   +--- html/
   +--- jsp/
   +--- ...
   +--- WEB-INF/
          |
          +--- web.xml
          +--- classes/
          +--- lib/
          +--- tld/
          +--- ...
```

`application-root/` ist hier das Basisverzeichnis der WEB-Applikation (der Name ist beliebig gewählt). Es kann Unterverzeichnisse für die HTML- oder JSP- oder auch sonstige Dateien (Bilder, Audio, Video, ...) enthalten - hier angedeutet durch `html/`, `jsp/`, ... (auch hier sind die Namen frei gewählt). Die Seiten und sonstigen Dateien können jedoch auch direkt im Basisverzeichnis liegen. Alle diese Dateien und Verzeichnisse sind normalerweise vom Client (Browser) abrufbar.

Ein spezielles Unterverzeichnis ist das Verzeichnis `WEB-INF/`. Der Inhalt dieses Verzeichnis ist vom Client nicht abrufbar. Es enthält neben weiteren Unterverzeichnissen die zentrale Konfigurationsdatei der WEB-Applikation: `web.xml`.

Das Verzeichnis `classes/` enthält Java-Klassen, welche von der WEB-Applikation verwendet werden (Servlets, Tag-Handler, sonstige Klassen). Das Verzeichnis `lib/` enthält Bibliotheken (xxx.jar), welche von der WEB-Applikation verwendet werden. Deskriptoren für eigene Tags werden üblicherweise (aber nicht notwendigerweise) in einem Verzeichnis `tld/` abgelegt.

Es können auch noch weitere Dateien und Verzeichnisse im Verzeichnis `WEB-INF/` enthalten sein, welche von der WEB-Applikation benötigt werden aber nicht direkt vom Client abrufbar sein sollen.



## Deployment Deskriptor (web.xml) ##

Die zentrale Konfigurationsdatei der WEB-Applikation `web.xml` wird auch Deployment Deskriptor genannt. Ein Beispiel ist hier gegeben:


```
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee" 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">

    <servlet>
        <servlet-name>Anmeldung</servlet-name>
        <servlet-class>anmeldung.web.Anmeldung</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>Anmeldung</servlet-name>
        <url-pattern>/anmelden</url-pattern>
    </servlet-mapping>
    <welcome-file-list>
        <welcome-file>html/hello.html</welcome-file>
    </welcome-file-list>
    <jsp-config>
        <taglib>
            <taglib-location>
                /WEB-INF/tld/anmeldung.tld
            </taglib-location>
            <taglib-uri>
                /anmeldung
            </taglib-uri>
        </taglib>
    </jsp-config>
</web-app>
```

Nach dem XML-Prolog kommt das Root-Element `web-app` mit einem Verweis auf das Schema. Das Element `web-app` kann eine ganze Reihe von Sub-Elementen enthalten. Hier einige wichtige Elemente:

  * `welcome-file-list` - Startseite der Applikation
  * `jsp-config` - Konfiguration von JSP-Tag-Bibliotheken
  * `servlet` - Konfiguration eines Servlets
  * `servlet-mapping` - über welche URL wird ein Servlet angesprochen
  * `context-param` - Initialisierungsparameter für die WEB-Applikation
  * `error-page` - Verweis auf eine globale Fehlerseite
  * `filter` - bevor eine URL abgerufen wird, kann der Filter Überprüfungen durchführen, etc.
  * `listener` - ein Listener reagiert auf Ereignisse innerhalb der WEB-Applikation
  * `security-constraint` - damit kann der Zugriff auf gewisse URLs eingeschränkt werden
  * `session-config` - globales Timeout für Session setzen


## Aufbau einer URL ##

Um eine Seite einer WEB-Applikation abzurufen kann man die URL in einem Browser eintippen. Diese ist folgendermaßen aufgebaut:
```
<protokoll>://<server>[:<port>]/<context-path>/<seite>
```
Beispiel:
```
http://www.beispiel.net:8080/webapp1/seite1.jsp
```

Das Protokoll ist zumeist HTTP(manchmal auch FTP). Der Host kann auch mit der IP-Adresse angegeben werden (z.B. 127.0.0.1). Wenn keine Port-Nummer angegeben ist, wird für HTTP der Standard-Port 80 verwendet.

Der Context-Pfad wird in einer zentralen Server-Konfigurationsdatei (`server.xml`) definiert, oder aber in einem speziellen Verzeichnis am Server (Tomcat: `conf/Catalina/localhost/`) in einer eigenen Datei für jede WEB-Applikation (Context).

Anstatt der Seite kann am Ende auch z.B. ein URL-Mapping auf ein Servlet stehen.
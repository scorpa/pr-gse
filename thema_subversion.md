# Arbeiten mit Versions-Kontrolle (Subversion) #

Unter einer Versionsverwaltung versteht man ein System, welches typischerweise in der Softwareentwicklung zur Versionierung und um den gemeinsamen Zugriff auf Quelltexte zu kontrollieren, eingesetzt wird ([Wikipedia](http://de.wikipedia.org/wiki/Versionsverwaltung)).

Diese Seite soll dazu dienen, das Arbeiten mit Versionsverwaltungssystemen - im Detail mit dem System [Subversion](http://subversion.tigris.org) - zu erlernen, welches auch bei [Google Code](http://code.google.com) genutzt wird.


## Arbeiten mit [BlueJ](http://www.bluej.org) ##

_(ab Version 2.5.0)_

Im BlueJ gibt es unter
  * Tools - Preferences
einen Karteireiter mit der Überschrift "Miscellaneous".

Darin befindet sich das Kontrollkästchen "Show Teamwork Controls".

Dieses ist als erstes anzuhakerln.

Ab diesem Moment gibt es im "Tools"-Menu den Eintrag "Team".

Bei erster Verwendung sind unter "Teamwork Settings" die Einstellungen für das Arbeiten mit einem Versionsverwaltungssystem durchzuführen.
Später werden diese Einstellungen unter "Checkout" eingestellt.

Für das Laden von Dateien von diesem Repository ist folgendes einzustellen:

![http://pr-gse.googlecode.com/svn/wiki/images/Subversion/Team-Settings.png](http://pr-gse.googlecode.com/svn/wiki/images/Subversion/Team-Settings.png)

Mit "Check connection" kann man feststellen, ob die Verbindung zum Server funktioniert.
Mit "OK" kommt man zu dem Fenster zur Auswahl des Projekts:

![http://pr-gse.googlecode.com/svn/wiki/images/Subversion/Select-Project-to-checkout.png](http://pr-gse.googlecode.com/svn/wiki/images/Subversion/Select-Project-to-checkout.png)

Hier kann man noch mit "show" alle verfügbaren Projekte sehen.

Wählt man eines aus und klickt man auf "OK", dann muss man noch ein Verzeichnis auswählen,
wo die Dateien lokal abgelegt werden sollen.
Die darauffolgende Warnung bezüglich "Package Line Mismatches" kann man ruhig ignorieren.
(BlueJ macht da normalerweise alles richtig.)






## Arbeiten mit [Eclipse](http://www.eclipse.org) ##

### Installation des Eclipse-Plugins [Subclipse](http://subclipse.tigris.org/) ###

Installationsanleitung unter http://subclipse.tigris.org/install.html

Update-Site:

> Name: Subclipse 1.4.x (Eclipse 3.2+)
> URL:  http://subclipse.tigris.org/update_1.4.x

> Name: Subclipse 1.2.x (Eclipse 3.2+)
> URL:  http://subclipse.tigris.org/update_1.2.x

> Name: Subclipse 1.0.x (Eclipse 3.0/3.1)
> URL:  http://subclipse.tigris.org/update_1.0.x

## Arbeiten mit [Netbeans](http://www.netbeans.org) ##

Für Netbeans muss man zuvor noch einen Subversion Client installieren. Es wird der Client von [CollabNet](http://www.open.collab.net/downloads/netbeans/) empfohlen.

In Netbeans muss man dann noch einige Einstellungen tätigen. Diese sind [hier](http://www.netbeans.org/kb/docs/ide/subversion.html#specifying) beschrieben.

Wie man dann mit Subersion in Netbeans arbeitet ist [hier](http://www.netbeans.org/kb/docs/ide/subversion.html#synchronizing) beschrieben.
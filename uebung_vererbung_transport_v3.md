# Transportfirma Version 3 #

Diese Aufgabe ist eine Erweiterung von [Transport V2](uebung_arraylist_transport_v2.md). Kopieren Sie die [Musterlösung](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/uebungen/musterloesungen/src/transport_v2) und adaptieren Sie diese entsprechend!

Die Firma stellt künftig auch runde Platten her. Es ist daran gedacht, später auch noch andere Formen in die Produktion aufzunehmen. Die Software für die Verwaltung der Containerladungen muss also entsprechend geändert werden.

Besonders ist beim neuen Design auch darauf zu achten, dass bei den künftig zu erwartenden neuen Formen (beispielsweise elliptisch, dreieckig, etc.) die Software mit möglichst geringen Änderungen des bestehenden Codes erweitert werden kann. Ein wichtiger Aspekt dabei ist die Tatsache, dass derzeit nicht bekannt ist, welche Formen infrage kommen. Setzen Sie das Konzept der Vererbung sinnvoll ein, um dieser Anforderung gerecht zu werden!

Unabhängig von der Form ist für die Containerladung bei jeder Platte wichtig, wie schwer die Platte ist und welche Abmessungen der Container haben muss, damit die Platte hineinpasst -- also die erforderliche Länge und Breite.

Versuchen Sie, ein entsprechendes UML-Diagramm zu erstellen und danach die Software zu implementieren.
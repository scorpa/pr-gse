# Reversi #

Kopieren Sie sich aus dem Ordner [vorgabe](http://code.google.com/p/pr-gse/source/browse/#svn/trunk/vorgabe/src) das gesamte Package `reversi`.

Dieses Package beinhaltet die Oberfläche für ein [Reversi-Spiel](http://de.wikipedia.org/wiki/Reversi) (auch Othello genannt). Das Spiel selbst ist jedoch noch nicht implementiert. Es existiert lediglich eine Test-Implementierung, bei welcher einfach nacheinander 10 Spielsteine auf beliebige Felder gesetzt werden können. Probieren Sie diese Test-Implementierung aus, indem Sie das Programm mit der Klasse `Start` starten.

Erstellen Sie dann eine Klasse, welche das Interface `Reversi` implementiert und nur gültige Züge zulässt sowie die Spielsteine richtig umdreht. Die Spielregeln können Sie [hier](http://de.wikipedia.org/wiki/Reversi) nachlesen.

Ersetzen Sie sodann in der Klasse `Start` die Klasse `ReversiTestImpl` durch Ihre Implementierung.


_Bemerkungen:_

_Wenn Sie das Spiel nicht kennen, können Sie es z.B. [hier](http://www.mah-jongg.ch/reversi/) einmal ausprobieren._

_Sie sollen jedoch kein Spiel programmieren, welches selbst den nächsten Zug berechnet, sondern Ihr Programm soll lediglich als Spielbrett für 2 Spieler dienen, die abwechselnd ihre Spielsteine setzen. Es sollen aber nur gültige Züge zugelassen werden._
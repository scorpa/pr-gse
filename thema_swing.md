# GUI-Programmierung mit SWING #

### Literatur ###

[Java ist auch eine Insel - Kapitel 16](http://openbook.galileocomputing.de/javainsel8/javainsel_16_001.htm#mjda6f564a051a1270834cc9b46ee6f566)

[Handbuch der Java-Programmierung](http://www.javabuch.de/) ab Kapitel 27 (hier wird nicht nur SWING sondern auch AWT behandelt.)

[Übersicht über die SWING-Komponenten](http://download.oracle.com/javase/tutorial/ui/features/compWin.html)

### Aufbau der Oberfläche ###

Hier sei auf das Beispiel im Abschnitt ["1. umfangreicheres Programm"](thema_programm1.md) verwiesen.

### Ereignisbehandlung ###

Ein Beispiel befindet sich hier: [Bucheingabe](http://pr-gse.googlecode.com/svn/trunk/beispiele/src/swing/).

Es gibt in einer grafischen Oberfläche viele Arten von Ereignissen: Mausklick, Eingaben über Tastatur, Maus bewegen, Fenster nach vorne, Fenster schließen, ....

Die Ereignisse treten immer in Zusammenhang mit einer Oberflächen-Komponente auf.
In Java funktioniert die Ereignisbehandlung so, dass sich ein Ereignis-Handler bei der jeweiligen Komponente registriert und später im Fall des Ereignisses eine entsprechende Methode aufgerufen wird (Callback).

Der Ereignis-Handler muss ein Interface implementieren, in dem die jeweilige Methode definiert ist.

Im Fall eines Buttons funktioniert das folgendermaßen:

Ein Objekt, welches auf Ereignisse eines Buttons reagieren soll, muss den Datentyp `ActionListener` implementieren:
```
    public class EreignisHandler implements ActionListener
    {
	public void actionPerformed(ActionEvent event)
	{
            // das was passieren soll, wenn der Button geklickt wird
        }

        // eventuell weitere Methoden

    }
```

Ein solcher Ereignis-Handler kann bei einem Button registriert werden:
```
    ....
    JButton button = ....
    ActionListener a = new EreignisHandler();
    button.addActionListener(a);
    ....
```

Wenn der Button geklickt wird, ruft er die Methode `actionPerformed(...)` aller registrierter `ActionListener` auf.

In der Praxis gibt es verschiedene Möglichkeiten, welche Klasse das Interfache `ActionListener` implementiert.

Man könnte eine eigene unabhängige Klasse als `ActionListener` erstellen. Diese Vorgangsweise ist jedoch nicht sehr praktisch, da diese Klasse dann nur umständlich auf die Eingabefelder der Fensterklasse zugreifen kann.

Eine andere Möglichkeit besteht darin, dass die Fensterklasse selbst das Interface implementiert. Sie registriert sich dann selbst bei allen Buttons als `ActionListener` und muss dann in der Methode `actionPerformed(...)` feststellen, woher das Ereignis gekommen ist:
```
	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();   // von diesem Objekt (Button) kam der Event
		if (source == bnOK)
		{
	            ...
                }
                else if (source = bnCancel)
                {
                    ...
                }
                ....
        }
```

Die gebräuchlichste Art ist es, als Ereignis-Handler eine (anonyme) [innere Klasse](thema_innere_klassen.md) zu verwenden.


### Übungen ###

| **Aufgabe** | **Musterlösung** | **Bemerkungen** |
|:------------|:------------------|:----------------|
| [Memory](uebung_swing_memory.md) | [memory](http://pr-gse.googlecode.com/svn/trunk/uebungen/musterloesungen/src/memory)  |                 |
| [Konto-Dialog](uebung_swing_konto.md) |                   |                 |
| [GUI für Terminplaner](uebung_swing_terminplaner.md) |                   |                 |
| [Verkaufsstatistik](uebung_swing_verkaufsstatistik.md) | [verkaufsstatistik](http://pr-gse.googlecode.com/svn/trunk/uebungen/musterloesungen/src/verkaufsstatistik) | Prüfungsaufgabe |
| [Editor](uebung_swing_editor.md) |                   |                 |
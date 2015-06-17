# Termin-Service #

Es soll eine JEE-Applikation erstellt werden, welche ein Service zum Versenden von Terminen anbietet:

Ein Administrator-User kann über einen Standalone-Client neue Termine erstellen, die dann an alle Abonnenten versendet werden.

### Die Applikation im Detail ###

Über den Admin-Client können neue Termine erfasst werden:
  * Datum und Uhrzeit
  * Kurzfassung
  * Details zum Termin

Diese Informationen werden sofort per E-Mail an alle Abonnenten versandt. Zusätzlich werden die neuen Termin-Informationen persistiert.
Weiters bekommen die Abonnenten noch einmal 24 Stunden vor dem Datum des Termins ein Erinnerungs-EMail.

Es gibt eine WEB-Applikation, über welche sich Benutzer als Abonnenten registrieren können. Sie geben dort ihre EMail-Adresse und ihren Namen ein und bekommen künftig alle neuen Termin-Informationen zugesandt.



<p align='center'>
<img src='http://pr-gse.googlecode.com/svn/wiki/uebungen/images/TerminService.png' />
</p>

### Komponenten ###

Die Applikation soll aus folgenden Komponenten aufgebaut werden:

  * Session-Bean für die Registrierung
> Diese Komponente bietet ein Service für das Erstellen eines neuen Abonnenten. Der neue Abonnent wird in der Datenbank persistiert.

  * WEB-Applikation (JSF) für die Registrierung
> Front-End für die Registrierung; verwendet das Service der oben beschriebenen Session-Bean.

  * Message-Driven Bean für das Versenden von Termin-Informationen per E-Mail.
> Diese Komponente empfängt Nachrichten aus einer JMS-Queue, welche die Informationen eines neuen Termins enthalten. Aus der Persistenz-Schicht holt sich die Komponente die Informationen über die Abonnenten. Dann sendet sie an alle Abonnenten die Termin-Informationen per E-Mail.

  * Reminder
> Diese Komponente wird als Timer implementiert, welcher Informationen über einen neuen Termin entgegennimmt und dann 24 Stunden vor dem Datum des Termins eine Nachricht an die oben beschriebene Message-Driven Bean in die JMS-Queue stellt um das Versenden von Erinnerungs-EMails zu veranlassen.

  * Session-Bean zum Entgegennehmen neuer Termine
> Diese Komponente bietet ein Remote-Interface, über welches ein Standalone-Client einen neuen Termin übermitteln kann. Der neue Termin wird einerseits mit Hilfe der oben beschriebenen Message-Driven Bean an alle Abonnenten versandt, andererseits wird er an die Reminder-Komponente weitergereicht, um ein Erinnerungs-EMail zu veranlassen.

> Weiters soll jeder Termin auch persistiert werden.
# Test konzept

## Test umgebung

Windows 10
Eclipse
    WOLips
Java JDK 8

## Manuelle Tests

### Webseite ist Erreichbar

Ich verbinde mich zu der URL auf welcher die applikation laufen sollte

#### Erfolg

Die Applikation läuft und ich kann zu ihr verbinden

#### Scheitern

Die applikation ist nicht erreichbar oder gibt einen Error aus

### Richtige Einstigsseite

#### Ausführen

Ich verbinde mich zu der URL auf welcher sich die Applikation befindet

#### Erfolg

Es erscheint die Einstigsseite

#### Scheitern

Es erscheint eine falsche seite

### Hinzufügen von Artikeln

#### Ausführen

Ich gehe auf die Einstiegsseite und wähle das Etui aus.
Ich werde weitergeleitet auf die ArtikelSeite.
Ich drücke auf Etui kaufen.
Ich werde zur Einsigsseite weitergeleitet

#### Erfolg

Ich habe nun ein Etui in ihrem Warenkorb

### Hinzufügen von Artikeln mit Inhalt

#### Ausführen

Ich gehe auf die Einstiegsseite und wähle das Etui aus.
Ich werde weitergeleitet auf die ArtikelSeite.
Ich checke die checkbox für Schere.
Ich drücke auf Etui kaufen.
Ich werde zur Einsigsseite weitergeleitet

#### Erfolg

Ich habe nun ein Etui mit Inhalt Schere in ihrem Warenkorb

### Anschauen von Artikeln

#### Vorraussetzung

Ich habe keine Artikel im warenkorb

#### Ausführen

Ich gehe auf die Einstiegsseite und wähle das Etui aus.
Ich werde weitergeleitet auf die ArtikelSeite.
Ich betätige den zurück Knopf

#### Erfolg

Ich habe keine Artikel im warenkorb

### Admin zurückkehren zu gespeicherten stand

#### Vorraussetzung

Ich habe den Inhalt aaa 12.0000 nicht in der datenbank

#### Ausführen

Ich clicke auf das admin login auf der homepage.
Ich logge mich mit korrekten daten ein.
Ich klick auf Neuen inhalt erstellen.
Ich erstelle den inhalt aaa 12.0000.
Ich Speichere den erstellten inhalt.
Ich drücke auf Letzten gespeicherten zustand herstellen.

#### Erfolg

Der soeben erstellte datensatz ist weg

### Admin speichern von Inhalten

#### Vorraussetzung

Ich habe den Inhalt aaa 12.0000 nicht in der datenbank

#### Ausführen

Ich clicke auf das admin login auf der homepage.
Ich logge mich mit korrekten daten ein.
Ich klick auf Neuen inhalt erstellen.
Ich erstelle den inhalt aaa 12.0000.
Ich Speichere den erstellten inhalt.
Ich drücke auf Speichern.
Ich lasse mir den inhalt der tabelle Inhalte ausgaben.

#### Erfolg

der soeben erstellte datensatz ist in der tabelle eingetragen.

### Kundendaten kontrolle zurück und abschicken

#### Vorraussetzung

#### Ausführen

Ich wähle holzschachtel.
Ich drücke kaufen.
Ich drücke Check Out.
Ich gebe a a a a a a ein.
Ich drücke Submit.
Ich drücke zurück.
Ich gebe a a a a a a ein.
Ich drücke Submit.
Ich drücke Bestätigen.

#### Erfolg

der soeben erstellte datensatz ist in der tabelle eingetragen.

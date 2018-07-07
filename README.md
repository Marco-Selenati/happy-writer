# Dokumentation Projektarbeit `HappyWriter'

## Zugangsdaten

Der zugang zum Adminbereich ist geschützt durch den Usernamen "admin" und das Passwort "klapp42stuhl".

## Development install

### Vorraussetzungen

Beschaffen Sie sich eine Kopie des Projektes.

Dependencies um zu kompilieren:

* Komplette Project WOnder Umgebung
* Java 8

Dependencies um die Dokumentation zu generieren:

* LaTex distribution
  * Hierfür habe ich [TexLive](https://www.tug.org/texlive/) benutzt
* Markdown to PDF konvertierer
  * Hierfür habe ich [Pandoc](https://pandoc.org/index.html) benutzt
* Java für JavaDoc

### Installation

Als erstes werden wir die Datenbank einrichten. Zuerst erstellen Sie eine neue Datenbank mit dem Namen "HappyWriter". In dieser Datenbank führen Sie das Skript "/sql/init.sql" aus und danach "/sql/seed.sql". Im ersten Skript erstellen wir die benötigten Strukturen, im nächsten füllen wir diese mit den Testdaten.

Jetzt importieren wir das Projekt in unsere WOnder Eclipse Umgebung. Gehen Sie in Ihr Eclipse und gehen Sie auf File -> Import Existing Projects into Workspace. Root directory ist der root Ordner dieses Projektes, der Ordner in welchem das README.md ist. Ich empfehle, die Option Copy projects into Workspace nicht zu setzen. Nun sollten Sie ein funktionierendes WOnder Projekt haben.

### Probleme

Wenn Ihr Eclipse errors anzeigt, können Sie versuchen, das Projekt zu cleanen. Wenn Sie dann das Projekt bauen, sollten die Fehler verschwunden sein. Eclipse zeigt meistens Fehler an, wenn die projektspezifischen Dateien nicht mehr mit dem aktuellen working tree synchron sind.

\pagebreak

## Bestätigt funktionsfähig auf

### Software

* Eclipse x64 Oxygen.3a Release (4.7.3a)
* WOLips 4.7.20180528.6
* WOLips Goodies 4.7.20180528.6
* Windows 10 x64
  * Edition Windows 10 Pro
  * Version 1803
  * Build 17134.112
* MariaDB 10.2 x64
* Project WOnder Source commit 73ef902e88130c1d9398458affc23a68431a582a
  * Build mit Ant 1.10.2
* JRE 1.8.0_151
* JDK 1.8.0_144

### Hardware

* RAM 16 GB
* CPU x86_64

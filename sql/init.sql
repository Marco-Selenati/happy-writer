CREATE TABLE Artikel (bezeichnung VARCHAR(50) NOT NULL, id INT NOT NULL, preis DECIMAL(38,4) NOT NULL);

CREATE TABLE BestellPosition (artikel_id INT NOT NULL, bestellung_id INT NOT NULL, id INT NOT NULL);

CREATE TABLE BestellteKonfiguration (bestellPos_id INT NOT NULL, inhalt_id INT NOT NULL);

CREATE TABLE Bestellung (bemerkungen VARCHAR(255) NOT NULL, datum DATE NOT NULL, id INT NOT NULL, kunde_id INT NOT NULL);

CREATE TABLE Inhalt (id INT NOT NULL, name VARCHAR(50) NOT NULL, preis DECIMAL(38,4) NOT NULL);

CREATE TABLE Konfiguration (artikel_id INT NOT NULL, inhalt_id INT NOT NULL);

CREATE TABLE Kunde (id INT NOT NULL, kundeSeit DATE NOT NULL, nachname VARCHAR(50) NOT NULL, ort VARCHAR(50) NOT NULL, plz VARCHAR(50) NOT NULL, strasse VARCHAR(50) NOT NULL, tel VARCHAR(50) NOT NULL, vorname VARCHAR(50) NOT NULL);

CREATE TABLE EO_PK_TABLE (NAME CHAR(40) PRIMARY KEY, PK INT);

ALTER TABLE Artikel ADD PRIMARY KEY (id);

ALTER TABLE BestellPosition ADD PRIMARY KEY (id);

ALTER TABLE BestellteKonfiguration ADD PRIMARY KEY (bestellPos_id, inhalt_id);

ALTER TABLE Bestellung ADD PRIMARY KEY (id);

ALTER TABLE Inhalt ADD PRIMARY KEY (id);

ALTER TABLE Konfiguration ADD PRIMARY KEY (artikel_id, inhalt_id);

ALTER TABLE Kunde ADD PRIMARY KEY (id);

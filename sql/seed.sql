
-- Artikel tabelle daten
INSERT INTO `artikel` (`bezeichnung`, `id`, `preis`) VALUES
('Etui', 1, '15.5000'),
('Holzschachtel', 2, '33.9000');


-- Inhalt tabelle daten
INSERT INTO `inhalt` (`id`, `name`, `preis`) VALUES
(1, 'Schere', '2.0000'),
(2, 'Bleistift', '1.0000'),
(3, 'Feder', '6.0000'),
(4, 'Lineal', '3.5000'),
(5, 'Marker', '0.5000'),
(6, 'Radiergummi', '1.5000'),
(7, 'Spitzer', '5.0000'),
(8, 'Zirkel', '16.0000');

-- Verbindungen von Artikel und Inhalte
INSERT INTO `konfiguration` (`artikel_id`, `inhalt_id`) VALUES
('1', '2'),
('1', '5')

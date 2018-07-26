use mimos;
INSERT INTO `mimos`.`utente` (`citta`, `codice_fiscale`, `cognome`, `data_nascita`, `id_ruolo`, `nome`, `password`, `username`) VALUES ('bari', 'ajfjeksk', 'asdasd', '', '3', 'asdasd', 'bello', 'ciccio');
INSERT INTO `mimos`.`utente` (`citta`, `codice_fiscale`, `cognome`, `data_nascita`, `id_ruolo`, `nome`, `password`, `username`) VALUES ('bari', 'ascasca', 'francesco', '1988-02-12', '0', 'violla', 'oh', 'cool');
INSERT INTO `mimos`.`utente` (`citta`, `codice_fiscale`, `cognome`, `data_nascita`, `id_ruolo`, `nome`, `password`, `username`) VALUES ('bari', 'asdafs', 'rosalia', '1988-02-20', '2', 'mariapia', 'punk', 'daft');
INSERT INTO `mimos`.`utente` (`citta`, `codice_fiscale`, `cognome`, `data_nascita`, `id_ruolo`, `nome`, `password`, `username`) VALUES ('bari', 'ajfjeksk', 'anna', '1988-02-11', '1', 'palindroma', 'floyd', 'pink');
UPDATE `mimos`.`utente` SET `cognome` = 'antonio', `data_nascita` = '1988-02-21', `nome` = 'ciolla' WHERE (`id_utente` = '1');


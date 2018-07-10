CREATE DATABASE specchio_;
use specchio_;

CREATE TABLE utente (
  id_utente int(11) NOT NULL AUTO_INCREMENT,
  id_ruolo int(11) DEFAULT NULL,
  nome varchar(45) DEFAULT NULL,
  cognome varchar(45) DEFAULT NULL,
  user_name varchar(45) DEFAULT NULL,
  password varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  PRIMARY KEY (id_utente)
);

CREATE TABLE misura (
  id_misura int(11) NOT NULL AUTO_INCREMENT,
  id_paziente int(11) NOT NULL,
  pressione float DEFAULT NULL,
  temperatura float DEFAULT NULL,
  glicemia float DEFAULT NULL,
  data timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id_misura),
  KEY fk_misura_utente_idx (id_paziente),
  CONSTRAINT fk_misura_utente FOREIGN KEY (id_paziente) REFERENCES utente (id_utente) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO utente VALUES (1,3,'admin','admin','admin','admin','admin');
INSERT INTO utente VALUES (13,2,'peppe','peppe','peppe','peppe','peppe');
INSERT INTO utente VALUES (14,1,'pippo','pippo','pippo','pippo','pippo');


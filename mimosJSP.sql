drop database mimosJSP;
create database mimosJSP;

create table mimosJSP.utenti (

    id_utente int auto_increment not null,
    id_ruolo int,
    nome varchar(20),
    cognome varchar(20),
    codice_fiscale varchar(20),
    data_nascita date,
    username varchar(20),
    password varchar(20),
    citta varchar(20),
    CONSTRAINT PKutenti PRIMARY KEY (id_utente)
 
);

insert into mimosJSP.utenti (id_ruolo, nome, cognome, codice_fiscale, data_nascita, username, password, citta) values('1','admin','admin','admin','2010-01-01','admin','admin','Cantaura');
insert into mimosJSP.utenti (id_ruolo, nome, cognome, codice_fiscale, data_nascita, username, password, citta) values('2','salvatore','nastasi','salvo','2010-01-01','salvo','salvo','Messina');
insert into mimosJSP.utenti (id_ruolo, nome, cognome, codice_fiscale, data_nascita, username, password, citta) values('2','marco','polo','marco','2010-01-01','marco','marco','Catania');
insert into mimosJSP.utenti (id_ruolo, nome, cognome, codice_fiscale, data_nascita, username, password, citta) values('3','fabrizio','nastasi','fabri','2010-01-01','fabri','fabri','Catania');


create table mimosJSP.misure (

    id_misura int auto_increment not null,
    id_paziente int,
    pressione float,
    battiti int,
    temperatura float,
    glicemia float,
    data timestamp,
    CONSTRAINT PKmisure PRIMARY KEY (id_misura),
    CONSTRAINT FKmisure FOREIGN KEY ( id_paziente ) REFERENCES mimosJSP.utenti(id_utente) ON DELETE  CASCADE

);

insert into mimosJSP.misure (id_paziente, pressione, battiti, temperatura, glicemia) values('3','12.9','120','33','80');

create table mimosJSP.visite (

    id_visita int auto_increment not null,
    id_paziente int,
    id_dottore int,
    data_visita datetime,
    stato tinyint,
    descrizione longtext,
    diagnosi longtext,
    CONSTRAINT PKvisita PRIMARY KEY (id_visita),
    CONSTRAINT FKpaziente FOREIGN KEY ( id_paziente ) REFERENCES mimosJSP.utenti(id_utente) ON DELETE  CASCADE,
    CONSTRAINT FKdottore FOREIGN KEY ( id_dottore ) REFERENCES mimosJSP.utenti(id_utente) ON DELETE  CASCADE


);

create table mimosJSP.specialita (

    id_specialita int auto_increment not null,
    nome varchar(20),
    descrizione varchar(125),
    CONSTRAINT PKspecialita PRIMARY KEY (id_specialita)

);

insert into mimosJSP.specialita (nome, descrizione) values('Cardiologia','Cardiologia');
insert into mimosJSP.specialita (nome, descrizione) values('Ginecologia','Ginecologia');

create table mimosJSP.dottore_specialita (
    id_dottore int,
    id_specialita int,
    CONSTRAINT PKdottore_specialista PRIMARY KEY (id_dottore, id_specialita),
    CONSTRAINT FKdottore_ FOREIGN KEY ( id_dottore ) REFERENCES mimosJSP.utenti(id_utente) ON DELETE  CASCADE,
    CONSTRAINT FKspecialista_ FOREIGN KEY ( id_specialita ) REFERENCES mimosJSP.specialita(id_specialita) ON DELETE  CASCADE
    
);

insert into mimosJSP.dottore_specialita (id_dottore, id_specialita) values('2','1');
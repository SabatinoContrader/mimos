/*DROP DATABASE mimos;*/
INSERT INTO mimos.MUser (nick, psw, sName, lName) 
values ('ciccio', 'cappuccio', 'Franco', 'Bianchi');
INSERT INTO mimos.MUser (nick, psw, sName, lName) 
values ('hello', 'world', 'Mario', 'Rossi');
INSERT INTO mimos.MUser (nick, psw, sName, lName) 
values ('pippo', 'paperino', 'Lino', 'Verdi');

INSERT INTO mimos.Patient (idUnique, healthInsuranceCard) 
values (1, '1234567890123456');
INSERT INTO mimos.Patient (idUnique) 
values (2);
INSERT INTO mimos.Doctor (idUnique, mainSkill) 
values (3, "GLICEMIA");

INSERT INTO mimos.HealthCheck (idUniquePatient,	idUniqueDoctor, typeCheck, timeCheck, valueCheck) 
values (1, 3, "TEMPERATURA", "2018-07-05 01:19:11", 38.22);
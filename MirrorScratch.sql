DROP DATABASE mimos;
CREATE DATABASE mimos;

CREATE TABLE mimos.MUser(

	idUnique	int auto_increment not null,
	
	nick		varchar(10) not null,
	
    psw			varchar(10) not null,

	sName		varchar(20) not null,

	lName		varchar(15) not null,

	CONSTRAINT PKMUser PRIMARY KEY (idUnique)

);

CREATE TABLE mimos.MAdmin(

	idUnique	int not null,

	isRoot 		boolean,

	CONSTRAINT PKMAdmin PRIMARY KEY (idUnique),

	CONSTRAINT FKMAdmin FOREIGN KEY (idUnique) REFERENCES mimos.MUser(idUnique) ON DELETE CASCADE

);

CREATE TABLE mimos.Patient(

	idUnique			int not null,

	healthInsuranceCard	varchar(16),

	CONSTRAINT PKPatient PRIMARY KEY (idUnique),

	CONSTRAINT FKPatient FOREIGN KEY (idUnique) REFERENCES mimos.MUser(idUnique) ON DELETE CASCADE

);

CREATE TABLE mimos.Doctor(

	idUnique	int not null,

	mainSkill	enum("TEMPERATURA", "GLICEMIA"),

	CONSTRAINT PKDoctor PRIMARY KEY (idUnique),

	CONSTRAINT FKDoctor FOREIGN KEY (idUnique) REFERENCES mimos.MUser(idUnique) ON DELETE CASCADE

);

CREATE TABLE mimos.Pharmacist(

	idUnique	int not null,

	idPharmacy	int(100),

	CONSTRAINT PKPharmacist PRIMARY KEY (idUnique),

	CONSTRAINT FKPharmacist FOREIGN KEY (idUnique) REFERENCES mimos.MUser(idUnique) ON DELETE CASCADE

);

CREATE TABLE mimos.HealthCheck(

	idUniquePatient	int not null,

	idUniqueDoctor	int not null,
	
	typeCheck		enum("TEMPERATURA", "GLICEMIA") not null,

	timeCheck		timestamp not null,
    
    valueCheck		float(10,5) not null,

	CONSTRAINT PKHealthCheck PRIMARY KEY (idUniquePatient, timeCheck),

	CONSTRAINT FKHealthCheckP FOREIGN KEY (idUniquePatient) REFERENCES mimos.Patient(idUnique) ON DELETE CASCADE,
    
    CONSTRAINT FKHealthCheckD FOREIGN KEY (idUniqueDoctor) REFERENCES mimos.Doctor(idUnique) ON DELETE CASCADE

);
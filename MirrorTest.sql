/*DROP DATABASE mimos;*/
USE mimos;

SELECT MUser.nick, Patient.healthInsuranceCard
FROM MUser
LEFT OUTER JOIN Patient ON MUser.idUnique = Patient.IdUnique
WHERE Patient.healthInsuranceCard IS NOT NULL;

select nick, psw, sName, lName, healthInsuranceCard 
from MUser
LEFT OUTER JOIN Patient ON MUser.idUnique = Patient.IdUnique
WHERE Patient.idUnique = 2;

INSERT INTO mimos.Doctor (idUnique, mainSkill) 
values (2, "TEMPERATURA");

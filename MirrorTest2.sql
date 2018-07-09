
USE mimos;

SELECT MUser.nick
FROM Patient
LEFT OUTER JOIN MUser ON MUser.idUnique = Patient.IdUnique
WHERE muser.nick = 'hello';

SELECT madmin.idUnique
FROM madmin
where madmin.idUnique = 2;

UPDATE Patient
SET Patient.healthInsuranceCard = 09812383811
WHERE idUnique = 2;
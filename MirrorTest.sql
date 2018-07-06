/*DROP DATABASE mimos;*/
USE mimos;

SELECT MUser.nick, Patient.healthInsuranceCard
FROM MUser
LEFT OUTER JOIN Patient ON MUser.idUnique = Patient.IdUnique
WHERE Patient.healthInsuranceCard IS NOT NULL;
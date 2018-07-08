
USE mimos;

SELECT MUser.nick, Patient.healthInsuranceCard
FROM MUser
LEFT OUTER JOIN Patient ON MUser.idUnique = Patient.IdUnique
WHERE muser.nick = "mydoc";
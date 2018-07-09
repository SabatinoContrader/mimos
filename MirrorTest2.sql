
USE mimos;

SELECT MUser.nick
FROM Patient
LEFT OUTER JOIN MUser ON MUser.idUnique = Patient.IdUnique
WHERE muser.nick = 'hello';

SELECT madmin.idUnique
FROM madmin
where madmin.idUnique = 2;

SELECT MUser.nick
FROM Patient
LEFT OUTER JOIN MUser ON MUser.idUnique = Patient.IdUnique
LEFT OUTER JOIN Patient ON Patient.idUnique = Doctor.IdUnique
WHERE muser.nick = 'hello';
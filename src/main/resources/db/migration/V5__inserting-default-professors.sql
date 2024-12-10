/* CREATING DEFAULT PROFESSORS */

/* CREATING PROFESSOR AFFILIATIONS */

INSERT INTO tab_affiliation (id, user_id, status, starting_date)
values('b81c0ddd-c504-471f-b796-65c1463dca7f','19a14dd6-52d0-42f8-b27b-a813bb0a3124', 'ACTIVE', '01-01-2000');

INSERT INTO tab_affiliation (id, user_id, status, starting_date)
values('40785ccb-91d0-48ea-963b-15dce5c11d77', '7087dc13-753a-4c62-b86b-06d0730e745d', 'ACTIVE', '01-01-2000');

/* CREATING PUBLIC SERVANT AFFILIATIONS */

INSERT INTO tab_public_servant (id, siape, education_level, department_id)
values('b81c0ddd-c504-471f-b796-65c1463dca7f',
       '3333333333',
       'DOCTORATE',
       '16fb6a0c-74c1-4654-be21-aa3bc226e89b'
);

INSERT INTO tab_public_servant (id, siape, education_level, department_id)
values('40785ccb-91d0-48ea-963b-15dce5c11d77',
       '4444444444',
       'DOCTORATE',
       '16fb6a0c-74c1-4654-be21-aa3bc226e89b'
);

/* CREATING PROFESSORS */

INSERT INTO tab_professor (id, institutional_email)
values('b81c0ddd-c504-471f-b796-65c1463dca7f', 'ivo.calado@ifal.edu.br');

INSERT INTO tab_professor (id, institutional_email)
values('40785ccb-91d0-48ea-963b-15dce5c11d77', 'wladia@ifal.edu.br');
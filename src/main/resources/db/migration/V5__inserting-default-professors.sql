/* CREATING DEFAULT PROFESSORS */

/* CREATING PROFESSOR AFFILIATIONS */

INSERT INTO tab_affiliation (id, user_id, status, starting_date, created_at)
values('b81c0ddd-c504-471f-b796-65c1463dca7f','19a14dd6-52d0-42f8-b27b-a813bb0a3124', 'ACTIVE', '01-01-2000', '2024-12-10 10:00:00.000000000');

INSERT INTO tab_affiliation (id, user_id, status, starting_date, created_at)
values('40785ccb-91d0-48ea-963b-15dce5c11d77', '7087dc13-753a-4c62-b86b-06d0730e745d', 'ACTIVE', '01-01-2000', '2024-12-11 10:00:00.000000000');

/* CREATING PUBLIC SERVANT AFFILIATIONS */

INSERT INTO tab_public_servant (affiliation_id, siape, education_level, department_id)
values('b81c0ddd-c504-471f-b796-65c1463dca7f',
       '3333333',
       'DOCTORATE',
       '16fb6a0c-74c1-4654-be21-aa3bc226e89b'
);

INSERT INTO tab_public_servant (affiliation_id, siape, education_level, department_id)
values('40785ccb-91d0-48ea-963b-15dce5c11d77',
       '4444444',
       'DOCTORATE',
       '16fb6a0c-74c1-4654-be21-aa3bc226e89b'
);

/* CREATING PROFESSORS */

INSERT INTO tab_professor (affiliation_id, institutional_email)
values('b81c0ddd-c504-471f-b796-65c1463dca7f', 'wladia@ifal.edu.br');

INSERT INTO tab_professor (affiliation_id, institutional_email)
values('40785ccb-91d0-48ea-963b-15dce5c11d77', 'ivo.calado@ifal.edu.br');
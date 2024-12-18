/* CREATING DEFAULT STUDENTS */

/* CREATING STUDENTS AFFILIATIONS */

INSERT INTO tab_affiliation (id, user_id, status, starting_date, created_at)
values('5d19f85e-e3de-45d7-8b49-8d9ea1d52e4d','97e85d7b-5087-44d3-9dd3-abc8edc29c04', 'ACTIVE', '01-01-2000', '2024-12-10 10:00:00.000000000');

/* CREATING STUDENTS */

INSERT INTO tab_student (affiliation_id, enrollment, course_id, institutional_email)
values('5d19f85e-e3de-45d7-8b49-8d9ea1d52e4d', '1111111111', '0257e913-17cd-4e0b-84a4-27432b37365a', 'menino@aluno.ifal.edu.br');

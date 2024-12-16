-- noinspection SqlDialectInspectionForFile

/* CREATING USERS */

INSERT INTO tab_user (id, cpf, name, surname, birthdate, email, username, password, created_at)
values('d67d42d8-0976-4d37-8802-504c8cb12d0c',
       11111111111,
       'Administrator',
       'SIGHAS',
       '01-01-2000',
       'admin@sighas.com',
       'admin',
       '{bcrypt}$2a$10$nYH.IaeFA9RJ3Cu.JapIjeoAU.b.6aLyv5krP93BxCqC/jpnqEr8m', /*admin*/
       '2024-12-01 10:01:00.000000000'
);

INSERT INTO tab_user (id, cpf, name, surname, birthdate, email, username, password, created_at)
values('45bf3d69-1ad7-438d-bdfd-6d8e0aaec9a7',
       22222222222,
       'User',
       'SIGHAS',
       '01-01-2000',
       'user@sighas.com',
       'user',
       '{bcrypt}$2a$10$pZG3HyqAyvLUf/KweFpQe.XU4/ZJ66joTkENLQJlFEQGBc/dXAUbq', /*user*/
       '2024-12-02 10:01:00.000000000'
);

INSERT INTO tab_user (id, cpf, name, surname, birthdate, email, username, password, created_at)
values('19a14dd6-52d0-42f8-b27b-a813bb0a3124',
       33333333333,
       'Wladia',
       'Bessa',
       '01-01-2000',
       'wladia@sighas.com',
       'wladia',
       '{bcrypt}$2a$10$vH7NBGKaSdbbz9In/1rRyOJPSb34MWHDb5OVlNlh980EDiJpar94e', /*wladia*/
       '2024-12-03 10:01:00.000000000'
);

INSERT INTO tab_user (id, cpf, name, surname, birthdate, email, username, password, created_at)
values('7087dc13-753a-4c62-b86b-06d0730e745d',
       44444444444,
       'Ivo',
       'Calado',
       '01-01-2000',
       'ivo@sighas.com',
       'ivo',
       '{bcrypt}$2a$10$0Tlwg9D2mKrrK76T6ukjBun8P7M96VhrS1SJHbw.tzo6McoUB53iu', /*ivo*/
       '2024-12-04 10:01:00.000000000'
);

INSERT INTO tab_user (id, cpf, name, surname, birthdate, email, username, password, created_at)
values('97e85d7b-5087-44d3-9dd3-abc8edc29c04',
       55555555555,
       'Menino',
       'Lindu',
       '01-01-2000',
       'menino@sighas.com',
       'menino',
       '{bcrypt}$2a$10$cl6.kl1bj81dZgWgOYaC4uSiGk0AUmtvCd/8xKOOstfhKiC927C2a', /*menino*/
       '2024-12-05 10:01:00.000000000'
);

/* SETTING ROLES TO DEFAULT USERS */

INSERT INTO tab_user_has_role (user_id, user_role_id)
values('d67d42d8-0976-4d37-8802-504c8cb12d0c',
       0
);

INSERT INTO tab_user_has_role (user_id, user_role_id)
values('45bf3d69-1ad7-438d-bdfd-6d8e0aaec9a7',
       1
);

INSERT INTO tab_user_has_role (user_id, user_role_id)
values('19a14dd6-52d0-42f8-b27b-a813bb0a3124',
       1
);

INSERT INTO tab_user_has_role (user_id, user_role_id)
values('7087dc13-753a-4c62-b86b-06d0730e745d',
       1
);

INSERT INTO tab_user_has_role (user_id, user_role_id)
values('97e85d7b-5087-44d3-9dd3-abc8edc29c04',
       1
);
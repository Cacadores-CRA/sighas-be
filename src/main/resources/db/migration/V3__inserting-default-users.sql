/* CREATING USERS */

INSERT INTO tab_user (id, cpf, name, surname, birthdate, email, username, password)
values('d67d42d8-0976-4d37-8802-504c8cb12d0c',
       11111111111,
       'Administrator',
       'SIGHAS',
       '01-01-2000',
       'admin@sighas.com',
       'admin',
       'admin'
);

INSERT INTO tab_user (id, cpf, name, surname, birthdate, email, username, password)
values('45bf3d69-1ad7-438d-bdfd-6d8e0aaec9a7',
       22222222222,
       'User',
       'SIGHAS',
       '01-01-2000',
       'user@sighas.com',
       'user',
       'user'
);

INSERT INTO tab_user (id, cpf, name, surname, birthdate, email, username, password)
values('19a14dd6-52d0-42f8-b27b-a813bb0a3124',
       33333333333,
       'Wladia',
       'Bessa',
       '01-01-2000',
       'wladia@sighas.com',
       'wladia',
       'wladia'
);

INSERT INTO tab_user (id, cpf, name, surname, birthdate, email, username, password)
values('7087dc13-753a-4c62-b86b-06d0730e745d',
       44444444444,
       'Ivo',
       'Calado',
       '01-01-2000',
       'ivo@sighas.com',
       'ivo',
       'ivo'
);

INSERT INTO tab_user (id, cpf, name, surname, birthdate, email, username, password)
values('97e85d7b-5087-44d3-9dd3-abc8edc29c04',
       55555555555,
       'Minininho',
       'Lindu',
       '01-01-2000',
       'mininihu@sighas.com',
       'mininihu',
       'mininihu'
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
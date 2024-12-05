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

/* SETTING ROLES TO DEFAULT USERS */

INSERT INTO tab_user_has_role (user_id, user_role_id)
values('d67d42d8-0976-4d37-8802-504c8cb12d0c',
       0
);

INSERT INTO tab_user_has_role (user_id, user_role_id)
values('45bf3d69-1ad7-438d-bdfd-6d8e0aaec9a7',
       1
);
insert into category values (1, 'Multimedia');
insert into category values (2, 'Clothes');

insert into shop values (1, '/images', 'Fnac', 1);
insert into shop values (2, '/images', 'Celio', 2);

insert into city values (1, 'France', 'Le Mans');
insert into city values (2, 'France', 'Paris');

insert into user values (1, 'User 1', 'test', 'ROLE_USER', 'user1@test.com', 1);

insert into delivery_type values (1, 'Main propre');
insert into delivery_type values (2, 'Poste');

insert into proposal values (1, 'Service 1', 'Titre 1', '10', true, 1, 2, 1);
insert into proposal values (2, 'Service 2', 'Titre 2', '20', true, 2, 1, 1);

insert into PROPOSAL_DELIVERY_TYPES values (1, 1);
insert into PROPOSAL_DELIVERY_TYPES values (1, 2);
insert into PROPOSAL_DELIVERY_TYPES values (2, 1);
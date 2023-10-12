CREATE TABLE categoria (
   id binary(16) primary key,
   titulo VARCHAR(255) NOT NULL
);


INSERT INTO categoria (id, titulo) VALUES (UUID_TO_BIN('028bd56a-6884-11ee-8c99-0242ac120002'), 'Eletrônicos');
INSERT INTO categoria (id, titulo) VALUES (UUID_TO_BIN('0d8023e0-6884-11ee-8c99-0242ac120002'), 'Livros');
INSERT INTO categoria (id, titulo) VALUES (UUID_TO_BIN('1106a6b0-6884-11ee-8c99-0242ac120002'), 'Informática');
INSERT INTO categoria (id, titulo) VALUES (UUID_TO_BIN('1509d1b0-6884-11ee-8c99-0242ac120002'), 'Ferramentas');



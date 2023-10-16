CREATE TABLE categoria (
   id binary(16) primary key,
   titulo VARCHAR(255) NOT NULL,
   estado TINYINT
);


INSERT INTO categoria (id, titulo, estado) VALUES
(UUID_TO_BIN('028bd56a-6884-11ee-8c99-0242ac120002'), 'Eletrônicos', 1),
(UUID_TO_BIN('0d8023e0-6884-11ee-8c99-0242ac120002'), 'Livros', 1),
(UUID_TO_BIN('1106a6b0-6884-11ee-8c99-0242ac120002'), 'Informática', 1),
(UUID_TO_BIN('1509d1b0-6884-11ee-8c99-0242ac120002'), 'Ferramentas', 1);



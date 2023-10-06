CREATE TABLE categoria (
    idcategoria BINARY(16) PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL
);

INSERT INTO categoria (idcategoria, titulo) VALUES (UUID_TO_BIN('95c4c8da-644e-11ee-8c99-0242ac120002'), 'Eletrônicos');
INSERT INTO categoria (idcategoria, titulo) VALUES (UUID_TO_BIN('a0ac9cc8-644e-11ee-8c99-0242ac120002'), 'Livros');
INSERT INTO categoria (idcategoria, titulo) VALUES (UUID_TO_BIN('a58b848e-644e-11ee-8c99-0242ac120002'), 'Informática');
INSERT INTO categoria (idcategoria, titulo) VALUES (UUID_TO_BIN('add9cad8-644e-11ee-8c99-0242ac120002'), 'Ferramentas');



CREATE TABLE categoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL
);

INSERT INTO categoria (id, titulo) VALUES (1, 'Eletrônicos');
INSERT INTO categoria (id, titulo) VALUES (2, 'Livros');
INSERT INTO categoria (id, titulo) VALUES (3, 'Informática');
INSERT INTO categoria (id, titulo) VALUES (4, 'Ferramentas');



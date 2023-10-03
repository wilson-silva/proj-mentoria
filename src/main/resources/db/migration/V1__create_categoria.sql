CREATE TABLE tb_categorias (
    idcategoria BINARY(16) PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL
);

INSERT INTO tb_categorias (idcategoria, titulo) VALUES (UUID_TO_BIN(UUID()), 'Eletrônicos');
INSERT INTO tb_categorias (idcategoria, titulo) VALUES (UUID_TO_BIN(UUID()), 'Livros');
INSERT INTO tb_categorias (idcategoria, titulo) VALUES (UUID_TO_BIN(UUID()), 'Informática');
INSERT INTO tb_categorias (idcategoria, titulo) VALUES (UUID_TO_BIN(UUID()), 'Ferramentas');

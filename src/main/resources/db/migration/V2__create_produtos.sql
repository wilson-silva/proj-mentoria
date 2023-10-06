CREATE TABLE produto (
  idproduto BINARY(16) PRIMARY KEY NOT NULL,
  nome VARCHAR(45) NOT NULL,
  descricao VARCHAR(45) NOT NULL,
  preco DECIMAL(10,2) NOT NULL,
  estoque INT NOT NULL,
  fabricante VARCHAR(45) NOT NULL,
  id_categoria BINARY(16),
  CONSTRAINT fk_produto_categoria FOREIGN KEY (id_categoria) REFERENCES categoria(idcategoria)
);


INSERT INTO produto (idproduto, nome, descricao, preco, estoque, fabricante, id_categoria)
VALUES (UUID_TO_BIN(UUID()), 'Notebook','Dell 2023', 3000, 100, 'DELL', UUID_TO_BIN('a58b848e-644e-11ee-8c99-0242ac120002'));

INSERT INTO produto (idproduto, nome, descricao, preco, estoque, fabricante, id_categoria)
VALUES (UUID_TO_BIN(UUID()), 'O Hobbit','Livro fantasia', 120, 100, 'Editora X', UUID_TO_BIN('a0ac9cc8-644e-11ee-8c99-0242ac120002'));

INSERT INTO produto (idproduto, nome, descricao, preco, estoque, fabricante, id_categoria)
VALUES (UUID_TO_BIN(UUID()), 'Microondas','porte pequeno', 1500, 100, 'Philips', UUID_TO_BIN('95c4c8da-644e-11ee-8c99-0242ac120002'));

INSERT INTO produto (idproduto, nome, descricao, preco, estoque, fabricante, id_categoria)
VALUES (UUID_TO_BIN(UUID()), 'Furadeira','furadeira e parafusadeira', 2500, 100, 'Bosh', UUID_TO_BIN('add9cad8-644e-11ee-8c99-0242ac120002'));






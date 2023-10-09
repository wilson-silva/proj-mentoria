CREATE TABLE produto (
  idproduto BINARY(16) PRIMARY KEY NOT NULL,
  nome VARCHAR(45) NOT NULL,
  descricao VARCHAR(45) NOT NULL,
  preco DECIMAL(10,2) NOT NULL,
  estoque INT NOT NULL,
  fabricante VARCHAR(45) NOT NULL,
  categoria_id BIGINT,
  CONSTRAINT fk_produto_categoria FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);


INSERT INTO produto (idproduto, nome, descricao, preco, estoque, fabricante, categoria_id)
VALUES (UUID_TO_BIN(UUID()), 'Notebook','Dell 2023', 3000, 100, 'DELL', 3);

INSERT INTO produto (idproduto, nome, descricao, preco, estoque, fabricante, categoria_id)
VALUES (UUID_TO_BIN(UUID()), 'O Hobbit','Livro fantasia', 120, 100, 'Editora X', 2);

INSERT INTO produto (idproduto, nome, descricao, preco, estoque, fabricante, categoria_id)
VALUES (UUID_TO_BIN(UUID()), 'Microondas','porte pequeno', 1500, 100, 'Philips', 1);

INSERT INTO produto (idproduto, nome, descricao, preco, estoque, fabricante, categoria_id)
VALUES (UUID_TO_BIN(UUID()), 'Furadeira','furadeira e parafusadeira', 2500, 100, 'Bosh', 4);






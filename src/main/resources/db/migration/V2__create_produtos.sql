CREATE TABLE produto (
  idproduto BINARY(16) PRIMARY KEY NOT NULL,
  nome VARCHAR(45) NOT NULL,
  descricao VARCHAR(45) NOT NULL,
  preco DECIMAL(10,2) NOT NULL,
  estoque INT NOT NULL,
  estado TINYINT,
  fabricante VARCHAR(45) NOT NULL,
  categoria_id BINARY(16),
  CONSTRAINT fk_produto_categoria FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);


INSERT INTO produto (idproduto, nome, descricao, preco, estoque, estado, fabricante, categoria_id) VALUES
(UUID_TO_BIN(UUID()), 'Notebook', 'Dell 2023', 3000, 100, 1, 'DELL', UUID_TO_BIN('028bd56a-6884-11ee-8c99-0242ac120002')),
(UUID_TO_BIN(UUID()), 'O Hobbit', 'Livro fantasia', 120, 100, 1, 'Editora X', UUID_TO_BIN('0d8023e0-6884-11ee-8c99-0242ac120002')),
(UUID_TO_BIN(UUID()), 'Microondas', 'porte pequeno', 1500, 100, 1, 'Philips', UUID_TO_BIN('1106a6b0-6884-11ee-8c99-0242ac120002')),
(UUID_TO_BIN(UUID()), 'Furadeira', 'furadeira e parafusadeira', 2500, 100, 1, 'Bosh', UUID_TO_BIN('1509d1b0-6884-11ee-8c99-0242ac120002'));






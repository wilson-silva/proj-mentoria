# mentoria

<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>

## Sobre o projeto

Demanda: Desenvolvimento de API de Produtos Para servir de Catálogo para nosso ecommerce.
Descrição da Demanda: Estamos buscando criar uma API robusta de gerenciamento de produtos. 
A API será fundamental para o nosso sistema de comércio eletrônico, permitindo a criação, leitura, 
atualização e exclusão de produtos. Além disso, a API deve ser escalável e segura, garantindo que as 
informações dos produtos sejam acessadas apenas por usuários autorizados.


Pré-requisitos:

* Java 17 ou versões superiores.
* Intellj IDEA Community Edition ou sua IDE favorita.
* Controle de versão GIT instalado na sua máquina.
* Banco MySQL (recomenda-se usar container caso não queira baixar o MySQL na máquina).

```bash

### docker-compose.yml
Colocar na raiz do projeto e rodar o container

version: '3.1'
services:
  db:
    image: mysql
    container_name: mysql
    environment:
      MYSQL_ROOT_PASSWORD: root
    ports:
      - "3306:3306"
    volumes:
      - mentoria_data:/var/lib/mysql

volumes:
  devdojo_data:

```

```bash

# clonar repositório
git clone https://github.com/wilson-silva/mentoria.git


# --- Rodar aplicação videoflix ---

# entrar na pasta do projeto videoflix
cd aluraflix ou abrir o bash dentro da pasta

# executar o projeto
./mvnw spring-boot:run

```

### Técnicas e tecnologias utilizadas
- Java
- Intellij
- Spring Boot
- Maven
- MySQL
- Flyway


### Autor
Wilson Gimenes da Silva


https://github.com/wilson-silva/mentoria
CREATE DATABASE db_pizzaria_legal;

USE db_pizzaria_legal;
CREATE TABLE tb_categoria(
	id_categoria BIGINT AUTO_INCREMENT,
	tipo VARCHAR(250) NOT NULL,
	tamanho VARCHAR(250) NOT NULL,
    
    PRIMARY KEY(id_categoria)
);

CREATE TABLE tb_pizzas(
	id_pizza BIGINT AUTO_INCREMENT,
	nome_pizza VARCHAR(250) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    borda_recheada BOOLEAN NOT NULL,
    fk_id_categoria BIGINT,
    
    PRIMARY KEY(id_pizza),
    FOREIGN KEY(fk_id_categoria) REFERENCES tb_categoria(id_categoria)
);

INSERT INTO tb_categoria(tipo, tamanho) VALUES
("Salgada", "Grande"),
("Doce", "Grande"),
("Salgada","Media"),
("Doce","Media"),
("Salgada","Broto"),
("Doce","Broto");


INSERT INTO tb_pizzas(nome_pizza, preco, borda_recheada, fk_id_categoria) VALUES
("Vrango com Cheddar", 47, 1, 1),
("Mix de Cogumelos", 35, 0, 1),
("Brigadeiro", 45, 0, 2),
("Sensação", 30, 0, 4),
("Prestígio", 20, 0, 6),
("Jaca Crazy", 25.90, 1, 5),
("Caponata", 31.70, 0, 3);

SELECT * FROM tb_pizzas WHERE preco > 45;
SELECT * FROM tb_pizzas WHERE preco BETWEEN 29 AND 60;
SELECT * FROM tb_pizzas WHERE nome_pizza LIKE "%c%";

SELECT * FROM tb_pizzas INNER JOIN tb_categoria ON tb_pizzas.fk_id_categoria = tb_categoria.id_categoria;

SELECT tb_pizzas.nome_pizza AS Pizza, tb_categoria.tipo AS TIPO, tb_categoria.tamanho AS TAMANHO
FROM tb_pizzas INNER JOIN tb_categoria ON tb_pizzas.fk_id_categoria = tb_categoria.id_categoria
WHERE tb_categoria.tipo = "Doce";

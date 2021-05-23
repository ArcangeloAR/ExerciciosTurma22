CREATE DATABASE db_cidade_das_frutas;

USE db_cidade_das_frutas;
CREATE TABLE tb_categoria(
	id_categoria BIGINT AUTO_INCREMENT,
    nome_categoria VARCHAR(255) NOT NULL,
    familia_categoria VARCHAR(255) NOT NULL,
    
    PRIMARY KEY(id_categoria)
);

CREATE TABLE tb_produto(
	id_produto BIGINT AUTO_INCREMENT,
    nome_produto VARCHAR(255) NOT NULL,
    preco_produto DECIMAL(10, 2) NOT NULL,
    cor_produto VARCHAR(255) NOT NULL,
    fk_tb_categoria BIGINT,
    
    PRIMARY KEY(id_produto),
    FOREIGN KEY(fk_tb_categoria) REFERENCES tb_categoria(id_categoria)
);

INSERT INTO tb_categoria(nome_categoria, familia_categoria) VALUES
("Folha", "Asteraceae"),
("Legume", "Cucurbitaceae"),
("Tubérculo", "Solanaceae"),
("Fruta", "Rutáceas"),
("Fruta", "Cucurbitaceae");

INSERT INTO tb_produto(nome_produto, preco_produto, cor_produto, fk_tb_categoria) VALUES
("Alface", 2.00, "Verde", 1),
("Melancia", 20.00, "Verde", 5),
("Laranja", 6.00, "Laranja", 4),
("Batata", 3.00, "Amarelo", 3),
("Serralha", 6.00, "Verde", 1),
("Mexerica", 4.00, "Laranja", 4),
("Melão", 20.00, "Amarelo", 5),
("Abobrinha", 1.00, "Verde", 2);

SELECT * FROM tb_produto WHERE preco_produto > 50;
SELECT * FROM tb_produto WHERE preco_produto BETWEEN 3 AND 60;
SELECT * FROM tb_produto WHERE nome_produto LIKE "%c%";

SELECT * FROM tb_produto INNER JOIN tb_categoria ON tb_produto.fk_tb_categoria = tb_categoria.id_categoria;


SELECT * FROM tb_produto INNER JOIN tb_categoria ON tb_produto.fk_tb_categoria = tb_categoria.id_categoria
WHERE nome_categoria = "Fruta";

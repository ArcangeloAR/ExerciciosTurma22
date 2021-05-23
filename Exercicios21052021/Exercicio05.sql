CREATE DATABASE db_construindo_a_nossa_vida;

USE db_construindo_a_nossa_vida;
CREATE TABLE tb_categoria(
	id_categoria BIGINT AUTO_INCREMENT,
    nome_categoria VARCHAR(255) NOT NULL,
    tipo_categoria VARCHAR(255) NOT NULL,
    
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
("Porcelanato", "Piso"),
("Azulejo", "Revestimento"),
("Pastilha", "Revestimento"),
("Taco", "Piso"),
("Capacete", "EPI");

INSERT INTO tb_produto(nome_produto, preco_produto, cor_produto, fk_tb_categoria) VALUES
("Pandora", 32.90, "Marrom", 1),
("WPS0871", 7.59, "Azul", 5),
("Triunfo", 24.90, "Marrom", 4),
("Portinari", 899.90, "Branco", 3),
("Athea", 209.99, "Branco", 1),
("Bold", 23.90, "Marrom", 4),
("Diamond", 36.90, "Amarelo", 5),
("Linha", 20.90, "Branco", 2);

SELECT * FROM tb_produto WHERE preco_produto > 50;
SELECT * FROM tb_produto WHERE preco_produto BETWEEN 3 AND 60;
SELECT * FROM tb_produto WHERE nome_produto LIKE "%c%";

SELECT * FROM tb_produto INNER JOIN tb_categoria ON tb_produto.fk_tb_categoria = tb_categoria.id_categoria;


SELECT * FROM tb_produto INNER JOIN tb_categoria ON tb_produto.fk_tb_categoria = tb_categoria.id_categoria
WHERE tipo_categoria = "Piso";

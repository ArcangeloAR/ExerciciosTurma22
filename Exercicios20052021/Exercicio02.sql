CREATE DATABASE db_ecommerce;

USE db_ecommerce;
CREATE TABLE tb_produtos(
	id_produto BIGINT AUTO_INCREMENT,
    nome VARCHAR(250) NOT NULL,
    preco decimal(10,2) NOT NULL,
    quantidade INT NOT NULL,
	em_estoque BOOLEAN NOT NULL,
    PRIMARY KEY(id_produto)
);

INSERT INTO tb_produtos(nome, preco, quantidade, em_estoque) 
VALUES 
("Back Lotus", 39999.99, 0, false),
("Time Walk", 10900.99, 1, true),
("Candelabra of Tawnos", 6900.99, 1, true),
("Wheel of Fortune", 2750.00, 0, false),
("Demonic Tutor", 175.00, 2, true),
("Ugin, the Spirit Dragon", 134.99, 1, true),
("Tarmogoyf", 124.88, 2, true),
("Thalia, Guardian of Thraben", 34.90, 1, true);


SELECT * FROM tb_produtos WHERE preco > 500;
SELECT * FROM tb_produtos WHERE preco < 500;

UPDATE tb_produtos
SET quantidade=1, em_estoque=true
WHERE id_produto = 1;

SELECT * FROM tb_produtos;
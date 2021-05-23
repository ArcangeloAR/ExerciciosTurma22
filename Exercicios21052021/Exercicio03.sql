CREATE DATABASE db_farmacia_do_bem;

USE db_farmacia_do_bem;
CREATE TABLE tb_categoria(
	id_categoria BIGINT AUTO_INCREMENT,
    nome_categoria VARCHAR(250) NOT NULL,
    tipo VARCHAR(250) NULL,
    
    PRIMARY KEY (id_categoria)
);

CREATE TABLE tb_produto(
	id_produto BIGINT AUTO_INCREMENT,
    nome_produto VARCHAR(250) NOT NULL,
    preco_produto DECIMAL(10,2) NOT NULL,
    em_estoque BOOLEAN NOT NULL,
    fk_id_categoria BIGINT,
    
    PRIMARY KEY(id_produto),
    FOREIGN KEY(fk_id_categoria) REFERENCES tb_categoria(id_categoria)
);

INSERT INTO tb_categoria(nome_categoria, tipo) VALUES
("Xarope", "Líquido"),
("Analgésico", "Capsula"),
("Analgésico", "Comprimido"),
("Antiácido", "Pastilha"),
("Antiácido", "Em pó");

INSERT INTO tb_produto(nome_produto, preco_produto, em_estoque, fk_id_categoria) VALUES
("Advil", 12.90, 1, 2),
("Neosaldina", 26.79, 1, 3),
("Guaco Edulito", 19.49, 0, 1),
("Flumucil", 29.90, 1, 1),
("Eno", 6, 1, 4),
("Lisador", 32.90, 0, 3),
("Novalgina", 17.90, 0, 3),
("Estomazil", 7.90, 1, 1);

SELECT * FROM tb_produto WHERE preco_produto > 50;
SELECT * FROM tb_produto WHERE preco_produto BETWEEN 3 AND 60;
SELECT * FROM tb_produto WHERE nome_produto LIKE "%b%";

SELECT * FROM tb_produto INNER JOIN tb_categoria ON tb_produto.fk_id_categoria = tb_categoria.id_categoria;

SELECT * FROM tb_produto INNER JOIN tb_categoria ON tb_produto.fk_id_categoria = tb_categoria.id_categoria
WHERE tb_categoria.nome_categoria = "Antiácido";

CREATE DATABASE db_rh;

USE db_rh;
CREATE TABLE tb_colaboradores(
	id_colaborador BIGINT AUTO_INCREMENT,
    nome VARCHAR(250) NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    setor VARCHAR(250) NOT NULL,
    data_inicio DATE,
    data_saida DATE NULL,
    
    PRIMARY KEY(id_colaborador)
);

INSERT INTO tb_colaboradores(nome, salario, setor, data_inicio, data_saida) 
VALUES 
("Michael Scott", 5000.00,"Gerência Geral", "2005-03-24","2011-04-28"),
("Pamela Morgan Beesly", 2700.00,"Vendas", "2005-03-24", NULL),
("James Halpert", 1800.00,"Vendas", "2005-03-24", NULL),
("Dwight Schrute", 1800.00,"Vendas", "2005-03-24", NULL),
("Holly Flax", 4500.00,"Departamento Pessoal", "2008-05-15","2011-04-28");

SELECT * FROM tb_colaboradores WHERE salario > 2000;
SELECT * FROM tb_colaboradores WHERE salario < 2000;

UPDATE tb_colaboradores 
SET salario=5500.50 
WHERE id_colaborador = 1;

SELECT * FROM tb_colaboradores;

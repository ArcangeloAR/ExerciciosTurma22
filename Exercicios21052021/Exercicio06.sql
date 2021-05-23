CREATE DATABASE db_cursoDaMinhaVida;

USE db_cursoDaMinhaVida;
CREATE TABLE tb_categoria(
	id_categoria BIGINT AUTO_INCREMENT,
    nome_categoria VARCHAR(255),
    area_curso VARCHAR(255),
    
    PRIMARY KEY(id_categoria)
);

CREATE TABLE tb_curso(
	id_curso BIGINT AUTO_INCREMENT,
    nome_curso VARCHAR(255),
    certificado BOOLEAN,
    tempo_duracao TIME,
    fk_tb_categoria BIGINT,
    
    PRIMARY KEY(id_curso),
    FOREIGN KEY(fk_tb_categoria) REFERENCES 
    tb_categoria(id_categoria)
);

INSERT INTO tb_categoria(nome_categoria, tipo_categoria) VALUES
("Bacharel", "Ciências Humanas"),
("Tecnólogo", "Ciências Humanas"),
("Licenciatura", "Ciências Humanas"),
("Bacharel", "Ciências Exatas"),
("Licenciatura", "Ciências da Natureza");

INSERT INTO tb_curso(nome_curso, certificado, tempo_duracao, fk_tb_categoria) VALUES
("Administração", TRUE, "400:00:00", 1),
("Fotografia", TRUE, "300:00:00", 2),
("Engenharia Elétrica", TRUE, "500:00:00", 4),
("Engenharia da Computação", TRUE, "300:00:00", 4),
("Biologia", TRUE, "400:00:00", 5),
("Secretariado", TRUE, "300:00:00", 2),
("Geologia", TRUE, "400:00:00", 5),
("Psicologia", TRUE, "400:00:00", 3);

SELECT * FROM tb_curso WHERE tempo_duracao > "500:00:00";
SELECT * FROM tb_curso WHERE tempo_duracao BETWEEN "300:00:00" AND "600:00:00";
SELECT * FROM tb_curso WHERE nome_curso LIKE "%f%";

SELECT * FROM tb_curso INNER JOIN tb_categoria ON fk_tb_categoria = id_categoria; 

SELECT * FROM tb_curso INNER JOIN tb_categoria ON fk_tb_categoria = id_categoria
WHERE nome_categoria = "Bacharel";







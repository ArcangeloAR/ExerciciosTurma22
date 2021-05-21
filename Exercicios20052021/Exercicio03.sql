CREATE DATABASE db_escola;

USE db_escola;
CREATE TABLE tb_alunes(
	id_alune BIGINT AUTO_INCREMENT,
    nome VARCHAR(250) NOT NULL,
    nota DECIMAL(10,2) NOT NULL,
    matricula INT NOT NULL,
	email VARCHAR(250) NULL,
    
    PRIMARY KEY(id_alune)
);

INSERT INTO tb_alunes(nome, nota, matricula, email) 
VALUES 
("Harry Potter", 7.5, 31071980, "harrypotter@hogwarts.com"),
("Hermione Granger", 10.0, 19071979, "hermionegranger@hogwarts.com"),
("Ronald Weasley", 5.5, 1031980, "ronaldweasley@hogwarts.com"),
("Luna Lovegood", 8.5, 13021981, "lunalovegood@hogwarts.com"),
("Neville Longbottom", 6.5, 30071980, "nevillelongbottom@hogwarts.com"),
("Draco Malfoy", 7.5, 5061980, "dracomalfoy@hogwarts.com"),
("Ginevra Molly Weasley", 9.0, 11081981, "ginevraweasley@hogwarts.com"),
("Tom Servolo Riddle", 10.0, 31121926, NULL);

SELECT * FROM tb_alunes WHERE nota > 7;
SELECT * FROM tb_alunes WHERE nota < 7;

SET SQL_SAFE_UPDATES = 0;
UPDATE tb_alunes 
SET nota=7 
WHERE nome = "Neville Longbottom";

SELECT * FROM tb_alunes;

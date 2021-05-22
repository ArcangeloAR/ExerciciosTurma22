CREATE DATABASE db_generation_game_online;

USE db_generation_game_online;
CREATE TABLE tb_classes(
	id_classe BIGINT AUTO_INCREMENT,
    nome_classe VARCHAR(250) NOT NULL,
    forca INT NOT NULL,
    agilidade INT NOT NULL,
    inteligencia INT NOT NULL,
    
    UNIQUE(nome_classe),
    PRIMARY KEY(id_classe)
);

CREATE TABLE tb_personagens(
	id_personagem BIGINT AUTO_INCREMENT,
	nome_personagem VARCHAR(250) NOT NULL,
    poder_ataque INT NOT NULL,
    poder_defesa INT NOT NULL,
    vida INT NOT NULL,
    fk_id_classe BIGINT,
    
    PRIMARY KEY(id_personagem),
    FOREIGN KEY(fk_id_classe) REFERENCES tb_classes(id_classe)
);

INSERT INTO tb_classes(nome_classe, forca, agilidade, inteligencia) VALUES
("Espadachim", 80, 50, 20),
("Arqueiro", 20, 90, 40),
("Mago", 30, 30, 90),
("Noviço", 40, 40, 70),
("Mercador", 90, 20, 40),
("Gatuno", 50, 90, 10),
("Taekwon", 40, 70, 40),
("Ninja", 40, 80, 30),
("Justiceiro", 30, 80, 40),
("Super Aprendiz", 50, 50, 50);

INSERT INTO tb_personagens(nome_personagem, poder_ataque, poder_defesa, vida, fk_id_classe) VALUES
("Roan", 4000, 7000, 4000, 1),
("Yufa", 2000, 8000, 5000, 4),
("Takios", 8000, 2000, 5000, 3),
("Maya", 6000, 4000, 5000, 5),
("Judia", 7000, 4000, 4000, 2),
("Iruga", 8000, 3000, 4000, 6);

SELECT * FROM tb_personagens WHERE poder_ataque > 2000;
SELECT * FROM tb_personagens WHERE poder_defesa BETWEEN 1000 AND 2000;
SELECT * FROM tb_personagens WHERE nome_personagem LIKE "%c%";

SELECT * FROM tb_personagens INNER JOIN tb_classes ON tb_personagens.fk_id_classe = tb_classes.id_classe;

SELECT tb_personagens.nome_personagem AS Personagem, tb_classes.nome_classe AS Classe
FROM tb_personagens INNER JOIN tb_classes ON tb_personagens.fk_id_classe = tb_classes.id_classe
WHERE tb_classes.nome_classe = "Arqueiro";



CREATE TABLE animais (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    raca VARCHAR(50) NOT NULL,
    sexo VARCHAR(1) NOT NULL,
    castrado smallint not null,
    nascimento date not null,
    especie varchar(20),
    pelagem varchar(20),
    peso float not null,
    status SMALLINT,
    tutor_id BIGINT,
    FOREIGN KEY(tutor_id) REFERENCES tutores(id),
    PRIMARY KEY(id)
) ENGINE=InnoDB;

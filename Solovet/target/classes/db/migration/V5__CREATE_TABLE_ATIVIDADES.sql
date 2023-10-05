CREATE TABLE atividades (
    id BIGINT NOT NULL AUTO_INCREMENT,
    hora_Agendada TIME NOT NULL,
    data_Agendada DATE NOT NULL,
    preco FLOAT NOT NULL,
    descricao VARCHAR(300) NOT NULL,
    status SMALLINT,
    tutor_id BIGINT,
    animal_id BIGINT,
    veterinario_id BIGINT,
    FOREIGN KEY(tutor_id) REFERENCES tutores(id),
    FOREIGN KEY(veterinario_id) REFERENCES veterinarios(id),
    FOREIGN KEY(animal_id) REFERENCES animais(id),
    PRIMARY KEY(id)
) ENGINE=InnoDB;



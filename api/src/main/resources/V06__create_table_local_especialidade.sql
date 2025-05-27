CREATE TABLE local_especialidade (
    id SERIAL PRIMARY KEY,
    id_local INT NOT NULL,
    id_especialidade INT NOT NULL,
    id_semestre INT NOT NULL,
    vagas_manha INT NOT NULL DEFAULT 0,
    vagas_tarde INT NOT NULL DEFAULT 0,
    vagas_noite INT NOT NULL DEFAULT 0,
    FOREIGN KEY (id_local) REFERENCES local(id),
    FOREIGN KEY (id_especialidade) REFERENCES especialidade(id),
    FOREIGN KEY (id_semestre) REFERENCES semestre(id)
);
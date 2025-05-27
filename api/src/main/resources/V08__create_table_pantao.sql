CREATE TABLE plantao (
    id SERIAL PRIMARY KEY,
    data DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fim TIME NOT NULL,
    vagas INT NOT NULL,
    id_local_especialidade INT NOT NULL,
    id_preceptor INT,
    FOREIGN KEY (id_local_especialidade) REFERENCES local_especialidade(id),
    FOREIGN KEY (id_preceptor) REFERENCES usuario(id)
);
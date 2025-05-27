CREATE TABLE periodo_especialidade (
    id SERIAL PRIMARY KEY,
    id_periodo INT NOT NULL,
    id_especialidade INT NOT NULL,
    carga_horaria_minima INT NOT NULL,
    FOREIGN KEY (id_periodo) REFERENCES periodo(id),
    FOREIGN KEY (id_especialidade) REFERENCES especialidade(id)
);

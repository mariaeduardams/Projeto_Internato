CREATE TABLE checkin (
    id SERIAL PRIMARY KEY,
    data_hora_check_in TIMESTAMP NOT NULL,
    data_hora_check_out TIMESTAMP,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    advertencia BOOLEAN NOT NULL DEFAULT false,
    id_plantao_aluno INT NOT NULL,
    FOREIGN KEY (id_plantao_aluno) REFERENCES plantao_aluno(id)
);
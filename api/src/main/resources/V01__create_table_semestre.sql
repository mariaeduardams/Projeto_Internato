CREATE TABLE semestre (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(20) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT true
);

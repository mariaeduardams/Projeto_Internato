CREATE TABLE plantao_aluno (
    id SERIAL PRIMARY KEY,
    id_plantao INT NOT NULL,
    id_aluno INT NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ESCALADO',
    CONSTRAINT unique_plantao_aluno UNIQUE (id_plantao, id_aluno),
    FOREIGN KEY (id_plantao) REFERENCES plantao(id),
    FOREIGN KEY (id_aluno) REFERENCES usuario(id)
);

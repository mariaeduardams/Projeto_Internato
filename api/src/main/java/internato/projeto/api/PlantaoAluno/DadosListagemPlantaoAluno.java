package internato.projeto.api.PlantaoAluno;


public record DadosListagemPlantaoAluno(
        Long id,
        Long idPlantao,
        String aluno,
        String especialidade,
        StatusPlantaoAluno status
) {
    public DadosListagemPlantaoAluno(PlantaoAluno pa) {
        this(
                pa.getId(),
                pa.getPlantao().getId(),
                pa.getAluno().getNome(),
                pa.getPlantao().getLocalEspecialidade().getEspecialidade().getNome(),
                pa.getStatus()
        );
    }
}


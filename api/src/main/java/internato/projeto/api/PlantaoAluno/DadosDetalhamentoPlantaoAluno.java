package internato.projeto.api.PlantaoAluno;


public record DadosDetalhamentoPlantaoAluno(
        Long id,
        Long idPlantao,
        Long idAluno,
        StatusPlantaoAluno status
) {
    public DadosDetalhamentoPlantaoAluno(PlantaoAluno pa) {
        this(pa.getId(), pa.getPlantao().getId(), pa.getAluno().getId(), pa.getStatus());
    }
}


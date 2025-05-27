package internato.projeto.api.PlantaoAluno;


import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPlantaoAluno(
        @NotNull Long id,
        StatusPlantaoAluno status
) {}


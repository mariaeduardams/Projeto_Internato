package internato.projeto.api.PlantaoAluno;


import jakarta.validation.constraints.NotNull;

public record DadosCadastroPlantaoAluno(
        @NotNull Long idPlantao,
        @NotNull Long idAluno
) {}


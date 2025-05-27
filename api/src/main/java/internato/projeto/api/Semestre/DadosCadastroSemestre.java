package internato.projeto.api.Semestre;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroSemestre(
        @NotBlank String descricao,
        @NotNull LocalDate dataInicio,
        @NotNull LocalDate dataFim
) {}

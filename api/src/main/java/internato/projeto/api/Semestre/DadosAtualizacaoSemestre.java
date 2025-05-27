package internato.projeto.api.Semestre;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizacaoSemestre(
        @NotNull Long id,
        String descricao,
        LocalDate dataInicio,
        LocalDate dataFim
) {}

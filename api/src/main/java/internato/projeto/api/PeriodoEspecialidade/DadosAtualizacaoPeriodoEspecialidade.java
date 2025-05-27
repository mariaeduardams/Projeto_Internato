package internato.projeto.api.PeriodoEspecialidade;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPeriodoEspecialidade(
        @NotNull Long id,
        Integer cargaHorariaMinima
) {}


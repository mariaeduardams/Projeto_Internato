package internato.projeto.api.PeriodoEspecialidade;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPeriodoEspecialidade(
        @NotNull Long idPeriodo,
        @NotNull Long idEspecialidade,
        @Min(1) int cargaHorariaMinima
) {}

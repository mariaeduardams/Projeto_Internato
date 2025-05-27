package internato.projeto.api.Plantao;


import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosAtualizacaoPlantao(
        @NotNull Long id,
        LocalDate data,
        LocalTime horaInicio,
        LocalTime horaFim,
        Integer vagas
) {}


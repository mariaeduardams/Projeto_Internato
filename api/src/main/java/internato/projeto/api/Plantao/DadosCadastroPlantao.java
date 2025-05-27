package internato.projeto.api.Plantao;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosCadastroPlantao(
        @NotNull @Future LocalDate data,
        @NotNull LocalTime horaInicio,
        @NotNull LocalTime horaFim,
        @NotNull Integer vagas,
        @NotNull Long idLocalEspecialidade,
        Long idPreceptor
) {}


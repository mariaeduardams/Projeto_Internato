package internato.projeto.api.CheckIn;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroCheckIn(
        @NotNull Long idPlantaoAluno,
        @NotNull LocalDateTime dataHoraCheckIn,
        @NotNull Double latitude,
        @NotNull Double longitude
) {}


package internato.projeto.api.CheckIn;


import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCheckOut(
        @NotNull Long idCheckIn,
        @NotNull LocalDateTime dataHoraCheckOut
) {}


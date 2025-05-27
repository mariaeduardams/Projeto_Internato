package internato.projeto.api.CheckIn;


import java.time.LocalDateTime;

public record DadosDetalhamentoCheckIn(
        Long id,
        Long idPlantaoAluno,
        LocalDateTime dataHoraCheckIn,
        LocalDateTime dataHoraCheckOut,
        Double latitude,
        Double longitude,
        Boolean advertencia
) {
    public DadosDetalhamentoCheckIn(CheckIn check) {
        this(
                check.getId(),
                check.getPlantaoAluno().getId(),
                check.getDataHoraCheckIn(),
                check.getDataHoraCheckOut(),
                check.getLatitude(),
                check.getLongitude(),
                check.getAdvertencia()
        );
    }
}

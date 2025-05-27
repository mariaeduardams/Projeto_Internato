package internato.projeto.api.Plantao;


import java.time.LocalDate;
import java.time.LocalTime;

public record DadosDetalhamentoPlantao(
        Long id,
        LocalDate data,
        LocalTime horaInicio,
        LocalTime horaFim,
        Integer vagas,
        Long idLocalEspecialidade,
        Long idPreceptor
) {
    public DadosDetalhamentoPlantao(Plantao p) {
        this(
                p.getId(),
                p.getData(),
                p.getHoraInicio(),
                p.getHoraFim(),
                p.getVagas(),
                p.getLocalEspecialidade().getId(),
                p.getPreceptor() != null ? p.getPreceptor().getId() : null
        );
    }
}


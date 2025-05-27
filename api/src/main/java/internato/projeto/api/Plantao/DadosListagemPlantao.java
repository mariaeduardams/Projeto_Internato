package internato.projeto.api.Plantao;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosListagemPlantao(
        Long id,
        LocalDate data,
        LocalTime horaInicio,
        LocalTime horaFim,
        String local,
        String especialidade,
        String preceptor
) {
    public DadosListagemPlantao(Plantao p) {
        this(
                p.getId(),
                p.getData(),
                p.getHoraInicio(),
                p.getHoraFim(),
                p.getLocalEspecialidade().getLocal().getNome(),
                p.getLocalEspecialidade().getEspecialidade().getNome(),
                p.getPreceptor() != null ? p.getPreceptor().getNome() : null
        );
    }
}

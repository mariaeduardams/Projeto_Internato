package internato.projeto.api.Semestre;

import java.time.LocalDate;

public record DadosListagemSemestre(Long id, String descricao, LocalDate dataInicio, LocalDate dataFim) {
    public DadosListagemSemestre(Semestre semestre) {
        this(semestre.getId(), semestre.getDescricao(), semestre.getDataInicio(), semestre.getDataFim());
    }
}

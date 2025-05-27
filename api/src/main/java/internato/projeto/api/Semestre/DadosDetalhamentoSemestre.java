package internato.projeto.api.Semestre;


import java.time.LocalDate;

public record DadosDetalhamentoSemestre(Long id, String descricao, LocalDate dataInicio, LocalDate dataFim) {
    public DadosDetalhamentoSemestre(Semestre semestre) {
        this(semestre.getId(), semestre.getDescricao(), semestre.getDataInicio(), semestre.getDataFim());
    }
}


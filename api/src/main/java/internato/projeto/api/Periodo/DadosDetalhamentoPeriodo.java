package internato.projeto.api.Periodo;


public record DadosDetalhamentoPeriodo(Long id, String nome) {
    public DadosDetalhamentoPeriodo(Periodo periodo) {
        this(periodo.getId(), periodo.getNome());
    }
}


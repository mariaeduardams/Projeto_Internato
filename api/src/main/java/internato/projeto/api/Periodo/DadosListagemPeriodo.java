package internato.projeto.api.Periodo;


public record DadosListagemPeriodo(Long id, String nome) {
    public DadosListagemPeriodo(Periodo periodo) {
        this(periodo.getId(), periodo.getNome());
    }
}

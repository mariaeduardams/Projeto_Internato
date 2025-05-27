package internato.projeto.api.Especialidade;


public record DadosDetalhamentoEspecialidade(Long id, String nome) {
    public DadosDetalhamentoEspecialidade(Especialidade especialidade) {
        this(especialidade.getId(), especialidade.getNome());
    }
}

package internato.projeto.api.Especialidade;


public record DadosListagemEspecialidade(Long id, String nome) {
    public DadosListagemEspecialidade(Especialidade especialidade) {
        this(especialidade.getId(), especialidade.getNome());
    }
}

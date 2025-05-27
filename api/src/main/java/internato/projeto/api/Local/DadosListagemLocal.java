package internato.projeto.api.Local;


public record DadosListagemLocal(
        Long id,
        String nome,
        String sigla,
        String cidade
) {
    public DadosListagemLocal(Local local) {
        this(local.getId(), local.getNome(), local.getSigla(), local.getCidade());
    }
}

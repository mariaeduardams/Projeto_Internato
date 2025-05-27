package internato.projeto.api.LocalEspecialidade;

public record DadosListagemLocalEspecialidade(
        Long id,
        String local,
        String especialidade,
        String semestre,
        int vagasManha,
        int vagasTarde,
        int vagasNoite
) {
    public DadosListagemLocalEspecialidade(LocalEspecialidade le) {
        this(
                le.getId(),
                le.getLocal().getNome(),
                le.getEspecialidade().getNome(),
                le.getSemestre().getDescricao(),
                le.getVagasManha(),
                le.getVagasTarde(),
                le.getVagasNoite()
        );
    }
}


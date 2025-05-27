package internato.projeto.api.LocalEspecialidade;


public record DadosDetalhamentoLocalEspecialidade(
        Long id,
        Long idLocal,
        Long idEspecialidade,
        Long idSemestre,
        int vagasManha,
        int vagasTarde,
        int vagasNoite
) {
    public DadosDetalhamentoLocalEspecialidade(LocalEspecialidade le) {
        this(
                le.getId(),
                le.getLocal().getId(),
                le.getEspecialidade().getId(),
                le.getSemestre().getId(),
                le.getVagasManha(),
                le.getVagasTarde(),
                le.getVagasNoite()
        );
    }
}

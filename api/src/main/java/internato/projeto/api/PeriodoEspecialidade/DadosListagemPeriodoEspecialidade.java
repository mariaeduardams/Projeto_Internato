package internato.projeto.api.PeriodoEspecialidade;


public record DadosListagemPeriodoEspecialidade(
        Long id,
        String periodo,
        String especialidade,
        int cargaHorariaMinima
) {
    public DadosListagemPeriodoEspecialidade(PeriodoEspecialidade pe) {
        this(pe.getId(), pe.getPeriodo().getNome(), pe.getEspecialidade().getNome(), pe.getCargaHorariaMinima());
    }
}

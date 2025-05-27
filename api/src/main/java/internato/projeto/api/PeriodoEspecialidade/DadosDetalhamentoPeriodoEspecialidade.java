package internato.projeto.api.PeriodoEspecialidade;


public record DadosDetalhamentoPeriodoEspecialidade(
        Long id,
        Long idPeriodo,
        Long idEspecialidade,
        int cargaHorariaMinima
) {
    public DadosDetalhamentoPeriodoEspecialidade(PeriodoEspecialidade pe) {
        this(pe.getId(), pe.getPeriodo().getId(), pe.getEspecialidade().getId(), pe.getCargaHorariaMinima());
    }
}


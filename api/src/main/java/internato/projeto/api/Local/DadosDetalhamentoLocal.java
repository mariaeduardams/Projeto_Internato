package internato.projeto.api.Local;


public record DadosDetalhamentoLocal(
        Long id,
        String nome,
        String sigla,
        String endereco,
        String cep,
        String cidade,
        Double latitude,
        Double longitude
) {
    public DadosDetalhamentoLocal(Local local) {
        this(
                local.getId(),
                local.getNome(),
                local.getSigla(),
                local.getEndereco(),
                local.getCep(),
                local.getCidade(),
                local.getLatitude(),
                local.getLongitude()
        );
    }
}


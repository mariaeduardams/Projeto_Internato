package internato.projeto.api.Local;


import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoLocal(
        @NotNull Long id,
        String nome,
        String sigla,
        String endereco,
        String cep,
        String cidade,
        Double latitude,
        Double longitude
) {}

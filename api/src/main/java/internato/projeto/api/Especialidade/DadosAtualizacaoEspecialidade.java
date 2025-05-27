package internato.projeto.api.Especialidade;


import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEspecialidade(
        @NotNull Long id,
        String nome
) {}

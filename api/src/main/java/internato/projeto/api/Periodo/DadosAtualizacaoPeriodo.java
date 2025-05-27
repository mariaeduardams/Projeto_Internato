package internato.projeto.api.Periodo;


import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPeriodo(
        @NotNull Long id,
        String nome
) {}

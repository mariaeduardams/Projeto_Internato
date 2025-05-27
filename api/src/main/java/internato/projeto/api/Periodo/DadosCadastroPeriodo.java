package internato.projeto.api.Periodo;


import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPeriodo(
        @NotBlank String nome
) {}

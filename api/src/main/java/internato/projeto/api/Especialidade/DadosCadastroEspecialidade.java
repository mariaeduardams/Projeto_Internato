package internato.projeto.api.Especialidade;


import jakarta.validation.constraints.NotBlank;

public record DadosCadastroEspecialidade(
        @NotBlank String nome
) {}


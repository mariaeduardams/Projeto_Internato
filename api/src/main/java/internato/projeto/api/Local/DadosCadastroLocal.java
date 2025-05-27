package internato.projeto.api.Local;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroLocal(
        @NotBlank String nome,
        @NotBlank String sigla,
        @NotBlank String endereco,
        @NotBlank String cep,
        @NotBlank String cidade,
        @NotNull Double latitude,
        @NotNull Double longitude
) {}


package internato.projeto.api.LocalEspecialidade;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoLocalEspecialidade(
        @NotNull Long id,
        Integer vagasManha,
        Integer vagasTarde,
        Integer vagasNoite
) {}


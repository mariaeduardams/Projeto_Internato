package internato.projeto.api.LocalEspecialidade;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroLocalEspecialidade(
        @NotNull Long idLocal,
        @NotNull Long idEspecialidade,
        @NotNull Long idSemestre,
        @Min(0) int vagasManha,
        @Min(0) int vagasTarde,
        @Min(0) int vagasNoite
) {}


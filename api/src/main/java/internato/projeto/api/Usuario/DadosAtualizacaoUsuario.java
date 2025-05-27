package internato.projeto.api.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
        @NotNull Long id,
        String nome,
        @Email String email,
        String matricula,
        Perfil perfil
) {}

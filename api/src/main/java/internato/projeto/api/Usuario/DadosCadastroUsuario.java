package internato.projeto.api.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(
        @NotBlank String nome,
        @NotBlank @Email String email,
        String matricula,
        @NotNull Perfil perfil
) {}


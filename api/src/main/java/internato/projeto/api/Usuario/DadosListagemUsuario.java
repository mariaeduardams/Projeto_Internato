package internato.projeto.api.Usuario;

public record DadosListagemUsuario(
        Long id,
        String nome,
        String email,
        Perfil perfil
) {
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getPerfil());
    }
}


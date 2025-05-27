package internato.projeto.api.Usuario;


public record DadosDetalhamentoUsuario(
        Long id,
        String nome,
        String email,
        String matricula,
        Perfil perfil
) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getMatricula(),
                usuario.getPerfil()
        );
    }
}


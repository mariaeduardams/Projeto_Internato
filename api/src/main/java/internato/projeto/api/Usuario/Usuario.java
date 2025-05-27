package internato.projeto.api.Usuario;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuario")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String matricula;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    private Boolean ativo;


    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(DadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.matricula = dados.matricula();
        this.perfil = dados.perfil();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoUsuario dados) {
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.email() != null) this.email = dados.email();
        if (dados.matricula() != null) this.matricula = dados.matricula();
        if (dados.perfil() != null) this.perfil = dados.perfil();
    }

    public void excluir() {
        this.ativo = false;
    }
}



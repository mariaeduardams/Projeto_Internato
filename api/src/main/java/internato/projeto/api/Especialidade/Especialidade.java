package internato.projeto.api.Especialidade;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "especialidade")
@Entity(name = "Especialidade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Especialidade(Long id) {
        this.id = id;
    }

    public Especialidade(DadosCadastroEspecialidade dados) {
        this.nome = dados.nome();
    }

    public void atualizarInformacoes(DadosAtualizacaoEspecialidade dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
    }
}



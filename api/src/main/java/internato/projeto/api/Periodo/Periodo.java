package internato.projeto.api.Periodo;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "periodo")
@Entity(name = "Periodo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Periodo(Long id) {
        this.id = id;
    }

    public Periodo(DadosCadastroPeriodo dados) {
        this.nome = dados.nome();
    }

    public void atualizarInformacoes(DadosAtualizacaoPeriodo dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
    }
}




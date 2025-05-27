package internato.projeto.api.LocalEspecialidade;

import jakarta.persistence.*;
import internato.projeto.api.Local.Local;
import internato.projeto.api.Semestre.Semestre;
import internato.projeto.api.Especialidade.Especialidade;
import lombok.*;

@Table(name = "local_especialidade")
@Entity(name = "LocalEspecialidade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class LocalEspecialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Local local;

    @ManyToOne(optional = false)
    private Especialidade especialidade;

    @ManyToOne(optional = false)
    private Semestre semestre;

    private int vagasManha;
    private int vagasTarde;
    private int vagasNoite;

    public LocalEspecialidade(Long id) {
        this.id = id;
    }

    public LocalEspecialidade(DadosCadastroLocalEspecialidade dados) {
        this.local = new Local(dados.idLocal());
        this.especialidade = new Especialidade(dados.idEspecialidade());
        this.semestre = new Semestre(dados.idSemestre());
        this.vagasManha = dados.vagasManha();
        this.vagasTarde = dados.vagasTarde();
        this.vagasNoite = dados.vagasNoite();
    }

    public void atualizarInformacoes(DadosAtualizacaoLocalEspecialidade dados) {
        if (dados.vagasManha() != null) this.vagasManha = dados.vagasManha();
        if (dados.vagasTarde() != null) this.vagasTarde = dados.vagasTarde();
        if (dados.vagasNoite() != null) this.vagasNoite = dados.vagasNoite();
    }
}


package internato.projeto.api.PlantaoAluno;

import internato.projeto.api.Plantao.Plantao;
import internato.projeto.api.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "plantao_aluno",
        uniqueConstraints = @UniqueConstraint(columnNames = {"plantao_id", "aluno_id"}))
@Entity(name = "PlantaoAluno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PlantaoAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Plantao plantao;

    @ManyToOne(optional = false)
    private Usuario aluno;

    @Enumerated(EnumType.STRING)
    private StatusPlantaoAluno status = StatusPlantaoAluno.ESCALADO;

    public PlantaoAluno(Long id) {
        this.id = id;
    }

    public PlantaoAluno(DadosCadastroPlantaoAluno dados) {
        this.plantao = new Plantao(dados.idPlantao());
        this.aluno   = new Usuario(dados.idAluno());
    }

    public void atualizarStatus(StatusPlantaoAluno novoStatus) {
        if (novoStatus != null) this.status = novoStatus;
    }
}


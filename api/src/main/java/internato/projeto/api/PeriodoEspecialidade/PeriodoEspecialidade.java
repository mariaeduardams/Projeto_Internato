package internato.projeto.api.PeriodoEspecialidade;


import internato.projeto.api.Especialidade.Especialidade;
import internato.projeto.api.Periodo.Periodo;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "periodo_especialidade")
@Entity(name = "PeriodoEspecialidade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PeriodoEspecialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Periodo periodo;

    @ManyToOne(optional = false)
    private Especialidade especialidade;

    private int cargaHorariaMinima; // em horas

    public PeriodoEspecialidade(DadosCadastroPeriodoEspecialidade dados) {
        this.periodo = new Periodo(dados.idPeriodo());
        this.especialidade = new Especialidade(dados.idEspecialidade());
        this.cargaHorariaMinima = dados.cargaHorariaMinima();
    }

    public void atualizarInformacoes(DadosAtualizacaoPeriodoEspecialidade dados) {
        if (dados.cargaHorariaMinima() != null) {
            this.cargaHorariaMinima = dados.cargaHorariaMinima();
        }
    }
}

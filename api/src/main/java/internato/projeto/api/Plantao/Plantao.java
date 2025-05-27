package internato.projeto.api.Plantao;

import internato.projeto.api.LocalEspecialidade.LocalEspecialidade;
import internato.projeto.api.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "plantao")
@Entity(name = "Plantao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Plantao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private int vagas;

    @ManyToOne(optional = false)
    private LocalEspecialidade localEspecialidade;

    @ManyToOne
    private Usuario preceptor;

    public Plantao(Long id) {
        this.id = id;
    }

    public Plantao(DadosCadastroPlantao dados) {
        this.data = dados.data();
        this.horaInicio = dados.horaInicio();
        this.horaFim = dados.horaFim();
        this.vagas = dados.vagas();
        this.localEspecialidade = new LocalEspecialidade(dados.idLocalEspecialidade());
        if (dados.idPreceptor() != null)
            this.preceptor = new Usuario(dados.idPreceptor());
    }

    public void atualizarInformacoes(DadosAtualizacaoPlantao dados) {
        if (dados.data() != null) this.data = dados.data();
        if (dados.horaInicio() != null) this.horaInicio = dados.horaInicio();
        if (dados.horaFim() != null) this.horaFim = dados.horaFim();
        if (dados.vagas() != null) this.vagas = dados.vagas();
    }
}



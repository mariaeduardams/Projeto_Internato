package internato.projeto.api.Semestre;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "semestre")
@Entity(name = "Semestre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Semestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private boolean ativo;


    public Semestre(Long id) {
        this.id = id;
    }

    public Semestre(DadosCadastroSemestre dados) {
        this.descricao = dados.descricao();
        this.dataInicio = dados.dataInicio();
        this.dataFim = dados.dataFim();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoSemestre dados) {
        if (dados.descricao() != null) this.descricao = dados.descricao();
        if (dados.dataInicio() != null) this.dataInicio = dados.dataInicio();
        if (dados.dataFim() != null) this.dataFim = dados.dataFim();
    }

    public void excluir() {
        this.ativo = false;
    }
}



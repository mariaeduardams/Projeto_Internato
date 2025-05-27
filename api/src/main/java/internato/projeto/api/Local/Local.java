package internato.projeto.api.Local;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "local")
@Entity(name = "Local")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sigla;

    private String endereco;
    private String cep;
    private String cidade;

    private Double latitude;
    private Double longitude;


    public Local(Long id) {
        this.id = id;
    }


    public Local(DadosCadastroLocal dados) {
        this.nome = dados.nome();
        this.sigla = dados.sigla();
        this.endereco = dados.endereco();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.latitude = dados.latitude();
        this.longitude = dados.longitude();
    }

    public void atualizarInformacoes(DadosAtualizacaoLocal dados) {
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.sigla() != null) this.sigla = dados.sigla();
        if (dados.endereco() != null) this.endereco = dados.endereco();
        if (dados.cep() != null) this.cep = dados.cep();
        if (dados.cidade() != null) this.cidade = dados.cidade();
        if (dados.latitude() != null) this.latitude = dados.latitude();
        if (dados.longitude() != null) this.longitude = dados.longitude();
    }
}




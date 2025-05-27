package internato.projeto.api.CheckIn;


import internato.projeto.api.PlantaoAluno.PlantaoAluno;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "checkin")
@Entity(name = "CheckIn")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHoraCheckIn;

    private LocalDateTime dataHoraCheckOut;

    private Double latitude;
    private Double longitude;

    private Boolean advertencia = false;

    @ManyToOne(optional = false)
    private PlantaoAluno plantaoAluno;

    public CheckIn(DadosCadastroCheckIn dados) {
        this.plantaoAluno = new PlantaoAluno(dados.idPlantaoAluno());
        this.dataHoraCheckIn = dados.dataHoraCheckIn();
        this.latitude = dados.latitude();
        this.longitude = dados.longitude();
    }

    public void registrarCheckOut(LocalDateTime horaSaida, boolean advertencia) {
        this.dataHoraCheckOut = horaSaida;
        this.advertencia = advertencia;
    }
}

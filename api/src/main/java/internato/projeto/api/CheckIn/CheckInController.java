package internato.projeto.api.CheckIn;


import internato.projeto.api.Plantao.Plantao;
import internato.projeto.api.Plantao.PlantaoRepository;
import internato.projeto.api.PlantaoAluno.PlantaoAluno;
import internato.projeto.api.PlantaoAluno.PlantaoAlunoRepository;
import internato.projeto.api.PlantaoAluno.StatusPlantaoAluno;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;

@RestController
@RequestMapping("checkin")
public class CheckInController {

    @Autowired
    private CheckInRepository repository;

    @Autowired
    private PlantaoAlunoRepository plantaoAlunoRepository;

    @Autowired
    private PlantaoRepository plantaoRepository;


    private static final double LIMITE_METROS = 100.0;

    @PostMapping
    @Transactional
    public ResponseEntity realizarCheckIn(@RequestBody @Valid DadosCadastroCheckIn dados) {
        if (repository.existsByPlantaoAlunoId(dados.idPlantaoAluno())) {
            return ResponseEntity.badRequest().body("Check-in já registrado.");
        }

        PlantaoAluno pa = plantaoAlunoRepository.getReferenceById(dados.idPlantaoAluno());
        Plantao plantao = pa.getPlantao();

        // verificação de horário:
        LocalDateTime inicio = plantao.getData().atTime(plantao.getHoraInicio());
        Duration diferenca = Duration.between(inicio, dados.dataHoraCheckIn());
        long minutos = Math.abs(diferenca.toMinutes());

        if (minutos > 15) {
            return ResponseEntity.badRequest().body("Check-in fora do horário permitido.");
        }

        // verificação de distância:
        double distancia = calcularDistancia(
                dados.latitude(), dados.longitude(),
                plantao.getLocalEspecialidade().getLocal().getLatitude(),
                plantao.getLocalEspecialidade().getLocal().getLongitude()
        );

        if (distancia > LIMITE_METROS) {
            return ResponseEntity.badRequest().body("Você está fora do local autorizado.");
        }

        // salvar check-in:
        CheckIn check = new CheckIn(dados);
        repository.save(check);

        // atualizar status:
        pa.atualizarStatus(StatusPlantaoAluno.PRESENTE);

        return ResponseEntity.ok(new DadosDetalhamentoCheckIn(check));
    }

    @PostMapping("/checkout")
    @Transactional
    public ResponseEntity realizarCheckOut(@RequestBody @Valid DadosCheckOut dados) {
        CheckIn check = repository.getReferenceById(dados.idCheckIn());
        boolean advertencia = false;

        if (check.getDataHoraCheckOut() != null) {
            return ResponseEntity.badRequest().body("Check-out já realizado.");
        }

        if (dados.dataHoraCheckOut().isBefore(check.getDataHoraCheckIn())) {
            return ResponseEntity.badRequest().body("Check-out não pode ser antes do check-in.");
        }

        // se o aluno esqueceu o check-out vai marcar advertência:
        if (Duration.between(check.getDataHoraCheckIn(), dados.dataHoraCheckOut()).toHours() > 12) {
            advertencia = true;
        }

        check.registrarCheckOut(dados.dataHoraCheckOut(), advertencia);
        return ResponseEntity.ok(new DadosDetalhamentoCheckIn(check));
    }

    // distância entre dois pontos GPS:
    private double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371000; // raio da Terra em metros
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}

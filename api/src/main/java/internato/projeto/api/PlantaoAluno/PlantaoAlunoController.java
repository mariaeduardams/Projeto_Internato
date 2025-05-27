package internato.projeto.api.PlantaoAluno;


import internato.projeto.api.Plantao.PlantaoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("plantao-aluno")
public class PlantaoAlunoController {

    @Autowired
    private PlantaoAlunoRepository repository;
    @Autowired
    private PlantaoRepository plantaoRepository;

  // vagas:
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPlantaoAluno dados,
                                    UriComponentsBuilder uriBuilder) {

        var plantao = plantaoRepository.getReferenceById(dados.idPlantao());
        long ocupadas = repository.countByPlantaoId(plantao.getId());

        if (ocupadas >= plantao.getVagas()) {
            return ResponseEntity.badRequest().body("Não há vagas disponíveis neste plantão.");
        }

        var alocacao = new PlantaoAluno(dados);
        repository.save(alocacao);

        var uri = uriBuilder.path("plantao-aluno/{id}").buildAndExpand(alocacao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPlantaoAluno(alocacao));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPlantaoAluno>> listar(@PageableDefault(size = 10) Pageable pageable) {
        var page = repository.findAll(pageable).map(DadosListagemPlantaoAluno::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPlantaoAluno dados) {
        var alocacao = repository.getReferenceById(dados.id());
        alocacao.atualizarStatus(dados.status());
        return ResponseEntity.ok(new DadosDetalhamentoPlantaoAluno(alocacao));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        var alocacao = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPlantaoAluno(alocacao));
    }
}

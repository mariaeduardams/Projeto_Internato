package internato.projeto.api.Plantao;


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
@RequestMapping("plantao")
public class PlantaoController {

    @Autowired
    private PlantaoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPlantao dados, UriComponentsBuilder uriBuilder) {
        var plantao = new Plantao(dados);
        repository.save(plantao);
        var uri = uriBuilder.path("plantao/{id}").buildAndExpand(plantao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPlantao(plantao));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPlantao>> listar(@PageableDefault(size = 10, sort = {"data"}) Pageable pageable) {
        var page = repository.findAll(pageable).map(DadosListagemPlantao::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPlantao dados) {
        var plantao = repository.getReferenceById(dados.id());
        plantao.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPlantao(plantao));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        var plantao = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPlantao(plantao));
    }
}

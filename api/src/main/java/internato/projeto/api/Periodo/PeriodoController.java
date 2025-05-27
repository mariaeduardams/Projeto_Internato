package internato.projeto.api.Periodo;


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
@RequestMapping("periodo")
public class PeriodoController {

    @Autowired
    private PeriodoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPeriodo dados, UriComponentsBuilder uriBuilder) {
        var periodo = new Periodo(dados);
        repository.save(periodo);
        var uri = uriBuilder.path("periodo/{id}").buildAndExpand(periodo.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPeriodo(periodo));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPeriodo>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        var page = repository.findAll(pageable).map(DadosListagemPeriodo::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPeriodo dados) {
        var periodo = repository.getReferenceById(dados.id());
        periodo.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPeriodo(periodo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        var periodo = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPeriodo(periodo));
    }
}


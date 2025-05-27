package internato.projeto.api.PeriodoEspecialidade;


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
@RequestMapping("periodo-especialidade")
public class PeriodoEspecialidadeController {

    @Autowired
    private PeriodoEspecialidadeRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPeriodoEspecialidade dados, UriComponentsBuilder uriBuilder) {
        var pe = new PeriodoEspecialidade(dados);
        repository.save(pe);
        var uri = uriBuilder.path("periodo-especialidade/{id}").buildAndExpand(pe.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPeriodoEspecialidade(pe));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPeriodoEspecialidade>> listar(@PageableDefault(size = 10) Pageable pageable) {
        var page = repository.findAll(pageable).map(DadosListagemPeriodoEspecialidade::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPeriodoEspecialidade dados) {
        var pe = repository.getReferenceById(dados.id());
        pe.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPeriodoEspecialidade(pe));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        var pe = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPeriodoEspecialidade(pe));
    }
}

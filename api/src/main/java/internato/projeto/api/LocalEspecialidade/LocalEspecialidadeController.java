package internato.projeto.api.LocalEspecialidade;

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
@RequestMapping("local-especialidade")
public class LocalEspecialidadeController {

    @Autowired
    private LocalEspecialidadeRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroLocalEspecialidade dados, UriComponentsBuilder uriBuilder) {
        var le = new LocalEspecialidade(dados);
        repository.save(le);
        var uri = uriBuilder.path("local-especialidade/{id}").buildAndExpand(le.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoLocalEspecialidade(le));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLocalEspecialidade>> listar(@PageableDefault(size = 10) Pageable pageable) {
        var page = repository.findAll(pageable).map(DadosListagemLocalEspecialidade::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoLocalEspecialidade dados) {
        var le = repository.getReferenceById(dados.id());
        le.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoLocalEspecialidade(le));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        var le = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoLocalEspecialidade(le));
    }
}


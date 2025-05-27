package internato.projeto.api.Local;

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
@RequestMapping("local")
public class LocalController {

    @Autowired
    private LocalRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroLocal dados, UriComponentsBuilder uriBuilder) {
        var local = new Local(dados);
        repository.save(local);
        var uri = uriBuilder.path("local/{id}").buildAndExpand(local.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoLocal(local));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLocal>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        var page = repository.findAll(pageable).map(DadosListagemLocal::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoLocal dados) {
        var local = repository.getReferenceById(dados.id());
        local.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoLocal(local));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        var local = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoLocal(local));
    }
}


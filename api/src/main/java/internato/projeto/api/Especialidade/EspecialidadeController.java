package internato.projeto.api.Especialidade;


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
@RequestMapping("especialidade")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEspecialidade dados, UriComponentsBuilder uriBuilder) {
        var especialidade = new Especialidade(dados);
        repository.save(especialidade);
        var uri = uriBuilder.path("especialidade/{id}").buildAndExpand(especialidade.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEspecialidade(especialidade));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemEspecialidade>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        var page = repository.findAll(pageable).map(DadosListagemEspecialidade::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoEspecialidade dados) {
        var especialidade = repository.getReferenceById(dados.id());
        especialidade.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoEspecialidade(especialidade));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        var especialidade = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoEspecialidade(especialidade));
    }
}


package internato.projeto.api.Semestre;

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
@RequestMapping("semestre")
public class SemestreController {

    @Autowired
    private SemestreRepository semestreRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroSemestre dados, UriComponentsBuilder uriBuilder) {
        var semestre = new Semestre(dados);
        semestreRepository.save(semestre);
        var uri = uriBuilder.path("semestre/{id}").buildAndExpand(semestre.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoSemestre(semestre));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemSemestre>> listar(@PageableDefault(size = 10, sort = {"dataInicio"}) Pageable pageable) {
        var page = semestreRepository.findByAtivoTrue(pageable).map(DadosListagemSemestre::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoSemestre dados) {
        var semestre = semestreRepository.getReferenceById(dados.id());
        semestre.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoSemestre(semestre));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var semestre = semestreRepository.getReferenceById(id);
        semestre.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        var semestre = semestreRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoSemestre(semestre));
    }
}

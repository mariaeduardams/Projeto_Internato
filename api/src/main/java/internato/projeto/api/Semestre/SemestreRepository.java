package internato.projeto.api.Semestre;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {
    Page<Semestre> findByAtivoTrue(Pageable pageable);
    Semestre findByIdAndAtivoTrue(Long id);
}


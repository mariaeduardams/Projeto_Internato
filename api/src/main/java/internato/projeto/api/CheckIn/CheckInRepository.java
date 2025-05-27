package internato.projeto.api.CheckIn;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    boolean existsByPlantaoAlunoId(Long plantaoAlunoId);
}


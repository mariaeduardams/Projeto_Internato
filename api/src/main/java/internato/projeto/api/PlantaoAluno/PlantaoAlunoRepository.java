package internato.projeto.api.PlantaoAluno;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantaoAlunoRepository extends JpaRepository<PlantaoAluno, Long> {
    long countByPlantaoId(Long plantaoId);
}


package esprit.tn.projetsi.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import esprit.tn.projetsi.domain.Agence;

public interface AgenceRepository extends JpaRepository<Agence, Long> {
}

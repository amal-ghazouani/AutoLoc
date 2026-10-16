package esprit.tn.projetsi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import esprit.tn.projetsi.domain.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
}
package esprit.tn.projetsi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import esprit.tn.projetsi.domain.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
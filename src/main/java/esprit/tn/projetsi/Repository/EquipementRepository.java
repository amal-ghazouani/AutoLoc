package esprit.tn.projetsi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import esprit.tn.projetsi.domain.Equipement;

public interface EquipementRepository extends JpaRepository<Equipement, Long> {
}
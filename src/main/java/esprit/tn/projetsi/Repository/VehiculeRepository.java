package esprit.tn.projetsi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import esprit.tn.projetsi.domain.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}
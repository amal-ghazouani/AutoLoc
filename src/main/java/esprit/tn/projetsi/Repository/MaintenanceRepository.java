package esprit.tn.projetsi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import esprit.tn.projetsi.domain.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
}
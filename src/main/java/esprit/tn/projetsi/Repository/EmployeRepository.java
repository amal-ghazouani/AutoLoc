package esprit.tn.projetsi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import esprit.tn.projetsi.domain.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}

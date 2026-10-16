package esprit.tn.projetsi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import esprit.tn.projetsi.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

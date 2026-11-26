
package esprit.tn.projetsi.Repository;

import esprit.tn.projetsi.domain.Reservation;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Override
    @EntityGraph(attributePaths = {"client", "vehicule"})
    List<Reservation> findAll();

    @EntityGraph(attributePaths = {"client", "vehicule"})
    List<Reservation> findByClient_IdClient(Long idClient);
}

package esprit.tn.projetsi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import esprit.tn.projetsi.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
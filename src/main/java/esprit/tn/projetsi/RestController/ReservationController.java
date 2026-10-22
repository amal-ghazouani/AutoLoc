package esprit.tn.projetsi.RestController;

import esprit.tn.projetsi.domain.Reservation;
import esprit.tn.projetsi.services.IReservation;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationController {

    IReservation iReservation;

    @PostMapping("/AddReservation")
    public Reservation addReservation(@Valid @RequestBody Reservation reservation) {
        return iReservation.addReservation(reservation);
    }

    @GetMapping("/GetAll")
    public List<Reservation> getAll() {
        return iReservation.retrieveAllReservations();
    }

    @GetMapping("/GetReservation/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        return iReservation.retrieveReservation(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return iReservation.updateReservation(reservation);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public void deleteReservation(@PathVariable Long id) {
        iReservation.removeReservation(id);
    }
}
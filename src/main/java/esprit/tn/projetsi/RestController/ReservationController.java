
package esprit.tn.projetsi.RestController;

import esprit.tn.projetsi.domain.Reservation;
import esprit.tn.projetsi.dto.ReservationResponseDto;
import esprit.tn.projetsi.services.IReservation;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/Reservation", "/api/reservations"})
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReservationController {

    IReservation iReservation;

    // CREATE
    @PostMapping("/AddReservation")
    public Reservation addReservation(@Valid @RequestBody Reservation reservation) {
        return iReservation.addReservation(reservation);
    }

    // READ : Consulter toutes les réservations avec DTO
    @GetMapping
    public List<ReservationResponseDto> getAllReservations() {
        return iReservation.retrieveAllReservationsDto();
    }

    // READ : Consulter les réservations d'un client avec DTO
    @GetMapping("/client/{idClient}")
    public List<ReservationResponseDto> getReservationsByClient(
            @PathVariable Long idClient) {

        return iReservation.retrieveReservationsByClient(idClient);
    }

    // Ancien READ : conserver la récupération des entités
    @GetMapping("/GetAll")
    public List<Reservation> getAll() {
        return iReservation.retrieveAllReservations();
    }

    // Consulter une réservation par son identifiant
    @GetMapping("/GetReservation/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        return iReservation.retrieveReservation(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return iReservation.updateReservation(reservation);
    }

    // DELETE
    @DeleteMapping("/deleteReservation/{id}")
    public void deleteReservation(@PathVariable Long id) {
        iReservation.removeReservation(id);
    }
}

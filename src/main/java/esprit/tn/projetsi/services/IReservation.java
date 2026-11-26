
package esprit.tn.projetsi.services;

import esprit.tn.projetsi.domain.Reservation;
import esprit.tn.projetsi.dto.ReservationResponseDto;

import java.util.List;
import java.util.Optional;

public interface IReservation {

    // CREATE
    Reservation addReservation(Reservation reservation);

    // READ
    List<Reservation> retrieveAllReservations();

    Optional<Reservation> retrieveReservation(Long idReservation);

    // READ avec DTO
    List<ReservationResponseDto> retrieveAllReservationsDto();

    List<ReservationResponseDto> retrieveReservationsByClient(Long idClient);

    // UPDATE
    Reservation updateReservation(Reservation reservation);

    // DELETE
    void removeReservation(Long idReservation);
}

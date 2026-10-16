package esprit.tn.projetsi.services;

import esprit.tn.projetsi.domain.Reservation;

import java.util.List;
import java.util.Optional;

public interface IReservation {

    // CREATE
    Reservation addReservation(Reservation reservation);

    // READ
    List<Reservation> retrieveAllReservations();

    Optional<Reservation> retrieveReservation(Long idReservation);

    // UPDATE
    Reservation updateReservation(Reservation reservation);

    // DELETE
    void removeReservation(Long idReservation);
}

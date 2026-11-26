
package esprit.tn.projetsi.services;

import esprit.tn.projetsi.Repository.ReservationRepository;
import esprit.tn.projetsi.domain.Reservation;
import esprit.tn.projetsi.dto.ReservationResponseDto;
import esprit.tn.projetsi.mapper.ReservationMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservation {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> retrieveReservation(Long idReservation) {
        return reservationRepository.findById(idReservation);
    }

    // Consulter toutes les réservations avec DTO
    @Override
    @Transactional(readOnly = true)
    public List<ReservationResponseDto> retrieveAllReservationsDto() {

        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    // Consulter les réservations d'un client avec DTO
    @Override
    @Transactional(readOnly = true)
    public List<ReservationResponseDto> retrieveReservationsByClient(Long idClient) {

        return reservationRepository.findByClient_IdClient(idClient)
                .stream()
                .map(reservationMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void removeReservation(Long idReservation) {
        reservationRepository.deleteById(idReservation);
    }
}

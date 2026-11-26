
package esprit.tn.projetsi.dto;

import esprit.tn.projetsi.domain.StatutReservation;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationResponseDto {

    private Long idReservation;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private StatutReservation statut;

    private String nomClient;

    private String prenomClient;

    private String marqueVehicule;

    private String modeleVehicule;

    private String immatriculation;
}



package esprit.tn.projetsi.mapper;

import esprit.tn.projetsi.domain.Reservation;
import esprit.tn.projetsi.dto.ReservationResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(source = "client.nom", target = "nomClient")
    @Mapping(source = "client.prenom", target = "prenomClient")
    @Mapping(source = "vehicule.marque", target = "marqueVehicule")
    @Mapping(source = "vehicule.modele", target = "modeleVehicule")
    @Mapping(source = "vehicule.immatriculation", target = "immatriculation")
    ReservationResponseDto toResponseDto(Reservation reservation);
}


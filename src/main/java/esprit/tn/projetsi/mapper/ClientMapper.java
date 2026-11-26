
package esprit.tn.projetsi.mapper;

import esprit.tn.projetsi.domain.Client;
import esprit.tn.projetsi.dto.ClientRequestDto;
import esprit.tn.projetsi.dto.ClientResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    // DTO vers entité
    Client toEntity(ClientRequestDto dto);

    // Entité vers DTO
    @Mapping(source = "idClient", target = "id")
    ClientResponseDto toResponseDto(Client client);
}

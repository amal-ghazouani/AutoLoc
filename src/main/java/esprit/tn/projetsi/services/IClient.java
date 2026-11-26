package esprit.tn.projetsi.services;

import esprit.tn.projetsi.domain.Client;
import esprit.tn.projetsi.dto.ClientRequestDto;
import esprit.tn.projetsi.dto.ClientResponseDto;

import java.util.List;
import java.util.Optional;

public interface IClient {

    // CREATE
    Client addClient(Client client);

    // READ
    List<Client> retrieveAllClients();

    Optional<Client> retrieveClient(Long idClient);

    // UPDATE
    Client updateClient(Client client);

    // DELETE
    void removeClient(Long idClient);


    ClientResponseDto addClientDto(ClientRequestDto dto);


    Optional<ClientResponseDto> retrieveClientDto(Long idClient);
}
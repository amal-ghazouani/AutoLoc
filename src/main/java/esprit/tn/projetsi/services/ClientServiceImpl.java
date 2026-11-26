
package esprit.tn.projetsi.services;

import esprit.tn.projetsi.Repository.ClientRepository;
import esprit.tn.projetsi.domain.Client;
import esprit.tn.projetsi.dto.ClientRequestDto;
import esprit.tn.projetsi.dto.ClientResponseDto;
import esprit.tn.projetsi.mapper.ClientMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClient {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    // Ancienne fonctionnalité : ajouter un client
    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    // Nouvelle fonctionnalité : ajouter un client avec DTO
    @Override
    public ClientResponseDto addClientDto(ClientRequestDto dto) {
        Client client = clientMapper.toEntity(dto);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toResponseDto(savedClient);
    }

    // Consulter tous les clients
    @Override
    public List<Client> retrieveAllClients() {
        return clientRepository.findAll();
    }

    // Nouvelle consultation avec DTO
    public Optional<ClientResponseDto> retrieveClientDto(Long idClient) {
        return clientRepository.findById(idClient)
                .map(clientMapper::toResponseDto);
    }

    // Ancienne consultation
    @Override
    public Optional<Client> retrieveClient(Long idClient) {
        return clientRepository.findById(idClient);
    }

    // Modifier un client
    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    // Supprimer un client
    @Override
    public void removeClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }
}

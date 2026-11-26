
package esprit.tn.projetsi.RestController;

import esprit.tn.projetsi.domain.Client;
import esprit.tn.projetsi.dto.ClientRequestDto;
import esprit.tn.projetsi.dto.ClientResponseDto;
import esprit.tn.projetsi.services.IClient;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClientControlller {

    IClient iClient;

    // Ajouter un client avec DTO
    @PostMapping("/AddClient")
    public ResponseEntity<ClientResponseDto> addClient(
            @Valid @RequestBody ClientRequestDto dto) {

        return ResponseEntity.ok(iClient.addClientDto(dto));
    }

    // Ancienne fonctionnalité : consulter tous les clients
    @GetMapping("/GetAll")
    public List<Client> getAll() {
        return iClient.retrieveAllClients();
    }

    // Consulter un client par ID avec DTO
    @GetMapping("/GetClient/{id}")
    public ResponseEntity<ClientResponseDto> getClient(
            @PathVariable Long id) {

        return iClient.retrieveClientDto(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Ancienne fonctionnalité : modifier un client
    @PutMapping("/updateClient")
    public Client updateClient(@RequestBody Client client) {
        return iClient.updateClient(client);
    }

    // Ancienne fonctionnalité : supprimer un client
    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable Long id) {
        iClient.removeClient(id);
    }
}

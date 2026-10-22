package esprit.tn.projetsi.RestController;

import esprit.tn.projetsi.domain.Client;
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

    @PostMapping("/AddClient")
    public Client addClient( @Valid @RequestBody Client client) {
        return iClient.addClient(client);
    }

    @GetMapping("/GetAll")
    public List<Client> getAll() {
        return iClient.retrieveAllClients();
    }

    @GetMapping("/GetClient/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        return iClient.retrieveClient(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updateClient")
    public Client updateClient(@RequestBody Client client) {
        return iClient.updateClient(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable Long id) {
        iClient.removeClient(id);
    }
}
package esprit.tn.projetsi.RestController;

import esprit.tn.projetsi.domain.Contrat;
import esprit.tn.projetsi.services.IContrat;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Contrat")
@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratController {

    IContrat contratService;

    // http://localhost:8089/contrat/retrieve-all-contrats
    @Operation(description = "Récupérer tous les contrats de la base de données")
    @GetMapping("/retrieve-all-contrats")
    public List<Contrat> getContrats() {
        return contratService.retrieveAllContrats();
    }

    // http://localhost:8089/contrat/retrieve-contrat/1
    @Operation(description = "Récupérer un contrat par son identifiant")
    @GetMapping("/retrieve-contrat/{contrat-id}")
    public ResponseEntity<Contrat> retrieveContrat(@PathVariable("contrat-id") Long contratId) {
        return contratService.retrieveContrat(contratId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // http://localhost:8089/contrat/add-contrat
    @Operation(description = "Ajouter un contrat")
    @PostMapping("/add-contrat")
    public Contrat addContrat(@Valid @RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    // http://localhost:8089/contrat/modify-contrat
    @Operation(description = "Modifier un contrat (l'id doit être présent dans le JSON)")
    @PutMapping("/modify-contrat")
    public Contrat modifyContrat(@Valid @RequestBody Contrat contrat) {
        return contratService.updateContrat(contrat);
    }

    // http://localhost:8089/contrat/remove-contrat/1
    @Operation(description = "Supprimer un contrat par son identifiant")
    @DeleteMapping("/remove-contrat/{contrat-id}")
    public void removeContrat(@PathVariable("contrat-id") Long contratId) {
        contratService.removeContrat(contratId);
    }
}
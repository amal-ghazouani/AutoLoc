package esprit.tn.projetsi.RestController;

import esprit.tn.projetsi.domain.Agence;
import esprit.tn.projetsi.services.IAgence;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Agence")
@RestController
@AllArgsConstructor
@RequestMapping("/agence")
public class AgenceController {

    IAgence agenceService;

    // http://localhost:8089/agence/retrieve-all-agences
    @Operation(description = "Récupérer toutes les agences de la base de données")
    @GetMapping("/retrieve-all-agences")
    public List<Agence> getAgences() {
        return agenceService.retrieveAllAgences();
    }

    // http://localhost:8089/agence/retrieve-agence/1
    @Operation(description = "Récupérer une agence par son identifiant")
    @GetMapping("/retrieve-agence/{agence-id}")
    public ResponseEntity<Agence> retrieveAgence(@PathVariable("agence-id") Long agenceId) {
        return agenceService.retrieveAgence(agenceId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // http://localhost:8089/agence/add-agence
    @Operation(description = "Ajouter une agence")
    @PostMapping("/add-agence")
    public Agence addAgence(@Valid @RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    // http://localhost:8089/agence/modify-agence
    @Operation(description = "Modifier une agence (l'id doit être présent dans le JSON)")
    @PutMapping("/modify-agence")
    public Agence modifyAgence(@Valid @RequestBody Agence agence) {
        return agenceService.updateAgence(agence);
    }

    // http://localhost:8089/agence/remove-agence/1
    @Operation(description = "Supprimer une agence par son identifiant")
    @DeleteMapping("/remove-agence/{agence-id}")
    public void removeAgence(@PathVariable("agence-id") Long agenceId) {
        agenceService.removeAgence(agenceId);
    }
}
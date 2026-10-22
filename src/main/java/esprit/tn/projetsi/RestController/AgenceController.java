package esprit.tn.projetsi.RestController;

import esprit.tn.projetsi.domain.Agence;
import esprit.tn.projetsi.services.IAgence;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Agence")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AgenceController {

    IAgence iAgence;

    @PostMapping("/AddAgence")
    public Agence addAgence(@Valid @RequestBody Agence agence) {
        return iAgence.addAgence(agence);
    }

    @GetMapping("/GetAll")
    public List<Agence> getAll() {
        return iAgence.retrieveAllAgences();
    }

    @GetMapping("/GetAgence/{id}")
    public ResponseEntity<Agence> getAgence(@PathVariable Long id) {
        return iAgence.retrieveAgence(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updateAgence")
    public Agence updateAgence(@RequestBody Agence agence) {
        return iAgence.updateAgence(agence);
    }

    @DeleteMapping("/deleteAgence/{id}")
    public void deleteAgence(@PathVariable Long id) {
        iAgence.removeAgence(id);
    }
}
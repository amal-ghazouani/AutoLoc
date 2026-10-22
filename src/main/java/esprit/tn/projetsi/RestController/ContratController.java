package esprit.tn.projetsi.RestController;

import esprit.tn.projetsi.domain.Contrat;
import esprit.tn.projetsi.services.IContrat;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Contrat")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ContratController {

    IContrat iContrat;

    @PostMapping("/AddContrat")
    public Contrat addContrat(@Valid @RequestBody Contrat contrat) {
        return iContrat.addContrat(contrat);
    }

    @GetMapping("/GetAll")
    public List<Contrat> getAll() {
        return iContrat.retrieveAllContrats();
    }

    @GetMapping("/GetContrat/{id}")
    public ResponseEntity<Contrat> getContrat(@PathVariable Long id) {
        return iContrat.retrieveContrat(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updateContrat")
    public Contrat updateContrat(@RequestBody Contrat contrat) {
        return iContrat.updateContrat(contrat);
    }

    @DeleteMapping("/deleteContrat/{id}")
    public void deleteContrat(@PathVariable Long id) {
        iContrat.removeContrat(id);
    }
}

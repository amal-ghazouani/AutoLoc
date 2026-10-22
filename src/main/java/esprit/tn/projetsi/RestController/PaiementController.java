package esprit.tn.projetsi.RestController;

import esprit.tn.projetsi.domain.Paiement;
import esprit.tn.projetsi.services.IPaiement;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Paiement")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaiementController {

    IPaiement iPaiement;

    @PostMapping("/AddPaiement")
    public Paiement addPaiement(@Valid @RequestBody Paiement paiement) {
        return iPaiement.addPaiement(paiement);
    }

    @GetMapping("/GetAll")
    public List<Paiement> getAll() {
        return iPaiement.retrieveAllPaiements();
    }

    @GetMapping("/GetPaiement/{id}")
    public ResponseEntity<Paiement> getPaiement(@PathVariable Long id) {
        return iPaiement.retrievePaiement(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updatePaiement")
    public Paiement updatePaiement(@RequestBody Paiement paiement) {
        return iPaiement.updatePaiement(paiement);
    }

    @DeleteMapping("/deletePaiement/{id}")
    public void deletePaiement(@PathVariable Long id) {
        iPaiement.removePaiement(id);
    }
}
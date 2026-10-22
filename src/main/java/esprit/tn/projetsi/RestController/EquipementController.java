package esprit.tn.projetsi.RestController;

import esprit.tn.projetsi.domain.Equipement;
import esprit.tn.projetsi.services.IEquipement;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Equipement")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EquipementController {

    IEquipement iEquipement;

    @PostMapping("/AddEquipement")
    public Equipement addEquipement(@Valid @RequestBody Equipement equipement) {
        return iEquipement.addEquipement(equipement);
    }

    @GetMapping("/GetAll")
    public List<Equipement> getAll() {
        return iEquipement.retrieveAllEquipements();
    }

    @GetMapping("/GetEquipement/{id}")
    public ResponseEntity<Equipement> getEquipement(@PathVariable Long id) {
        return iEquipement.retrieveEquipement(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updateEquipement")
    public Equipement updateEquipement(@RequestBody Equipement equipement) {
        return iEquipement.updateEquipement(equipement);
    }

    @DeleteMapping("/deleteEquipement/{id}")
    public void deleteEquipement(@PathVariable Long id) {
        iEquipement.removeEquipement(id);
    }
}
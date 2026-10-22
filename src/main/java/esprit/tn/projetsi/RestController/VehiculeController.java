package esprit.tn.projetsi.RestController;

import esprit.tn.projetsi.domain.Vehicule;
import esprit.tn.projetsi.services.IVehicule;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Vehicule")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VehiculeController {

    IVehicule iVehicule;

    @PostMapping("/AddVehicule")
    public Vehicule addVehicule(@Valid @RequestBody Vehicule vehicule) {
        return iVehicule.addVehicule(vehicule);
    }

    @GetMapping("/GetAll")
    public List<Vehicule> getAll() {
        return iVehicule.retrieveAllVehicules();
    }

    @GetMapping("/GetVehicule/{id}")
    public ResponseEntity<Vehicule> getVehicule(@PathVariable Long id) {
        return iVehicule.retrieveVehicule(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updateVehicule")
    public Vehicule updateVehicule(@RequestBody Vehicule vehicule) {
        return iVehicule.updateVehicule(vehicule);
    }

    @DeleteMapping("/deleteVehicule/{id}")
    public void deleteVehicule(@PathVariable Long id) {
        iVehicule.removeVehicule(id);
    }
}
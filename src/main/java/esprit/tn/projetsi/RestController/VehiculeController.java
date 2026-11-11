
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

    // CREATE
    @PostMapping("/AddVehicule")
    public Vehicule addVehicule(@Valid @RequestBody Vehicule vehicule) {
        return iVehicule.addVehicule(vehicule);
    }
    // 2. DESAFFECTER UN VEHICULE DE SON AGENCE
    @PutMapping("/desaffecterVehicule/{idVehicule}")
    public ResponseEntity<Void> desaffecterVehicule(
            @PathVariable Long idVehicule) {

        iVehicule.desaffecterVehicule(idVehicule);

        return ResponseEntity.noContent().build();
    }

    // READ ALL
    @GetMapping("/GetAll")
    public List<Vehicule> getAll() {
        return iVehicule.retrieveAllVehicules();
    }

    // READ BY ID
    @GetMapping("/GetVehicule/{id}")
    public ResponseEntity<Vehicule> getVehicule(@PathVariable Long id) {
        return iVehicule.retrieveVehicule(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/updateVehicule")
    public Vehicule updateVehicule(@RequestBody Vehicule vehicule) {
        return iVehicule.updateVehicule(vehicule);
    }

    // DELETE
    @DeleteMapping("/deleteVehicule/{id}")
    public void deleteVehicule(@PathVariable Long id) {
        iVehicule.removeVehicule(id);
    }

    // 1. AFFECTER UN VEHICULE A UNE AGENCE
    @PutMapping("/affecterVehicule/{idVehicule}/{idAgence}")
    public Vehicule affecterVehicule(
            @PathVariable Long idVehicule,
            @PathVariable Long idAgence) {

        return iVehicule.affecterVehicule(idVehicule, idAgence);
    }

    // 2. AFFECTER UN EQUIPEMENT A UN VEHICULE
    @PutMapping("/affecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule affecterEquipement(
            @PathVariable Long idVehicule,
            @PathVariable Long idEquipement) {

        return iVehicule.affecterEquipement(idVehicule, idEquipement);
    }

    // 3. DESAFFECTER UN EQUIPEMENT D'UN VEHICULE
    @PutMapping("/desaffecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule desaffecterEquipement(
            @PathVariable Long idVehicule,
            @PathVariable Long idEquipement) {

        return iVehicule.desaffecterEquipement(idVehicule, idEquipement);
    }
}

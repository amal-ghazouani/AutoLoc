package esprit.tn.projetsi.RestController;

import esprit.tn.projetsi.domain.Maintenance;
import esprit.tn.projetsi.services.IMaintenance;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Maintenance")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MaintenanceController {

    IMaintenance iMaintenance;

    @PostMapping("/AddMaintenance")
    public Maintenance addMaintenance(@Valid @RequestBody Maintenance maintenance) {
        return iMaintenance.addMaintenance(maintenance);
    }

    @GetMapping("/GetAll")
    public List<Maintenance> getAll() {
        return iMaintenance.retrieveAllMaintenances();
    }

    @GetMapping("/GetMaintenance/{id}")
    public ResponseEntity<Maintenance> getMaintenance(@PathVariable Long id) {
        return iMaintenance.retrieveMaintenance(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updateMaintenance")
    public Maintenance updateMaintenance(@RequestBody Maintenance maintenance) {
        return iMaintenance.updateMaintenance(maintenance);
    }

    @DeleteMapping("/deleteMaintenance/{id}")
    public void deleteMaintenance(@PathVariable Long id) {
        iMaintenance.removeMaintenance(id);
    }
}
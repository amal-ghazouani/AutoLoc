package esprit.tn.projetsi.RestController;

import esprit.tn.projetsi.domain.Employe;
import esprit.tn.projetsi.services.IEmploye;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Employe")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeController {

    IEmploye iEmploye;

    @PostMapping("/AddEmploye")
    public Employe addEmploye(@Valid @RequestBody Employe employe) {
        return iEmploye.addEmploye(employe);
    }

    @GetMapping("/GetAll")
    public List<Employe> getAll() {
        return iEmploye.retrieveAllEmployes();
    }

    @GetMapping("/GetEmploye/{id}")
    public ResponseEntity<Employe> getEmploye(@PathVariable Long id) {
        return iEmploye.retrieveEmploye(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updateEmploye")
    public Employe updateEmploye(@RequestBody Employe employe) {
        return iEmploye.updateEmploye(employe);
    }

    @DeleteMapping("/deleteEmploye/{id}")
    public void deleteEmploye(@PathVariable Long id) {
        iEmploye.removeEmploye(id);
    }
}
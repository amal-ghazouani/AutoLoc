
package esprit.tn.projetsi.services;

import esprit.tn.projetsi.Repository.EmployeRepository;
import esprit.tn.projetsi.Repository.AgenceRepository;
import esprit.tn.projetsi.domain.Employe;
import esprit.tn.projetsi.domain.Agence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmploye {

    private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;

    @Override
    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> retrieveAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Optional<Employe> retrieveEmploye(Long idEmploye) {
        return employeRepository.findById(idEmploye);
    }

    @Override
    public Employe updateEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public void removeEmploye(Long idEmploye) {
        employeRepository.deleteById(idEmploye);
    }

    // 1. DESAFFECTER UN EMPLOYE DE SON AGENCE
    @Override
    @Transactional
    public Employe desaffecterEmploye(Long idEmploye) {

        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() ->
                        new RuntimeException("Employe introuvable"));

        employe.setAgence(null);

        return employeRepository.save(employe);
    }

    // 2. AFFECTER UN EMPLOYE A UNE AGENCE
    @Override
    @Transactional
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {

        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() ->
                        new RuntimeException("Employe introuvable"));

        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() ->
                        new RuntimeException("Agence introuvable"));

        employe.setAgence(agence);

        return employeRepository.save(employe);
    }
}

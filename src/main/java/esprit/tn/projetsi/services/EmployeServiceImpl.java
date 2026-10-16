package esprit.tn.projetsi.services;

import esprit.tn.projetsi.Repository.EmployeRepository;
import esprit.tn.projetsi.domain.Employe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmploye {

    private final EmployeRepository employeRepository;

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
}
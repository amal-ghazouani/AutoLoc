package esprit.tn.projetsi.services;

import esprit.tn.projetsi.domain.Employe;

import java.util.List;
import java.util.Optional;

public interface IEmploye {

    // CREATE
    Employe addEmploye(Employe employe);

    // READ
    List<Employe> retrieveAllEmployes();

    Optional<Employe> retrieveEmploye(Long idEmploye);

    // UPDATE
    Employe updateEmploye(Employe employe);

    // DELETE
    void removeEmploye(Long idEmploye);
}
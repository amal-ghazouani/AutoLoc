package esprit.tn.projetsi.services;

import esprit.tn.projetsi.domain.Contrat;

import java.util.List;
import java.util.Optional;

public interface IContrat {

    // CREATE
    Contrat addContrat(Contrat contrat);

    // READ
    List<Contrat> retrieveAllContrats();

    Optional<Contrat> retrieveContrat(Long idContrat);

    // UPDATE
    Contrat updateContrat(Contrat contrat);

    // DELETE
    void removeContrat(Long idContrat);
}

package esprit.tn.projetsi.services;

import esprit.tn.projetsi.domain.Paiement;

import java.util.List;
import java.util.Optional;

public interface IPaiement {

    // CREATE
    Paiement addPaiement(Paiement paiement);

    // READ
    List<Paiement> retrieveAllPaiements();

    Optional<Paiement> retrievePaiement(Long idPaiement);

    // UPDATE
    Paiement updatePaiement(Paiement paiement);

    // DELETE
    void removePaiement(Long idPaiement);
}

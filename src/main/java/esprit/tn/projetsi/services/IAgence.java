package esprit.tn.projetsi.services;

import esprit.tn.projetsi.domain.Agence;

import java.util.List;
import java.util.Optional;

public interface IAgence {

    // CREATE
    Agence addAgence(Agence agence);

    // READ
    List<Agence> retrieveAllAgences();

    Optional<Agence> retrieveAgence(Long idAgence);

    // UPDATE
    Agence updateAgence(Agence agence);

    // DELETE
    void removeAgence(Long idAgence);
}
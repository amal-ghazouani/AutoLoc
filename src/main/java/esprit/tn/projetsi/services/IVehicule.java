package esprit.tn.projetsi.services;

import esprit.tn.projetsi.domain.Vehicule;

import java.util.List;
import java.util.Optional;

public interface IVehicule {

    // CREATE
    Vehicule addVehicule(Vehicule vehicule);

    // READ
    List<Vehicule> retrieveAllVehicules();

    Optional<Vehicule> retrieveVehicule(Long idVehicule);

    // UPDATE
    Vehicule updateVehicule(Vehicule vehicule);

    // DELETE
    void removeVehicule(Long idVehicule);
}
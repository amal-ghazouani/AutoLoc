
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

    // AFFECTATION ET DESAFFECTATION

    // Affecter un véhicule à une agence
    Vehicule affecterVehicule(Long idVehicule, Long idAgence);

    // Désaffecter un véhicule de son agence
    void desaffecterVehicule(Long idVehicule);

    // Affecter un équipement à un véhicule
    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);

    // Désaffecter un équipement d'un véhicule
    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);
}

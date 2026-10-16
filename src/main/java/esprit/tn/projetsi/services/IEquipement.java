package esprit.tn.projetsi.services;

import esprit.tn.projetsi.domain.Equipement;

import java.util.List;
import java.util.Optional;

public interface IEquipement {

    // CREATE
    Equipement addEquipement(Equipement equipement);

    // READ
    List<Equipement> retrieveAllEquipements();

    Optional<Equipement> retrieveEquipement(Long idEquipement);

    // UPDATE
    Equipement updateEquipement(Equipement equipement);

    // DELETE
    void removeEquipement(Long idEquipement);
}
package esprit.tn.projetsi.services;

import esprit.tn.projetsi.domain.Maintenance;

import java.util.List;
import java.util.Optional;

public interface IMaintenance {

    // CREATE
    Maintenance addMaintenance(Maintenance maintenance);

    // READ
    List<Maintenance> retrieveAllMaintenances();

    Optional<Maintenance> retrieveMaintenance(Long idMaintenance);

    // UPDATE
    Maintenance updateMaintenance(Maintenance maintenance);

    // DELETE
    void removeMaintenance(Long idMaintenance);
}
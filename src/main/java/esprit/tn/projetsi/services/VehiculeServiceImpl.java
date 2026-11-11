
package esprit.tn.projetsi.services;

import esprit.tn.projetsi.Repository.VehiculeRepository;
import esprit.tn.projetsi.Repository.AgenceRepository;
import esprit.tn.projetsi.Repository.EquipementRepository;
import esprit.tn.projetsi.domain.Vehicule;
import esprit.tn.projetsi.domain.Agence;
import esprit.tn.projetsi.domain.Equipement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehicule {

    private final VehiculeRepository vehiculeRepository;
    private final AgenceRepository agenceRepository;
    private final EquipementRepository equipementRepository;

    // CREATE
    @Override
    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    // READ
    @Override
    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Optional<Vehicule> retrieveVehicule(Long idVehicule) {
        return vehiculeRepository.findById(idVehicule);
    }

    // UPDATE
    @Override
    public Vehicule updateVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    // DELETE
    @Override
    public void removeVehicule(Long idVehicule) {
        vehiculeRepository.deleteById(idVehicule);
    }

    // 1. AFFECTER UN VEHICULE A UNE AGENCE
    @Override
    @Transactional
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence) {

        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() ->
                        new RuntimeException("Vehicule introuvable"));

        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() ->
                        new RuntimeException("Agence introuvable"));

        vehicule.setAgence(agence);

        return vehiculeRepository.save(vehicule);
    }

    // 2. DESAFFECTER UN VEHICULE DE SON AGENCE
    @Override
    @Transactional
    public void desaffecterVehicule(Long idVehicule) {

        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() ->
                        new RuntimeException("Vehicule introuvable"));

        vehicule.setAgence(null);

        vehiculeRepository.save(vehicule);
    }

    // 3. AFFECTER UN EQUIPEMENT A UN VEHICULE
    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {

        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() ->
                        new RuntimeException("Vehicule introuvable"));

        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() ->
                        new RuntimeException("Equipement introuvable"));

        vehicule.getEquipements().add(equipement);
        equipement.getVehicules().add(vehicule);

        return vehiculeRepository.save(vehicule);
    }

    // 4. DESAFFECTER UN EQUIPEMENT D'UN VEHICULE
    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {

        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() ->
                        new RuntimeException("Vehicule introuvable"));

        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() ->
                        new RuntimeException("Equipement introuvable"));

        vehicule.getEquipements().remove(equipement);
        equipement.getVehicules().remove(vehicule);

        return vehiculeRepository.save(vehicule);
    }
}

package esprit.tn.projetsi.services;

import esprit.tn.projetsi.Repository.EquipementRepository;
import esprit.tn.projetsi.domain.Equipement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipement {

    private final EquipementRepository equipementRepository;

    @Override
    public Equipement addEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public List<Equipement> retrieveAllEquipements() {
        return equipementRepository.findAll();
    }

    @Override
    public Optional<Equipement> retrieveEquipement(Long idEquipement) {
        return equipementRepository.findById(idEquipement);
    }

    @Override
    public Equipement updateEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public void removeEquipement(Long idEquipement) {
        equipementRepository.deleteById(idEquipement);
    }
}
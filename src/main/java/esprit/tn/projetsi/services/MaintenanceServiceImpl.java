package esprit.tn.projetsi.services;

import esprit.tn.projetsi.Repository.MaintenanceRepository;
import esprit.tn.projetsi.domain.Maintenance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenance {

    private final MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance addMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public List<Maintenance> retrieveAllMaintenances() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Optional<Maintenance> retrieveMaintenance(Long idMaintenance) {
        return maintenanceRepository.findById(idMaintenance);
    }

    @Override
    public Maintenance updateMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void removeMaintenance(Long idMaintenance) {
        maintenanceRepository.deleteById(idMaintenance);
    }
}

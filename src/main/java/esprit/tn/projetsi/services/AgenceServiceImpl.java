package esprit.tn.projetsi.services;

import esprit.tn.projetsi.Repository.AgenceRepository;
import esprit.tn.projetsi.domain.Agence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgence {

    private final AgenceRepository agenceRepository;

    @Override
    public Agence addAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> retrieveAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Optional<Agence> retrieveAgence(Long idAgence) {
        return agenceRepository.findById(idAgence);
    }

    @Override
    public Agence updateAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void removeAgence(Long idAgence) {
        agenceRepository.deleteById(idAgence);
    }
}
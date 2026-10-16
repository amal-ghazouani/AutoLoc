package esprit.tn.projetsi.services;

import esprit.tn.projetsi.Repository.ContratRepository;
import esprit.tn.projetsi.domain.Contrat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContrat {

    private final ContratRepository contratRepository;

    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Optional<Contrat> retrieveContrat(Long idContrat) {
        return contratRepository.findById(idContrat);
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void removeContrat(Long idContrat) {
        contratRepository.deleteById(idContrat);
    }
}

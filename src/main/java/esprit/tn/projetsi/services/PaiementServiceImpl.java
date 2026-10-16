package esprit.tn.projetsi.services;

import esprit.tn.projetsi.Repository.PaiementRepository;
import esprit.tn.projetsi.domain.Paiement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiement {

    private final PaiementRepository paiementRepository;

    @Override
    public Paiement addPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public List<Paiement> retrieveAllPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Optional<Paiement> retrievePaiement(Long idPaiement) {
        return paiementRepository.findById(idPaiement);
    }

    @Override
    public Paiement updatePaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public void removePaiement(Long idPaiement) {
        paiementRepository.deleteById(idPaiement);
    }
}

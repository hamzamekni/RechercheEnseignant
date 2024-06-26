package com.pfe.rechercheens.ServiceImpl;

import com.pfe.rechercheens.Entity.Paiement;
import com.pfe.rechercheens.Repository.PaiementRepository;
import com.pfe.rechercheens.Service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaiementServiceImpl implements PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    @Override
    public Paiement savePaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement updatePaiement(Long id, Paiement updatedPaiement) {
        Paiement existingPaiement = paiementRepository.findById(id).orElse(null);
        if (existingPaiement != null) {
            updatedPaiement.setPaiementId(existingPaiement.getPaiementId());
            return paiementRepository.save(updatedPaiement);
        }
        return null;
    }

    @Override
    public void deletePaiement(Long id) {
        paiementRepository.deleteById(id);
    }

    @Override
    public Paiement getPaiementById(Long id) {
        return paiementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }
}


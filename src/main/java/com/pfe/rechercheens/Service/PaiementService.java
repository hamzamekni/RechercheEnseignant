package com.pfe.rechercheens.Service;

import com.pfe.rechercheens.Entity.Paiement;

import java.util.List;

public interface PaiementService {
    Paiement savePaiement(Paiement paiement);
    Paiement updatePaiement(Long id, Paiement updatedPaiement);
    void deletePaiement(Long id);
    Paiement getPaiementById(Long id);
    List<Paiement> getAllPaiements();
}

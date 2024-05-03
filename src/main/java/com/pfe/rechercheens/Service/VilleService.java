package com.pfe.rechercheens.Service;

import com.pfe.rechercheens.Entity.Ville;

import java.util.List;

public interface VilleService {
    List<Ville> getAllVilles();
    Ville getVilleById(Long id);
    Ville saveVille(Ville ville);
    Ville updateVille(Long id, Ville updatedVille);
    void deleteVilleById(Long id);
}
